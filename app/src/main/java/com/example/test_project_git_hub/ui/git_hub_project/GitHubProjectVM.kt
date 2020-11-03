package com.example.test_project_git_hub.ui.git_hub_project

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test_project_git_hub.net.api.Api
import com.example.test_project_git_hub.net.model.response.SearchResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class GitHubProjectVM @Inject constructor(private val api: Api) : ViewModel() {
    private var disposable: Disposable? = null
    val foundProjectResponse = MutableLiveData<SearchResponse>()
    val foundProjectResponseError = MutableLiveData<String>()
    private val PAGE_1 = "1"
    private val PAGE_2 = "2"

    fun validateTransactionFactor(q: String) {
        disposable?.dispose()
        val request =
            api.getRepositories(
                q = q,
                page = PAGE_1
            )

        val requestTwo =
            api.getRepositories(
                q = q,
                page = PAGE_2
            )
        disposable = request
            .mergeWith(requestTwo)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                if (response.isSuccessful) {
                    response.body()?.run {
                        foundProjectResponse.postValue(this)
                    }
                } else {
                    foundProjectResponseError.postValue(response.message())
                }
            }, {
                foundProjectResponseError.postValue(it.message)
            })
    }
}