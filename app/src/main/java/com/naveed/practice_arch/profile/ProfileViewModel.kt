package com.naveed.practice_arch.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.naveed.practice_arch.data.github.GithubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val githubRepo: GithubRepository
) : ViewModel() {

    private val _state = MutableLiveData<ProfileState>()
    val state: LiveData<ProfileState> = _state

    fun loadUser(username: String) {
        _state.value = Loading
        viewModelScope.launch(Dispatchers.IO) {
            val user = githubRepo.getUserByName(username)
            _state.postValue(
                Data(
                    user = user
                )
            )
        }
    }
}