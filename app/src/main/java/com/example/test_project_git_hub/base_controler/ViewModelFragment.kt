package com.example.test_project_git_hub.base_controler

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.test_project_git_hub.R
import com.example.test_project_git_hub.di.Injectable
import com.google.android.material.snackbar.Snackbar
import java.util.*
import javax.inject.Inject

abstract class ViewModelFragment<V : ViewBinding, VM : ViewModel> : NavFragment<V>(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    protected lateinit var viewModel: VM
    private var locale: Locale? = null
    private var errorMessage: Snackbar? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = createViewModel()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    open fun showError(message: String?, ok: (() -> Unit)? = null) {
        message?.run {
            if (errorMessage == null) {
                errorMessage =
                    Snackbar.make(binding.root, message, Snackbar.LENGTH_INDEFINITE)
                errorMessage?.setActionTextColor(Color.YELLOW)
                errorMessage?.setAction(R.string.ok) {
                    errorMessage?.dismiss()
                    ok?.invoke()
                    errorMessage = null
                }
                errorMessage?.show()
            }
        }
    }

    abstract fun createViewModel(): VM

}