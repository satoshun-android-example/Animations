package com.github.satoshun.example.main.propertyvalues

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.PropertyValuesHolderFragBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PropertyValuesHolderFragment : Fragment(R.layout.property_values_holder_frag) {
  private lateinit var binding: PropertyValuesHolderFragBinding

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = PropertyValuesHolderFragBinding.bind(view)

    val scaleX = PropertyValuesHolder.ofFloat(
      View.SCALE_X,
      0.3f,
      1.0f
    )
    val alpha = PropertyValuesHolder.ofFloat(
      View.ALPHA,
      0.0f,
      1.0f
    )

    lifecycleScope.launch {
      while (true) {
        delay(2000)
        ObjectAnimator.ofPropertyValuesHolder(binding.title, scaleX, alpha)
          .apply { interpolator = OvershootInterpolator() }
          .start()
      }
    }
  }
}
