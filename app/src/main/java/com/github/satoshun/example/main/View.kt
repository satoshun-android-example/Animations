package com.github.satoshun.example.main

import android.view.View
import androidx.core.view.doOnPreDraw
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

suspend fun View.awaitPreDraw() = suspendCancellableCoroutine<Unit> { cont ->
  val listener = doOnPreDraw { cont.resume(Unit) }
  cont.invokeOnCancellation { listener.removeListener() }
}
