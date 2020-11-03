package com.example.test_project_git_hub.net.api

import com.example.test_project_git_hub.net.model.response.SearchResponse
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("/search/repositories?order=desc&sort=stars&per_page=15")
    fun getRepositories(
        @Query("q") q: String,
        @Query("page") page: String
    ): Observable<Response<SearchResponse>>
}