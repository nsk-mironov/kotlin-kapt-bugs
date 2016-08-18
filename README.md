Kotlin Kapt Bugs
===========================================

Steps to reproduce:

- `$ git clone https://github.com/nsk-mironov/kotlin-kapt-bugs`
- `$ cd kotlin-kapt-bugs`
- `$ git checkout KT-14995`
- `$ ./gradlew clean assembleDebug`
```
error: variable position is already defined in method crashMe(CrashMe,int)
```
