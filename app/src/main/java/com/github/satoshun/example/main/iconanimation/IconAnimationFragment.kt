package com.github.satoshun.example.main.iconanimation

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.CycleInterpolator
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
    lifecycleScope.launch { icon4() }
    lifecycleScope.launch { icon5() }
    lifecycleScope.launch { icon6() }
    lifecycleScope.launch { icon7() }
    lifecycleScope.launch { icon8() }
    lifecycleScope.launch { icon9() }
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

  private suspend fun icon4() {
    binding.icon4.awaitPreDraw()

    val anim = RotateAnimation(
      -10f,
      10f,
      binding.icon4.pivotX,
      binding.icon4.pivotY
    )
    anim.duration = 1500
    anim.interpolator = CycleInterpolator(5F)

    binding.icon4.startAnimation(anim)
  }


  private suspend fun icon5() {
    binding.icon5.awaitPreDraw()

    val animator = AnimatorInflater.loadAnimator(requireContext(), R.animator.icon5)
      .apply {
        setTarget(binding.icon5)
        start()
      }
  }

  private suspend fun icon6() {
    binding.icon6.awaitPreDraw()

    val anim = RotateAnimation(
      -25f,
      25f,
      binding.icon4.pivotX,
      binding.icon4.pivotY
    )
    anim.duration = 10000
    anim.interpolator = LookupTableInterpolator(
      floatArrayOf(
        .50f, .40f, .30f, .20f, .10f, .00f, // 0.10f
        .00f, .10f, .20f, .30f, .40f, .50f, .60f, .70f, .80f, .90f, 099f, // 0.10f
        0925f, .85f, // 0.075
        .775f, .70f, .625f, .55f, .475f, .40f, .325f, .25f, // 0.075
        .30f, .35f, .40f, .45f, .50f, // 0.050
        .475f, .45f, .425f, .40f, .375f, .350f, // 0.025
        .375f, .400f, .425f, .450f, .475f, .500f // 0.025
      )
    )
    binding.icon6.startAnimation(anim)
  }

  private suspend fun icon7() {
    binding.icon7.awaitPreDraw()

    AnimatorSet().apply {
      playSequentially(
        ObjectAnimator
          .ofPropertyValuesHolder(
            binding.icon7,
            PropertyValuesHolder.ofFloat(
              View.ROTATION,
              0f,
              25f
            )
          )
          .setDuration(120L)
          .apply {
            interpolator = DecelerateInterpolator()
          },
        ObjectAnimator
          .ofPropertyValuesHolder(
            binding.icon7,
            PropertyValuesHolder.ofFloat(
              View.ROTATION,
              25f,
              -25f
            )
          )
          .setDuration(250L),
        ObjectAnimator
          .ofPropertyValuesHolder(
            binding.icon7,
            PropertyValuesHolder.ofFloat(
              View.ROTATION,
              -25f,
              18.75f
            )
          )
          .setDuration(200L),
        ObjectAnimator
          .ofPropertyValuesHolder(
            binding.icon7,
            PropertyValuesHolder.ofFloat(
              View.ROTATION,
              18.75f,
              -12.50f
            )
          )
          .setDuration(150L),
        ObjectAnimator
          .ofPropertyValuesHolder(
            binding.icon7,
            PropertyValuesHolder.ofFloat(
              View.ROTATION,
              -12.50f,
              6.25f
            )
          )
          .setDuration(80L),
        ObjectAnimator
          .ofPropertyValuesHolder(
            binding.icon7,
            PropertyValuesHolder.ofFloat(
              View.ROTATION,
              6.25f,
              0f
            )
          )
          .setDuration(50L)
      )
      start()
    }
  }

  private suspend fun icon8() {
    binding.icon8.awaitPreDraw()

    binding.icon8.playAnimation()
  }

  private suspend fun icon9() {
    binding.icon9.awaitPreDraw()

    AnimatorSet().apply {
      playSequentially(
        binding.icon9.rotate(0f, 25f, 120)
          .apply { interpolator = DecelerateInterpolator() },
        binding.icon9.rotate(25f, -25f, 250),
        binding.icon9.rotate(-25f, 18.75f, 200),
        binding.icon9.rotate(18.75f, -12.50f, 150),
        binding.icon9.rotate(-12.50f, 6.25f, 100L),
        binding.icon9.rotate(6.25f, 0f, 50L)
      )
      awaitStart()
    }
  }
}

private fun View.rotate(from: Float, to: Float, duration: Long) = ObjectAnimator
  .ofPropertyValuesHolder(
    this,
    PropertyValuesHolder.ofFloat(
      View.ROTATION,
      from,
      to
    )
  )
  .setDuration(duration)
