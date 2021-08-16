package com.naveed.practice_arch.welcome

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.naveed.practice_arch.getOrAwaitValue
import com.naveed.practice_arch.utils.Event
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class WelcomeViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun action_click_profile_launches_profile_view() {
        // Arrange
        val viewModel = WelcomeViewModel()

        // Act
        viewModel.action(ClickProfileButton)
        val value = viewModel.welcomeEvents.getOrAwaitValue()
        val content = value.getContentIfNotHandled()

        // Assert
        assertNotNull(content)
        assertTrue(content is LaunchProfile)
    }
}