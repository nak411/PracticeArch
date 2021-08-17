package com.naveed.practice_arch.profile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.naveed.practice_arch.R
import com.naveed.practice_arch.data.github.model.GithubUser
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
        binding.pbProgress.isVisible = state is Loading
        binding.tvUsername.isVisible = state is Data
        when(state) {
            is Data -> handleData(state.user)
            else -> Log.d("TAG","State handled")
        }
    }

    private fun handleData(user: GithubUser) {
        binding.tvUsername.text = user.login
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