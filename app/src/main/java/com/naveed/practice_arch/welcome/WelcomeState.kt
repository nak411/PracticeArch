package com.naveed.practice_arch.welcome

sealed class WelcomeState

class WelcomeData(val data: WelcomeUiModel): WelcomeState()