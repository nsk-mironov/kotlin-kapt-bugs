package com.github.vmironov.ic

interface CrashMe {
  fun crashMe(position: Int): Long = 1
}
