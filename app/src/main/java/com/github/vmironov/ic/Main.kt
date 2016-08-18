package com.github.vmironov.ic

import com.github.vmironov.ic.delegates.crashMe

class Model(private val factory: () -> Unit) {
  var crashMe1 by crashMe(factory)
  var crashMe2 by crashMe(factory)
}

fun main(args: Array<String>) {
  Model({ println("crashMe") })
}
