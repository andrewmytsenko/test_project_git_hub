package com.example.test_project_git_hub.ui.git_hub_project

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import com.example.test_project_git_hub.R
import com.example.test_project_git_hub.base_controler.ViewModelFragment
import com.example.test_project_git_hub.databinding.FragmentGitHubProjectBinding
import com.example.test_project_git_hub.di.injectViewModel
import com.example.test_project_git_hub.net.model.response.SearchResponse
import com.example.test_project_git_hub.ui.git_hub_project.adapter.ProjectAdapter
import com.example.test_project_git_hub.utils.hideKeyboard

class GitHubProjectFragment : ViewModelFragment<FragmentGitHubProjectBinding, GitHubProjectVM>() {
    private val projectAdapter = ProjectAdapter().apply {
        clickItem =
            {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(it.htmlUrl))
                startActivity(browserIntent)
            }
    }
    private val search = object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            return true
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            newText?.let {
                if (newText.isNotEmpty()) {
                    binding.pgLoad.visibility = View.VISIBLE
                    viewModel.validateTransactionFactor(newText)
                }
                projectAdapter.clear()
            }
            return true
        }
    }

    override fun createViewModel(): GitHubProjectVM =
        injectViewModel(viewModelStore, viewModelFactory)


    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentGitHubProjectBinding =
        FragmentGitHubProjectBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initComponentUi()
    }

    private fun initComponentUi() {
        binding.rvProject.adapter = projectAdapter
        binding.svFoundProject.setOnQueryTextListener(search)
    }

    private fun initViewModel() {
        viewModel.foundProjectResponse.observe(viewLifecycleOwner, { setAdapter(it) })
        viewModel.foundProjectResponseError.observe(
            viewLifecycleOwner,
            { showError(it) })
    }

    override fun showError(message: String?, ok: (() -> Unit)?) {
        super.showError(message) { repeatRequest() }
        binding.root.hideKeyboard()
        binding.pgLoad.visibility = View.GONE
        projectAdapter.clear()
    }

    private fun repeatRequest() {
        binding.pgLoad.visibility = View.VISIBLE
        viewModel.validateTransactionFactor(binding.svFoundProject.query.toString())
    }

    private fun setAdapter(searchResponse: SearchResponse?) {
        binding.pgLoad.visibility = View.GONE
        searchResponse?.run {
            projectAdapter.add(projects)
            if (projects.isEmpty()) {
                super.showError(getString(R.string.not_repositories_found),null)
                projectAdapter.clear()
            }
        }
    }
}