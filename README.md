Kotlin Kapt Bugs
===========================================

Steps to reproduce:

- `$ git clone https://github.com/nsk-mironov/kotlin-kapt-bugs`
- `$ cd kotlin-kapt-bugs`
- `$ git checkout KT-16176`
- `$ ./gradlew clean assembleDebug`
- There are a lot of false positive errors in the log
```
e: /Users/mironov/Development/research/kotlin-kapt-bugs/app/build/tmp/kapt3/stubs/debug/com/github/vmironov/ic/MainFragment.java:6: error: cannot find symbol
e:

e:     protected MainFragmentBinding onCreateBinding(android.view.LayoutInflater inflater, android.view.ViewGroup container, android.os.Bundle savedInstanceState) {
e:               ^
e:   symbol:   class MainFragmentBinding
e:   location: class MainFragment
e: /Users/mironov/Development/research/kotlin-kapt-bugs/app/build/tmp/kapt3/stubs/debug/com/github/vmironov/ic/MainFragment.java:11: error: cannot find symbol
e:

e:     protected void onBindingCreated(MainFragmentBinding binding, android.os.Bundle savedInstanceState) {
e:                                     ^
e:   symbol:   class MainFragmentBinding
e:   location: class MainFragment
e: /Users/mironov/Development/research/kotlin-kapt-bugs/app/build/tmp/kapt3/stubs/debug/com/github/vmironov/ic/MainFragment.java:15: error: cannot find symbol
e:

e:     protected void onDestroyBinding(MainFragmentBinding binding) {
e:                                     ^
e:   symbol:   class MainFragmentBinding
e:   location: class MainFragment
```
