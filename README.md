Kotlin Kapt Bugs
===========================================

Steps to reproduce:

- `$ git clone https://github.com/nsk-mironov/kotlin-kapt-bugs`
- `$ cd kotlin-kapt-bugs`
- `$ git checkout KT-15433`
- `./gradlew clean assembleDebug`
- Build fails with
```
:app:kaptDebugKotlin
e: [kapt] An exception occurred: 
e: /Users/mironov/Development/research/kotlin-kapt-bugs/app/src/main/java/com/github/vmirono/ic/Hello.kt: (1, 1): Some error(s) occurred while processing annotations. Please see the error messages above.
```
- There isn't any error message above as it's swallowed by Kotlin daemon
- Building the project with `-Dkotlin.compiler.execution.strategy=out-of-process` flag will print the real error
