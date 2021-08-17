package com.naveed.practice_arch.data.github

import com.naveed.practice_arch.data.github.model.GithubUser

interface GithubRepository {

    suspend fun getUserByName(username: String) : GithubUser
}

class GithubRepositoryImpl(
    private val remoteDataSource: GithubRemoteDataSource
): GithubRepository {

    override suspend fun getUserByName(username: String): GithubUser {
        return remoteDataSource.getUserByName(username)
    }

}