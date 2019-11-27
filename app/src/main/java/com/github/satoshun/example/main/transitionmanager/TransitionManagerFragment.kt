package com.github.satoshun.example.main.transitionmanager

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.TransitionManagerFragBinding

class TransitionManagerFragment : Fragment(R.layout.transition_manager_frag) {
  private lateinit var binding: TransitionManagerFragBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    sharedElementEnterTransition = TransitionInflater
      .from(context)
      .inflateTransition(android.R.transition.move)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = TransitionManagerFragBinding.bind(view)
  }
}
