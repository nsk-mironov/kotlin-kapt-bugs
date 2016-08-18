Kotlin Kapt Bugs
===========================================

Steps to reproduce:

- `$ git clone https://github.com/nsk-mironov/kotlin-kapt-bugs`
- `$ cd kotlin-kapt-bugs`
- `$ git checkout KT-14996`
- `$ ./gradlew clean assembleDebug`
```
error: name clash: crashMe(List<? extends CharSequence>) and crashMe(List<String>) have the same erasure
```
