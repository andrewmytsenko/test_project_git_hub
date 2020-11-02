package com.example.test_project_git_hub.base_controler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.test_project_git_hub.di.Injectable
import java.util.*
import javax.inject.Inject

abstract class ViewModelFragment<V : ViewBinding, VM : ViewModel> : NavFragment<V>(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    protected lateinit var viewModel: VM
    private var locale: Locale? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = createViewModel()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    abstract fun createViewModel(): VM

}