package com.github.satoshun.example.main.iconanimation

import android.animation.AnimatorInflater
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.RotateAnimation
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.IconAnimationFragBinding
import com.github.satoshun.example.main.awaitPreDraw
import kotlinx.coroutines.launch


class IconAnimationFragment : Fragment(R.layout.icon_animation_frag) {
  private lateinit var binding: IconAnimationFragBinding

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = IconAnimationFragBinding.bind(view)

    icon1()
    lifecycleScope.launch { icon2() }
    lifecycleScope.launch { icon3() }
  }

  // PropertyValuesHolder + ROTATION
  private fun icon1() {
    val rotate = PropertyValuesHolder.ofFloat(
      View.ROTATION,
      -45f,
      45f
    )
    ObjectAnimator.ofPropertyValuesHolder(binding.icon1, rotate)
      .setDuration(200L)
      .apply { repeatCount = 10 }
      .start()
  }

  // RotateAnimation
  private suspend fun icon2() {
    binding.icon2.awaitPreDraw()

    val anim = RotateAnimation(
      -50f,
      50f,
      binding.icon2.pivotX,
      binding.icon2.pivotY
    )
    anim.interpolator = DecelerateInterpolator()
    anim.repeatCount = 10
    anim.repeatMode = Animation.REVERSE
    anim.duration = 300

    binding.icon2.startAnimation(anim)
  }

  // animator
  private suspend fun icon3() {
    binding.icon3.awaitPreDraw()

    val animator = AnimatorInflater.loadAnimator(requireContext(), R.animator.icon3)
      .apply {
        setTarget(binding.icon3)
        start()
      }
  }
}
