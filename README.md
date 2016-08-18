Kotlin Kapt Bugs
===========================================

Steps to reproduce:

- `$ git clone https://github.com/nsk-mironov/kotlin-kapt-bugs`
- `$ cd kotlin-kapt-bugs`
- `$ git checkout KT-14997`
- `$ ./gradlew clean assembleDebug`
- Everything compiles fine, but there is the following error in the log
```
error: cannot find symbol
  symbol:   class CrashMe$notReally$1
  location: package com.github.vmironov.ic
```
