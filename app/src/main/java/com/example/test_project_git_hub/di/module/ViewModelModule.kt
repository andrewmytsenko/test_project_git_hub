package com.example.test_project_git_hub.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.test_project_git_hub.di.ViewModelFactory
import com.example.test_project_git_hub.di.ViewModelKey
import com.example.test_project_git_hub.ui.git_hub_project.GitHubProjectVM
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(GitHubProjectVM::class)
    fun bindGitHubProjectVM(viewModel: GitHubProjectVM): ViewModel
}