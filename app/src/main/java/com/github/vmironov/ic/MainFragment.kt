package com.github.vmironov.ic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.vmironov.ic.databinding.MainFragmentBinding

class MainFragment : BindingFragment<MainFragmentBinding>() {
  override fun onCreateBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): MainFragmentBinding {
    return MainFragmentBinding.inflate(inflater, container, false)
  }

  override fun onBindingCreated(binding: MainFragmentBinding, savedInstanceState: Bundle?) {
    super.onBindingCreated(binding, savedInstanceState)
  }

  override fun onDestroyBinding(binding: MainFragmentBinding) {
    super.onDestroyBinding(binding)
  }
}
