Kotlin Kapt Bugs
===========================================

Steps to reproduce:

- `$ git clone https://github.com/nsk-mironov/kotlin-kapt-bugs`
- `$ cd kotlin-kapt-bugs`
- `$ git checkout kapt/kapt2`
- `$ ./gradlew clean assembleDebug`
- Build fails with (unrelated to this issue, see https://youtrack.jetbrains.com/issue/KT-14251)
```
Execution failed for task ':app:compileDebugKotlin'.
> java.io.FileNotFoundException: /Users/mironov/Development/research/kotlin-kapt-bugs/app/build/kotlin/compileDebugKotlin/last-build.bin (No such file or directory)
```
- Switch to kapt1. Open `app/build.gradle` and replace `apply plugin: 'kotlin-kapt'` with:
```
kapt {
	generateStubs = true
}
```
- `$ ./gradlew clean assembleDebug`
- Build fails with: `ERROR: Cannot load extensions/common.xml`