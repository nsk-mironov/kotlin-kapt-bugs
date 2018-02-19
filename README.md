Kotlin Kapt Bugs
===========================================

Steps to reproduce:

1. `$ git clone https://github.com/nsk-mironov/kotlin-kapt-bugs`
2. `$ cd kotlin-kapt-bugs`
3. `$ git checkout KT-22304`
4. `$ ./gradlew clean build`
5. Build fails with
```
e: org.jetbrains.kotlin.codegen.CompilationException: Back-end (JVM) Internal error: Couldn't inline method call 'switchMapOnce' into
public fun main(args: kotlin.Array<kotlin.String>): kotlin.Unit defined in com.github.vmironov in file Main.kt
fun main(args: Array<String>) {
  Observable.just(Unit).switchMapOnce {
    Observable.just(Unit).switchMapOnce {
      Observable.just(Unit)
    }
  }
}
Cause: switchMapOnce (Lio/reactivex/Observable;Lkotlin/jvm/functions/Function1;)Lio/reactivex/Observable;:
   L0
   L1
    ALOAD 0
    LDC "$receiver"
    INVOKESTATIC kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull (Ljava/lang/Object;Ljava/lang/String;)V
    ALOAD 1
    LDC "mapper"
    INVOKESTATIC kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull (Ljava/lang/Object;Ljava/lang/String;)V
   L2
    LINENUMBER 7 L2
   L3
    LINENUMBER 9 L3
   L4
    LINENUMBER 7 L4
   L5
    LINENUMBER 8 L5
   L6
    LINENUMBER 7 L6
    ALOAD 0
    NEW com/github/vmironov/extensions/RxExtensionsKt$switchMapOnce$1
    DUP
    ALOAD 1
    INVOKESPECIAL com/github/vmironov/extensions/RxExtensionsKt$switchMapOnce$1.<init> (Lkotlin/jvm/functions/Function1;)V
    CHECKCAST io/reactivex/functions/Function
    INVOKEVIRTUAL io/reactivex/Observable.switchMap (Lio/reactivex/functions/Function;)Lio/reactivex/Observable;
   L7
    LINENUMBER 8 L7
    GETSTATIC com/github/vmironov/extensions/RxExtensionsKt$switchMapOnce$2.INSTANCE : Lcom/github/vmironov/extensions/RxExtensionsKt$switchMapOnce$2;
    CHECKCAST kotlin/jvm/functions/Function1
    DUP
    IFNULL L8
    ASTORE 3
    NEW com/github/vmironov/extensions/RxExtensionsKt$sam$i$io_reactivex_functions_Predicate$0
    DUP
    ALOAD 3
    INVOKESPECIAL com/github/vmironov/extensions/RxExtensionsKt$sam$i$io_reactivex_functions_Predicate$0.<init> (Lkotlin/jvm/functions/Function1;)V
   L8
    CHECKCAST io/reactivex/functions/Predicate
    INVOKEVIRTUAL io/reactivex/Observable.takeUntil (Lio/reactivex/functions/Predicate;)Lio/reactivex/Observable;
   L9
    LINENUMBER 9 L9
    INVOKEVIRTUAL io/reactivex/Observable.dematerialize ()Lio/reactivex/Observable;
    DUP
    LDC "switchMap { mapper(it).m\u2026e)\n      .dematerialize()"
    INVOKESTATIC kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull (Ljava/lang/Object;Ljava/lang/String;)V
    ARETURN
   L10
   L11
    LOCALVARIABLE $receiver Lio/reactivex/Observable; L0 L11 0
    LOCALVARIABLE mapper Lkotlin/jvm/functions/Function1; L0 L11 1
    LOCALVARIABLE $i$f$switchMapOnce I L0 L11 2
    MAXSTACK = 4
    MAXLOCALS = 4

Cause: Couldn't find virtual file for com/github/vmironov/extensions/RxExtensionsKt$sam$i$io_reactivex_functions_Predicate$0
File being compiled at position: (7,25) in /Users/mironov/Development/kotlin-kapt-bugs/src/main/java/com/github/vmironov/Main.kt
```
