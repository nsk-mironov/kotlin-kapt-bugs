Kotlin Kapt Bugs
===========================================

Steps to reproduce:

- `$ git clone https://github.com/nsk-mironov/kotlin-kapt-bugs`
- `$ cd kotlin-kapt-bugs`
- `$ git checkout KT-15397`
- `./gradlew clean assembleDebug -Dkotlin.compiler.execution.strategy=out-of-process`
- Build fails with
```
error: Could not write to com.android.databinding.library.baseAdapters.BR javax.annotation.processing.FilerException: Attempt to recreate a file for type com.android.databinding.library.baseAdapters.BR
        at com.sun.tools.javac.processing.JavacFiler.checkNameAndExistence(JavacFiler.java:522)
        at com.sun.tools.javac.processing.JavacFiler.createSourceOrClassFile(JavacFiler.java:396)
        at com.sun.tools.javac.processing.JavacFiler.createSourceFile(JavacFiler.java:378)
        at android.databinding.tool.writer.AnnotationJavaFileWriter.writeToFile(AnnotationJavaFileWriter.java:41)
        at android.databinding.annotationprocessor.ProcessBindable.generateBRClasses(ProcessBindable.java:123)
        at android.databinding.annotationprocessor.ProcessBindable.onHandleStep(ProcessBindable.java:84)
        at android.databinding.annotationprocessor.ProcessDataBinding$ProcessingStep.runStep(ProcessDataBinding.java:154)
        at android.databinding.annotationprocessor.ProcessDataBinding$ProcessingStep.access$000(ProcessDataBinding.java:139)
        at android.databinding.annotationprocessor.ProcessDataBinding.process(ProcessDataBinding.java:66)
        at com.sun.tools.javac.processing.JavacProcessingEnvironment.callProcessor(JavacProcessingEnvironment.java:794)
        at com.sun.tools.javac.processing.JavacProcessingEnvironment.discoverAndRunProcs(JavacProcessingEnvironment.java:705)
        at com.sun.tools.javac.processing.JavacProcessingEnvironment.access$1800(JavacProcessingEnvironment.java:91)
        at com.sun.tools.javac.processing.JavacProcessingEnvironment$Round.run(JavacProcessingEnvironment.java:1035)
        at com.sun.tools.javac.processing.JavacProcessingEnvironment.doProcessing(JavacProcessingEnvironment.java:1176)
        at com.sun.tools.javac.main.JavaCompiler.processAnnotations(JavaCompiler.java:1170)
        at com.sun.tools.javac.main.JavaCompiler.processAnnotations(JavaCompiler.java:1068)
        at org.jetbrains.kotlin.kapt3.AnnotationProcessingKt.doAnnotationProcessing(annotationProcessing.kt:81)
```
