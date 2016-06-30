package com.joom.databinding

import android.databinding.annotationprocessor.ProcessDataBinding
import com.android.build.api.transform.QualifiedContent
import com.android.build.api.transform.Transform
import com.android.build.api.transform.TransformInvocation
import com.android.build.gradle.AppExtension
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.api.BaseVariant
import com.joom.databinding.utils.TransformSet
import com.joom.databinding.utils.copyInputsToOutputs
import com.joom.databinding.utils.getClasspath
import io.michaelrocks.grip.GripFactory
import io.michaelrocks.grip.classes
import org.gradle.api.DomainObjectSet
import java.io.File
import java.util.EnumSet
import java.util.Locale
import javax.tools.DiagnosticCollector
import javax.tools.JavaFileObject
import javax.tools.StandardLocation
import javax.tools.ToolProvider

class DatabindingTransform(
    private val android: BaseExtension
) : Transform() {

  override fun transform(invocation: TransformInvocation) {
    val transformSet = TransformSet.create(invocation, android.bootClasspath)

    if (!invocation.isIncremental) {
      invocation.outputProvider.deleteAll()
    }

    transformSet.copyInputsToOutputs()

    val outputSources = File(invocation.context.temporaryDir, "sources")
    val outputClasses = transformSet.units.first().output

    if (!outputClasses.exists()) {
      if (!outputClasses.mkdirs()) {
        error("Unable to create output directory $outputClasses")
      }
    }

    if (!outputSources.exists()) {
      if (!outputSources.mkdirs()) {
        error("Unable to create output directory $outputSources")
      }
    }

    val pathClasses = transformSet.referencedUnits
        .plus(transformSet.units)
        .map { it.input }
        .distinct()

    val compiler = ToolProvider.getSystemJavaCompiler()
    val diagnostics = DiagnosticCollector<JavaFileObject>()
    val fileManager = compiler.getStandardFileManager(diagnostics, null, null)

    fileManager.setLocation(StandardLocation.SOURCE_PATH, emptyList())
    fileManager.setLocation(StandardLocation.SOURCE_OUTPUT, listOf(outputSources))

    fileManager.setLocation(StandardLocation.CLASS_PATH, pathClasses)
    fileManager.setLocation(StandardLocation.CLASS_OUTPUT, listOf(outputClasses))
    fileManager.setLocation(StandardLocation.PLATFORM_CLASS_PATH, transformSet.bootClasspath)

    val classesToProcess = computeClassesToProcess(transformSet)
    val compileOptions = computeCompileOptions(invocation)

    val task = compiler.getTask(null, fileManager, diagnostics, compileOptions, classesToProcess, null)
    val processors = listOf(ProcessDataBinding())

    task.setProcessors(processors)

    if (!task.call()) {
      error(diagnostics.diagnostics.joinToString(separator = "\n") {
        it.getMessage(Locale.US)
      })
    }
  }

  override fun getInputTypes(): MutableSet<QualifiedContent.ContentType> {
    return mutableSetOf(QualifiedContent.DefaultContentType.CLASSES)
  }

  override fun getScopes(): MutableSet<in QualifiedContent.Scope> {
    return EnumSet.of(
        QualifiedContent.Scope.PROJECT
    )
  }

  override fun getReferencedScopes(): MutableSet<in QualifiedContent.Scope> {
    return EnumSet.of(
        QualifiedContent.Scope.SUB_PROJECTS,
        QualifiedContent.Scope.EXTERNAL_LIBRARIES,
        QualifiedContent.Scope.PROVIDED_ONLY
    )
  }

  override fun getName(): String {
    return "Databinding"
  }

  override fun isIncremental(): Boolean {
    return false
  }

  private fun computeCompileOptions(invocation: TransformInvocation): List<String> {
    val options = ArrayList<String>()

    options += "-g"
    options += "-source"
    options += "6"
    options += "-target"
    options += "6"

    android.variants.find { it.name == invocation.context.variantName }?.let { variant ->
      val annotationProcessorOptions = variant.javaCompileOptions.annotationProcessorOptions

      annotationProcessorOptions.arguments.forEach { (key, value) ->
        options += "-A$key"
        options += value
      }

      annotationProcessorOptions.compilerArgumentProviders.forEach { provider ->
        options += provider.asArguments()
      }
    }

    return options
  }

  private fun computeClassesToProcess(transformSet: TransformSet): List<String> {
    return GripFactory.create(transformSet.getClasspath()).use { grip ->
      grip.select(classes)
          .from(transformSet.units.map { it.input })
          .where { _, _ -> true }
          .execute()
          .classes
          .map {
            it.name
          }
    }
  }

  @Suppress("UNCHECKED_CAST")
  private val BaseExtension.variants: DomainObjectSet<BaseVariant>
    get() = when (this) {
      is AppExtension -> applicationVariants as DomainObjectSet<BaseVariant>
      is LibraryExtension -> libraryVariants as DomainObjectSet<BaseVariant>
      else -> error("Unsupported extension $this")
    }
}
