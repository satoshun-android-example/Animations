package com.github.satoshun.example.main.scale

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.ScaleAnimation
import androidx.fragment.app.Fragment
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.ScaleIconFragBinding

class ScaleFragment : Fragment(R.layout.scale_icon_frag) {
  private lateinit var binding: ScaleIconFragBinding

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = ScaleIconFragBinding.bind(view)

    binding.icon1.setOnClickListener {
      getScaleAnimator(binding.icon1).start()
    }

    binding.icon2.setOnClickListener {
      startScaleAnimator2(binding.icon2)
    }
  }
}

private fun getScaleAnimator(view: View): ValueAnimator {
  val animator: ValueAnimator = ValueAnimator.ofFloat(0.7f, 1f)
  animator.interpolator = DecelerateInterpolator()
  animator.duration = 200L
  animator.addUpdateListener { animation ->
    val scale: Float = animation.animatedValue as Float
    view.scaleX = scale
    view.scaleY = scale
  }
  return animator
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
