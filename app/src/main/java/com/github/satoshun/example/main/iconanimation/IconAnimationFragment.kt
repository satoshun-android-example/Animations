package com.github.satoshun.example.main.iconanimation

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.IconAnimationFragBinding
import kotlinx.coroutines.launch

class IconAnimationFragment : Fragment(R.layout.icon_animation_frag) {
  private lateinit var binding: IconAnimationFragBinding

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = IconAnimationFragBinding.bind(view)

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
}
