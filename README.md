Kotlin Bugs
===========================================

Steps to reproduce:

1. `$ git clone https://github.com/nsk-mironov/kotlin-kapt-bugs.git`
2. `$ cd kotlin-kapt-bugs`
3. `$ git checkout KT-14308`
4. Open the project in Android Studio
5. Open `MainActivity.kt`
6. Wait for syntax highlighter to complete its job
7. The moment after source code is fully highlighted, the IDE will freeze for a few seconds.

You might need to repeat the instruction a few times as it's not 100% reproducible. It's not the only way to reproduce the issue, the IDE freezes in a variety of different scenarios, but I wasn't able to find any another scenario which is more or less reproducible.
