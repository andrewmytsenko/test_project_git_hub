package com.example.test_project_git_hub.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore

inline fun <reified T : ViewModel> injectViewModel(
    viewModelStore: ViewModelStore,
    factory: ViewModelProvider.Factory
): T {
    return ViewModelProvider(viewModelStore, factory)[T::class.java]
}
