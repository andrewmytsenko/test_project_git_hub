package com.example.test_project_git_hub.ui.git_hub_project.adapter

import com.example.test_project_git_hub.net.model.response.Project

interface Handler {
    fun onClick(userInfo: Project)
}