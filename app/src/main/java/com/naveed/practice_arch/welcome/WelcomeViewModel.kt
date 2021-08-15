package com.naveed.practice_arch.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel : ViewModel() {

    private val _welcomeEvents: MutableLiveData<WelcomeEvent> = MutableLiveData()

    val welcomeEvents: LiveData<WelcomeEvent>
        get() = _welcomeEvents


    fun action(action: WelcomeAction) {
        when(action) {
            ClickProfileButton -> _welcomeEvents.value = LaunchProfile
        }
    }
}