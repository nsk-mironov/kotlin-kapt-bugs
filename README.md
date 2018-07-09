Kotlin Kapt Bugs
===========================================

Steps to reproduce:

1. `$ git clone https://github.com/nsk-mironov/kotlin-kapt-bugs`
2. `$ cd kotlin-kapt-bugs`
3. `$ git checkout KT-25374`
4. `$ ./gradlew clean assembleDebug`
5. Open `CrashMe.kt`
6. Replace `CrashMe2(1000)` with `CrashMe2(2000)`
7. `$ ./gradlew assembleDebug`
8. Build fails with
```
Caused by: java.lang.UnsupportedOperationException: Unresolved local class: com/github/vmironov/ic/CrashMe2$crashMe2$1
        at org.jetbrains.kotlin.descriptors.NotFoundClasses$classes$1.invoke(NotFoundClasses.kt:33)
        at org.jetbrains.kotlin.descriptors.NotFoundClasses$classes$1.invoke(NotFoundClasses.kt:21)
        at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunction.invoke(LockBasedStorageManager.java:448)
        at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull.invoke(LockBasedStorageManager.java:523)
        at org.jetbrains.kotlin.descriptors.NotFoundClasses.getClass(NotFoundClasses.kt:91)
        at org.jetbrains.kotlin.serialization.deserialization.TypeDeserializer$typeConstructor$1.invoke(TypeDeserializer.kt:109)
        at org.jetbrains.kotlin.serialization.deserialization.TypeDeserializer.typeConstructor(TypeDeserializer.kt:113)
        at org.jetbrains.kotlin.serialization.deserialization.TypeDeserializer.simpleType(TypeDeserializer.kt:71)
        at org.jetbrains.kotlin.serialization.deserialization.TypeDeserializer.type(TypeDeserializer.kt:59)
```
