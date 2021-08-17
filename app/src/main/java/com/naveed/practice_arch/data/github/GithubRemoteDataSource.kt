package com.naveed.practice_arch.data.github

import com.naveed.practice_arch.data.github.model.GithubUser

interface GithubRemoteDataSource {

    suspend fun getUserByName(username: String) : GithubUser
}