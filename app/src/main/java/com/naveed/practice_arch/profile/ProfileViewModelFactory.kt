package com.naveed.practice_arch.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.naveed.practice_arch.data.github.GithubRepository

class ProfileViewModelFactory(
    private val githubRepo: GithubRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return ProfileViewModel(githubRepo) as T
    }
}