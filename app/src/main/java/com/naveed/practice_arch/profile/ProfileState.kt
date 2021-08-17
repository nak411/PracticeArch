package com.naveed.practice_arch.profile

import com.naveed.practice_arch.data.github.model.GithubUser

sealed class ProfileState

object Loading : ProfileState()

object Error: ProfileState()

class Data(val user: GithubUser) : ProfileState()