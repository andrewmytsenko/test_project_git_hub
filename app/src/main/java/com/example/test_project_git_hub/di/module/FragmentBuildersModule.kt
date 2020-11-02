package com.example.test_project_git_hub.di.module

import com.example.test_project_git_hub.ui.git_hub_project.GitHubProjectFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeGitHubProjectFragment(): GitHubProjectFragment
}