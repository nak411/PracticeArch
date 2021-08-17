package com.naveed.practice_arch.di

import com.naveed.practice_arch.data.github.GithubRemoteDataSource
import com.naveed.practice_arch.data.github.GithubRemoteDataSourceImpl
import com.naveed.practice_arch.data.github.GithubRepository
import com.naveed.practice_arch.data.github.GithubRepositoryImpl

object DependencyGraph {

    val githubRepo: GithubRepository by lazy { createGithubRepo() }

    private fun createGithubRepo(): GithubRepository {
        val remoteDataSource = createGithubRemoteDataSource()
        return GithubRepositoryImpl(remoteDataSource)
    }

    private fun createGithubRemoteDataSource(): GithubRemoteDataSource {
        return GithubRemoteDataSourceImpl()
    }
}