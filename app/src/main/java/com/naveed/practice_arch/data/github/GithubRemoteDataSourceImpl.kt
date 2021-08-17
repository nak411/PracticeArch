package com.naveed.practice_arch.data.github

import android.util.Log
import com.naveed.practice_arch.data.github.model.GithubUser
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://api.github.com"

class GithubRemoteDataSourceImpl : GithubRemoteDataSource {

    private val service: GithubService

    init {
        val client = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        service = client.create(GithubService::class.java)
    }

    override suspend fun getUserByName(username: String): GithubUser {
        val user = service.getUserByName(username)
        Log.d("TAG", user.toString())
        return user
    }
}