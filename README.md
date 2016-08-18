Kotlin Kapt Bugs
===========================================

Steps to reproduce:

1. `$ git clone https://github.com/nsk-mironov/kotlin-kapt-bugs`
2. `$ cd kotlin-kapt-bugs`
3. `$ ./gradlew clean assembleDebug`
4. Open `activity_main.xml`
5. Add `android:text="123"` attribute
6. `$ ./gradlew assembleDebug`
7. Build fails with
```
Execution failed for task ':app:compileDebugJavaWithJavac'.
> java.lang.RuntimeException: Found data binding errors.
  Cannot find the setter for attribute 'binding:font' with parameter type java.lang.String on android.widget.TextView.
  file:///Users/mironov/Development/research/kotlin-kapt-bugs/app/src/main/res/layout/activity_main.xml Line:14
```
