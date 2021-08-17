package com.naveed.practice_arch.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.naveed.practice_arch.R
import com.naveed.practice_arch.databinding.FragmentProfileBinding
import com.naveed.practice_arch.di.DependencyGraph

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding: FragmentProfileBinding get() = _binding!!

    private val viewModel: ProfileViewModel by viewModels {
        ProfileViewModelFactory(DependencyGraph.githubRepo)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.state.observe(this, { state -> handleState(state)})
        viewModel.loadUser("nak411")
    }

    private fun handleState(state: ProfileState) {
        when(state) {
            Loading -> binding.tvText.text = "Loading..."
            Error -> binding.tvText.text = "Error"
            is Data -> binding.tvText.text = state.user.toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}