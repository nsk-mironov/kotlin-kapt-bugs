package com.github.vmironov.ic

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.github.vmironov.ic.databinding.ActivityMainBinding

class MainActivity : Activity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
  }
}

@BindingAdapter("magic")
fun setMagic(view: TextView, text: CharSequence) {
}
