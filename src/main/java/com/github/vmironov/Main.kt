package com.github.vmironov

import com.github.vmironov.extensions.switchMapOnce
import io.reactivex.Observable

fun main(args: Array<String>) {
  Observable.just(Unit).switchMapOnce {
    Observable.just(Unit).switchMapOnce {
      Observable.just(Unit)
    }
  }
}
