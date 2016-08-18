Kotlin Kapt Bugs
===========================================

Steps to reproduce:

- `$ git clone https://github.com/nsk-mironov/kotlin-kapt-bugs`
- `$ cd kotlin-kapt-bugs`
- `$ git checkout KT-XXX`
- `$ ./gradlew clean assembleDebug`
- `$ git checkout HEAD~`
- `$ ./gradlew assembleDebug`
```
e: /Users/mironov/Development/research/kotlin-kapt-bugs/app/build/tmp/kapt3/stubs/debug/com/github/vmironov/ic/CrashMeImpl.java:3: error: interface expected here
e:

e: public final class CrashMeImpl implements com.github.vmironov.ic.CrashMe {
e:                                                                 ^
e: /Users/mironov/Development/research/kotlin-kapt-bugs/app/src/main/java/com/github/vmironov/ic/CrashMe.kt: (1, 1): Some error(s) occurred while processing annotations. Please see the error messages above.

```
