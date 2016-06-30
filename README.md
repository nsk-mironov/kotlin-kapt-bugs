Kotlin: Incremental compilation + kapt bugs
===========================================

Steps to reproduce:

1. `$ git clone https://github.com/nsk-mironov/kotlin-ic-kapt-bugs`
2. `$ cd kotlin-ic-kapt-bugs`
3. `$ ./gradlew assembleDebug`
4. Change something in EventQueue.kt
5. `$ ./gradlew assembleDebug`
6. Build fails with `Cannot access 'Event': it is 'internal' in 'ic'`
