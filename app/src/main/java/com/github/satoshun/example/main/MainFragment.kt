package com.github.satoshun.example.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.MainFragBinding

class MainFragment : Fragment() {
  private lateinit var binding: MainFragBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = MainFragBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.propertyValues.setOnClickListener {
      findNavController().navigate(R.id.nav_property_values_holder)
    }
    binding.propertyAnimator.setOnClickListener {
      findNavController().navigate(R.id.nav_property_animator)
    }
    binding.valueAnimator.setOnClickListener {
      findNavController().navigate(R.id.nav_value_animator)
    }
    binding.transitionManager.setOnClickListener {
      val extras = FragmentNavigatorExtras(
        binding.transitionManager to "transitionManager_button"
      )

      findNavController().navigate(
        R.id.nav_transition_manager,
        null,
        null,
        extras
      )
    }
    binding.iconScale.setOnClickListener {
      findNavController().navigate(R.id.nav_scale_icon_animation)
    }
  }
}
