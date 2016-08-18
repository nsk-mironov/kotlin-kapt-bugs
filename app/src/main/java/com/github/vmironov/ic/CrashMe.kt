package com.github.vmironov.ic

class CrashMe {
  fun crashMe(values: Array<Int>) {
    var total = 0

    values.forEach {
      total += it
    }

    Math.max(total, 0)
  }
}
