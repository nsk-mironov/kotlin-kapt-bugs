package com.github.vmironov.ic

import android.app.Activity
import android.os.Bundle

data class Address(
    val id: String = "",
    val createdTimeMs: Long = 0,
    val updatedTimeMs: Long = 0,
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val country: String = "",
    val state: String = ""
)

inline fun String.switchIfEmpty(provider: () -> String): String {
  return if (isEmpty()) provider() else this
}

class CrashMeActivity : Activity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    sequenceOf(Address()).map { address ->
      address.copy(
          firstName = address.firstName.switchIfEmpty { "John" },
          lastName = address.lastName.switchIfEmpty { "Doe" },
          email = address.email.switchIfEmpty { "john.doe@joom.com" }
      )
    }
  }
}
