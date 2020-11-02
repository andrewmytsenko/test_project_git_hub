package com.example.test_project_git_hub.di.module

import com.example.test_project_git_hub.MainActivity
import com.example.test_project_git_hub.di.module.FragmentBuildersModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity
}
