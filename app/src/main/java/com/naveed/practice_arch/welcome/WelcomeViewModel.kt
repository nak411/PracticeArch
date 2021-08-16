package com.naveed.practice_arch.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.naveed.practice_arch.utils.Event

class WelcomeViewModel : ViewModel() {

    private val _welcomeEvents: MutableLiveData<Event<WelcomeEvent>> = MutableLiveData()

    val welcomeEvents: LiveData<Event<WelcomeEvent>>
        get() = _welcomeEvents


    fun action(action: WelcomeAction) {
        when(action) {
            ClickProfileButton -> _welcomeEvents.value = Event(LaunchProfile)
        }
    }
}