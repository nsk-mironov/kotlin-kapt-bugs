package com.github.vmironov.ic

fun crashMe(values: List<String>): String {
  throw UnsupportedOperationException()
}

fun crashMe(values: List<CharSequence>): CharSequence {
  throw UnsupportedOperationException()
}
