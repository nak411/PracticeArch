package com.naveed.practice_arch.welcome

data class WelcomeUiModel(
    val items: List<WelcomeListItem>
)

data class WelcomeListItem(
    val label: String
)

