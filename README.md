Kotlin Kapt Bugs
===========================================

Steps to reproduce:

- `$ git clone https://github.com/nsk-mironov/kotlin-kapt-bugs`
- `$ cd kotlin-kapt-bugs`
- `$ git checkout KT-20844`
- `$ ./gradlew clean installDebug`
- The application crashes in runtime with the following exception:
```
java.lang.VerifyError: Rejecting class com.github.vmironov.ic.CrashMeActivity$onCreate$1 because it failed compile-time verification (declaration of 'com.github.vmironov.ic.CrashMeActivity$onCreate$1' appears in /data/app/com.github.vmironov.ic-1/base.apk)
        at com.github.vmironov.ic.CrashMeActivity.onCreate(CrashMe.kt:25)
        at android.app.Activity.performCreate(Activity.java:6876)
        at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1135)
        at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:3206)
        at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:3349)
        at android.app.ActivityThread.access$1100(ActivityThread.java:221)
        at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1794)
        at android.os.Handler.dispatchMessage(Handler.java:102)
        at android.os.Looper.loop(Looper.java:158)
        at android.app.ActivityThread.main(ActivityThread.java:7225)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1230)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1120)
```
