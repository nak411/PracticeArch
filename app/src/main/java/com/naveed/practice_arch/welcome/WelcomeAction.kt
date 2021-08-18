package com.naveed.practice_arch.welcome

sealed class WelcomeAction

data class ClickListItem(val position: Int): WelcomeAction()