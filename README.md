Kotlin Kapt Bugs
===========================================

Steps to reproduce:

- `$ git clone https://github.com/nsk-mironov/kotlin-kapt-bugs`
- `$ cd kotlin-kapt-bugs`
- `$ git checkout KT-14991`
- `$ ./gradlew clean assembleDebug`
```
error: duplicate class: com.github.vmironov.ic.ic
error: /Users/mironov/Development/research/kotlin-kapt-bugs/app/src/main/java/com/github/vmironov/ic/CrashMe.kt: (1, 1): Some error(s) occurred while processing annotations.
```
