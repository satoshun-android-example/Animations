package com.github.satoshun.example.main.colorstatelistalpha

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.fragment.app.Fragment
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.PropertyValuesHolderFragBinding

class PropertyValuesHolderFragment : Fragment(R.layout.property_values_holder_frag) {
  private lateinit var binding: PropertyValuesHolderFragBinding

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = PropertyValuesHolderFragBinding.bind(view)

    val scaleX = PropertyValuesHolder.ofFloat(
      View.SCALE_X,
      0.5f,
      1.0f
    )
    ObjectAnimator.ofPropertyValuesHolder(binding.title, scaleX).apply {
      interpolator = OvershootInterpolator()
    }.start()
  }
}
