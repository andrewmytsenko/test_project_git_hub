package com.example.test_project_git_hub.di

import android.app.Application
import com.example.test_project_git_hub.TestTaskApplication
import com.example.test_project_git_hub.di.module.ApiModule
import com.example.test_project_git_hub.di.module.AppModule
import com.example.test_project_git_hub.di.module.MainActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ApiModule::class,
        MainActivityModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(application: TestTaskApplication)
}