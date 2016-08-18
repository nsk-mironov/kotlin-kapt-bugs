package com.github.vmironov.ic

import android.app.Activity
import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.widget.TextView
import com.github.vmironov.ic.databinding.ActivityMainBinding

class MainViewModel() {
  fun getTitle(): String {
    return "333-333"
  }
}

class MainActivity : Activity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
      model = MainViewModel()
    }
  }
}

@BindingAdapter("font")
fun setTypeface(view: TextView, font: String?) {
  // nothing
}
