package com.example.test_project_git_hub.net.model.response


import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    @SerializedName("items")
    val projects: List<Project>,
    @SerializedName("total_count")
    val totalCount: Int
)