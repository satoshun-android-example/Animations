package com.github.satoshun.example.main

import android.animation.ValueAnimator
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.PropertyValuesHolderFragBinding
import kotlinx.coroutines.launch

class ValueAnimatorFragment : Fragment(R.layout.property_values_holder_frag) {
  private lateinit var binding: PropertyValuesHolderFragBinding

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = PropertyValuesHolderFragBinding.bind(view)

    lifecycleScope.launch {
      val spannable = SpannableString("title...")
      binding.title.text = spannable
      ValueAnimator.ofInt(0, 4).apply {
        repeatCount = 10
        duration = 1000
        addUpdateListener { valueAnimator ->
          val dotsCount = valueAnimator.animatedValue as Int

          if (dotsCount < 4) {
            spannable.setSpan(
              ForegroundColorSpan(Color.TRANSPARENT),
              5,
              5 + 3,
              Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )

            spannable.setSpan(
              ForegroundColorSpan(Color.BLUE),
              5,
              5 + dotsCount,
              Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            binding.title.text = spannable
          }
        }
      }.start()
    }
  }
}
