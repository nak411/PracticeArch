package com.naveed.practice_arch.data.github

import com.naveed.practice_arch.data.github.model.GithubUser
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    @GET("/users/{user}")
    suspend fun getUserByName(@Path("user") user: String) : GithubUser
}