Kotlin Kapt Bugs
===========================================

Steps to reproduce:

1. `$ git clone https://github.com/nsk-mironov/kotlin-kapt-bugs`
2. `$ cd kotlin-kapt-bugs`
3. `$ git checkout kapt2`
4. `$ ./gradlew clean assembleDebug`
5. Build fails with
```
Execution failed for task ':app:compileDebugKotlin'.
> java.io.FileNotFoundException: /Users/mironov/Development/research/kotlin-kapt-bugs/app/build/kotlin/compileDebugKotlin/last-build.bin (No such file or directory)
```
