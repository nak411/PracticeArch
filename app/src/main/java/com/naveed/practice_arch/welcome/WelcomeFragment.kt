package com.naveed.practice_arch.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.naveed.practice_arch.databinding.FragmentWelcomeBinding
import com.naveed.practice_arch.utils.EventObserver
import com.naveed.practice_arch.welcome.list.WelcomeRecyclerAdapter

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
        viewModel.loadData()
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
        viewModel.welcomeEvents.observe(viewLifecycleOwner, EventObserver { event ->
            onEvent(event)
        })
        viewModel.state.observe(viewLifecycleOwner, { state ->
            onState(state)
        })
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun onState(state: WelcomeState) {
        when (state) {
            is WelcomeData -> setupAdapter(state.data.items)
        }
    }

    private fun onEvent(event: WelcomeEvent) {
        when (event) {
            LaunchProfile -> findNavController()
                .navigate(WelcomeFragmentDirections.actionWelcomeFragmentToProfileFragment())
        }
    }

    private fun setupAdapter(items: List<WelcomeListItem>) {
        binding.recyclerView.adapter =
            WelcomeRecyclerAdapter(items) { viewModel.action(ClickProfileButton) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}