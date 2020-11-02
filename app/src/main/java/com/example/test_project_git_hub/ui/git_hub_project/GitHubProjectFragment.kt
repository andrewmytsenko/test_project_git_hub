package com.example.test_project_git_hub.ui.git_hub_project

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.test_project_git_hub.base_controler.ViewModelFragment
import com.example.test_project_git_hub.databinding.FragmentGitHubProjectBinding
import com.example.test_project_git_hub.di.injectViewModel

class GitHubProjectFragment : ViewModelFragment<FragmentGitHubProjectBinding, GitHubProjectVM>() {
    override fun createViewModel(): GitHubProjectVM =
        injectViewModel(viewModelStore, viewModelFactory)

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentGitHubProjectBinding =FragmentGitHubProjectBinding.inflate(inflater, container, false)

}