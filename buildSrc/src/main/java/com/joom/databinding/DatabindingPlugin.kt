package com.joom.databinding

import com.android.build.gradle.AppPlugin
import com.android.build.gradle.BasePlugin
import com.android.build.gradle.LibraryPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project

class DatabindingPlugin : Plugin<Project> {
  override fun apply(project: Project) {
    val plugin = findAndroidPlugin(project)
    val android = plugin.extension

    project.configurations.forEach { configuration ->
      configuration.exclude(
          mapOf(
              "group" to "androidx.databinding",
              "module" to "databinding-compiler"
          )
      )
    }

    android.registerTransform(DatabindingTransform(android))
  }

  private fun findAndroidPlugin(project: Project): BasePlugin<*> {
    return project.findPlugin<AppPlugin>()
        ?: project.findPlugin<LibraryPlugin>()
        ?: error("'android' or 'android-library' plugin required")
  }

  private inline fun <reified T : Plugin<*>> Project.findPlugin(): T? {
    return plugins.findPlugin(T::class.java)
  }
}
