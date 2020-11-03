package com.example.test_project_git_hub.di.module

import com.example.test_project_git_hub.net.NetService
import com.example.test_project_git_hub.net.api.Api
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule {
    @Singleton
    @Provides
    fun provideUser(retrofit: Retrofit): Api = retrofit.create(Api::class.java)

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = NetService.getClient()
}