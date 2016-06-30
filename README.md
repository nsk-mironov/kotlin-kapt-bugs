Kotlin Kapt Bugs
===========================================

Steps to reproduce:

1. `$ git clone https://github.com/nsk-mironov/kotlin-kapt-bugs`
2. `$ cd kotlin-kapt-bugs`
3. `$ git checkout KT-25374`
4. `$ ./gradlew clean assembleDebug`
5. Build fails because there are some incorrect usages of databinding and the error message has some really helpful information like:
```
Cannot find the setter for attribute 'binding:fail' with parameter type boolean on android.widget.TextView.
file:///Users/vmironov/Development/kotlin-kapt-bugs/app/src/main/res/layout/activity_main.xml Line:7
```
6. Open `gradle.properties` and change `kapt.use.worker.api` value to `true`
7. `$ ./gradlew clean assembleDebug`
8. Now the error message is swallowed and isn't really helpful:
```
> Task :app:kaptDebugKotlin FAILED
/Users/vmironov/Development/kotlin-kapt-bugs/app/build/generated/source/kapt/debug/com/github/vmironov/ic/DataBinderMapperImpl.java:9: error: cannot find symbol
import com.github.vmironov.ic.databinding.ActivityMainBindingImpl;
                                         ^
  symbol:   class ActivityMainBindingImpl
  location: package com.github.vmironov.ic.databinding
FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':app:kaptDebugKotlin'.
> A failure occurred while executing org.jetbrains.kotlin.gradle.internal.KaptExecution
   > java.lang.reflect.InvocationTargetException (no error message)
```