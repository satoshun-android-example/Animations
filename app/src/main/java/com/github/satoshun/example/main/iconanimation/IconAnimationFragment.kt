package com.github.satoshun.example.main.iconanimation

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

    lifecycleScope.launch {
    }
  }
}
