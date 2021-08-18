package com.naveed.practice_arch.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.naveed.practice_arch.utils.Event

class WelcomeViewModel : ViewModel() {

    // TODO refactor
    private val data: WelcomeUiModel by lazy { createUiModel() }


    private val _state: MutableLiveData<WelcomeState> = MutableLiveData()
    val state: LiveData<WelcomeState> get() = _state

    private val _welcomeEvents: MutableLiveData<Event<WelcomeEvent>> = MutableLiveData()
    val welcomeEvents: LiveData<Event<WelcomeEvent>>
        get() = _welcomeEvents


    fun action(action: WelcomeAction) {
        when (action) {
            ClickProfileButton -> _welcomeEvents.value = Event(LaunchProfile)
        }
    }

    fun loadData() {
        _state.value = WelcomeData(data)
    }

    private fun createUiModel(): WelcomeUiModel {
        return WelcomeUiModel(
            listOf(
                WelcomeListItem(
                    label = "Github Profile"
                )
            )
        )
    }
}