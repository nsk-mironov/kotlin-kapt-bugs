Kotlin Kapt Bugs
===========================================

Steps to reproduce:

- `$ git clone https://github.com/nsk-mironov/kotlin-kapt-bugs`
- `$ cd kotlin-kapt-bugs`
- `$ git checkout KT-14998`
- `$ ./gradlew clean assembleDebug`
```
error: variable bar is already defined in constructor CrashMe.Hello(String,String)
```
