package com.github.vmironov.ic

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BindingFragment<B : ViewDataBinding> : Fragment() {
  protected val binding: B
    get() = DataBindingUtil.getBinding<B>(view)

  final override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    return onCreateBinding(inflater, container, savedInstanceState).root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    onBindingCreated(binding, savedInstanceState)
    onExecutePendingBindings(binding)
  }

  override fun onDestroyView() {
    super.onDestroyView()
    onExecutePendingBindings(binding)
    onDestroyBinding(binding)
    onUnbindBinding(binding)
  }

  protected abstract fun onCreateBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): B

  protected open fun onBindingCreated(binding: B, savedInstanceState: Bundle?) {
    // nothing to do by default
  }

  protected open fun onDestroyBinding(binding: B) {
    // nothing to do by default
  }

  private fun onExecutePendingBindings(binding: B) {
    binding.executePendingBindings()
  }

  private fun onUnbindBinding(binding: B) {
    binding.unbind()
  }
}
