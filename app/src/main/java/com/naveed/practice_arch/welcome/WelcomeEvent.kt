package com.naveed.practice_arch.welcome

sealed class WelcomeEvent

object LaunchProfile: WelcomeEvent()

object LaunchLegacyActivity: WelcomeEvent()