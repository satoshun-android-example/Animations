package com.github.satoshun.example.main.iconanimation

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import androidx.fragment.app.Fragment
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.IconAnimationFragBinding


class IconAnimationFragment : Fragment(R.layout.icon_animation_frag) {
  private lateinit var binding: IconAnimationFragBinding

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = IconAnimationFragBinding.bind(view)

    icon1()
    icon2()
  }

  private fun icon1() {
    val rotate = PropertyValuesHolder.ofFloat(
      View.ROTATION,
      -45f,
      45f
    )
    ObjectAnimator.ofPropertyValuesHolder(binding.icon1, rotate)
      .setDuration(200L)
      .apply {
        repeatCount = 10
      }
      .start()
  }

  private fun icon2() {
    val anim = RotateAnimation(0f, 90f, 15f, 15f)
    anim.interpolator = LinearInterpolator()
    anim.repeatCount = Animation.INFINITE
    anim.repeatMode = Animation.REVERSE
    anim.duration = 700

    binding.icon2.startAnimation(anim)
  }
}
