package com.github.satoshun.example.main.scale

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.ScaleAnimation
import androidx.fragment.app.Fragment
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.ScaleIconFragBinding

class ScaleFragment : Fragment(R.layout.scale_icon_frag) {
  private lateinit var binding: ScaleIconFragBinding

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = ScaleIconFragBinding.bind(view)

    binding.icon1.setOnClickListener {
      startAnimator1(binding.icon1)
    }

    binding.icon2.setOnClickListener {
      startScaleAnimator2(binding.icon2)
    }

    binding.icon3.setOnClickListener {
      startScaleAnimator3(binding.icon3)
    }

    binding.icon4.setOnClickListener {
      startScaleAnimator4(binding.icon4)
    }
  }
}

private fun startAnimator1(view: View) {
  val animator: ValueAnimator = ValueAnimator.ofFloat(0.7f, 1f)
  animator.interpolator = DecelerateInterpolator()
  animator.duration = 200L
  animator.addUpdateListener { animation ->
    val scale: Float = animation.animatedValue as Float
    println("startAnimator1 $scale")
    view.scaleX = scale
    view.scaleY = scale
  }
  animator.start()
}

private fun startScaleAnimator2(view: View) {
  val animation = ScaleAnimation(
    0.7f, 1f,
    0.7f, 1f,
    Animation.RELATIVE_TO_SELF, 0.5f,
    Animation.RELATIVE_TO_SELF, 0.5f
  )
  animation.duration = 200L
  animation.interpolator = DecelerateInterpolator()
  view.startAnimation(animation)
}

private fun startScaleAnimator3(view: View) {
  view.scaleX = 0.7f
  view.scaleY = 0.7f

  view.animate()
    .setInterpolator(DecelerateInterpolator())
    .scaleX(1f)
    .scaleY(1f)
    .setDuration(200L)
    .start()
}

private fun startScaleAnimator4(view: View) {
  val animator = ObjectAnimator.ofPropertyValuesHolder(
    view,
    PropertyValuesHolder.ofFloat(View.SCALE_X, 1.0f, 0.7f, 1.0f),
    PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.0f, 0.7f, 1.0f)
  )
  animator.duration = 200L
  animator.interpolator = DecelerateInterpolator()

  animator.start()
}
