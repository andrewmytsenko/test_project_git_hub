package com.example.test_project_git_hub.net.model.response


import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class SearchResponse(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    @SerializedName("items")
    val projects: ArrayList<Project>,
    @SerializedName("total_count")
    val totalCount: Int
)