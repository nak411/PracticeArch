package com.naveed.practice_arch.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.naveed.practice_arch.databinding.FragmentWelcomeBinding
import com.naveed.practice_arch.utils.EventObserver

/**
 * This fragment displays a screen which has no state.
 * It contains a single events for launching different screens.
 */
class WelcomeFragment : Fragment() {

    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: WelcomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.welcomeEvents.observe(this, EventObserver { event ->
            handleEvents(event)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnProfile.setOnClickListener {
            viewModel.action(ClickProfileButton)
        }
    }

    private fun handleEvents(event: WelcomeEvent) {
        when (event) {
            LaunchProfile -> findNavController()
                .navigate(WelcomeFragmentDirections.actionWelcomeFragmentToProfileFragment())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}