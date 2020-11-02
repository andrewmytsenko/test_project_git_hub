package com.example.test_project_git_hub.base_controler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding


abstract class NavFragment<V : ViewBinding> : Fragment() {

    protected lateinit var binding: V

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflateViewBinding(inflater, container)
        return binding.root
    }

    protected abstract fun inflateViewBinding(inflater: LayoutInflater, container: ViewGroup?): V

}