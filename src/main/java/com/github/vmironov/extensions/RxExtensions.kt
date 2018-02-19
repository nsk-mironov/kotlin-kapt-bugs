package com.github.vmironov.extensions

import io.reactivex.Notification
import io.reactivex.Observable

inline fun <T : Any, U : Any> Observable<T>.switchMapOnce(crossinline mapper: (T) -> Observable<U>): Observable<U> {
  return switchMap { mapper(it).materialize() }
      .takeUntil(Notification<*>::isOnComplete)
      .dematerialize()
}
