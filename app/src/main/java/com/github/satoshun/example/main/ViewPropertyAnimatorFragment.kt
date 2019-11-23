package com.github.satoshun.example.main

import android.os.Bundle
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.PropertyValuesHolderFragBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ViewPropertyAnimatorFragment : Fragment(R.layout.property_values_holder_frag) {
  private lateinit var binding: PropertyValuesHolderFragBinding

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = PropertyValuesHolderFragBinding.bind(view)

    lifecycleScope.launch {
      while (true) {
        delay(2000)

        binding.title.scaleX = 0.5f
        binding.title.animate()
          .scaleX(1.0f)
          .setInterpolator(OvershootInterpolator())
          .start()
      }
    }
  }
}
