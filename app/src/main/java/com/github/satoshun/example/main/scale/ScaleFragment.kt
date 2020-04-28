package com.github.satoshun.example.main.scale

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
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
  }
}

private fun getScaleAnimator(view: View): ValueAnimator {
  val animator: ValueAnimator = ValueAnimator.ofFloat(0.8f, 1f)
  // FastOutLinearInInterpolator
  // LinearOutSlowInInterpolator
  animator.interpolator = FastOutSlowInInterpolator()
  animator.duration = 200L
  animator.addUpdateListener { animation ->
    val scale: Float = animation.animatedValue as Float
    view.scaleX = scale
    view.scaleY = scale
  }
  return animator
}
