Kotlin Kapt Bugs
===========================================

Steps to reproduce:

- `$ git clone https://github.com/nsk-mironov/kotlin-kapt-bugs`
- `$ cd kotlin-kapt-bugs`
- `$ git checkout KT-17200`
- `$ ./gradlew clean assembleDebug`
```
* What went wrong:
Execution failed for task ':app:transformClassesWithDexForDebug'.
> com.android.build.api.transform.TransformException: java.lang.RuntimeException: com.android.ide.common.process.ProcessException: java.util.concurrent.ExecutionException: com.android.ide.common.process.ProcessException: Return code 1 for dex process

```
