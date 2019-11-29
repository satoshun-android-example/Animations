package com.github.satoshun.example.main.iconanimation

import android.animation.Animator
import androidx.core.animation.doOnEnd
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

suspend fun Animator.awaitStart() = suspendCancellableCoroutine<Unit> { cont ->
  doOnEnd { cont.resume(Unit) }
  cont.invokeOnCancellation { cancel() }
  start()
}
