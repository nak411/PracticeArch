package com.naveed.practice_arch.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.naveed.practice_arch.utils.Event
import java.lang.IllegalArgumentException

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
            is ClickListItem -> _welcomeEvents.value = getEventForIndex(action.position)
        }
    }

    private fun getEventForIndex(position: Int): Event<WelcomeEvent> {
        return when(position) {
            0 -> Event(LaunchProfile)
            1 -> Event(LaunchLegacyActivity)
            else -> throw IllegalArgumentException("Invalid position")
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
                ),
                WelcomeListItem(
                    label = "Legacy Activity"
                )
            )
        )
    }
}