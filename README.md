Kotlin Kapt Bugs
===========================================

Steps to reproduce:

- `$ git clone https://github.com/nsk-mironov/kotlin-kapt-bugs`
- `$ cd kotlin-kapt-bugs`
- `$ git checkout KT-16193`
- `$ ./gradlew clean run`
- Project compiles and runs fine
- Open `Main.kt`
- Remove `var crashMe2 by crashMe(factory)` line
- `$ ./gradlew run`
- Project compiles fine, but crashes in runtime with:
```
Exception in thread "main" java.lang.IllegalAccessError: tried to access method com.github.vmironov.ic.delegates.CrashMeKt$crashMe$$inlined$observable$1.<init>(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)V from class com.github.vmironov.ic.Model
        at com.github.vmironov.ic.Model.<init>(Main.kt:14)
        at com.github.vmironov.ic.MainKt.main(Main.kt:10)
```