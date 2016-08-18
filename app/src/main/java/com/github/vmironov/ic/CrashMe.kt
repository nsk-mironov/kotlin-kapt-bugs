package com.github.vmironov.ic

class CrashMe() {
  private val notReally = object : Runnable {
    override fun run() {
      throw UnsupportedOperationException()
    }
  }
}
