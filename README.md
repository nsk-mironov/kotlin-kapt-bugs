Kotlin Kapt Bugs
===========================================

Steps to reproduce:

1. `$ git clone https://github.com/nsk-mironov/kotlin-kapt-bugs`
2. `$ cd kotlin-kapt-bugs`
3. `$ git checkout KT-23454`
4. `$ ./gradlew clean assembleDebug --debug`
5. Open `MainActivity.kt`
6. Replace `"333-333"` with something else
7. `$ ./gradlew assembleDebug --debug`
8.
```
Task ':app:kaptDebugKotlin' is not up-to-date because:
  Input property 'source' file /Users/mironov/Development/kotlin-kapt-bugs/app/build/tmp/kapt3/stubs/debug/com/github/vmironov/ic/MainActivity.kapt_metadata has changed.
  Input property 'source' file /Users/mironov/Development/kotlin-kapt-bugs/app/build/tmp/kapt3/stubs/debug/com/github/vmironov/ic/MainActivityKt.kapt_metadata has changed.
```
