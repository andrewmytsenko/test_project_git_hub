package com.example.test_project_git_hub

import android.app.Application
import android.content.res.Resources
import com.example.test_project_git_hub.di.AppComponent
import com.example.test_project_git_hub.di.AppInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class TestTaskApplication: Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>


    override fun onCreate() {
        super.onCreate()
        appComponent = AppInjector.init(this)
        appResources = resources
    }

    override fun androidInjector() = dispatchingAndroidInjector

    companion object {
        lateinit var appComponent: AppComponent
        lateinit var appResources: Resources
    }

}