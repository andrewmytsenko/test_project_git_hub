package com.example.test_project_git_hub.ui.git_hub_project

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test_project_git_hub.net.api.Api
import com.example.test_project_git_hub.net.model.response.SearchResponse
import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class GitHubProjectVM @Inject constructor(private val api: Api) : ViewModel() {
    private var disposable: Disposable? = null
     val foundProjectResponse = MutableLiveData<SearchResponse>()

    fun validateTransactionFactor(q: String, countPages: Int) {
        val s = Observable.range(1, countPages)
            .map { page ->
                api.getRepositories(
                    q = q,
                    page = page.toString()
                )
            }


        disposable = Observable.switchOnNext(s)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                if (response.isSuccessful) {
                    response.body()?.run {
                        foundProjectResponse
                            Log.d("sad0", Gson().toJson(this))
                    }
                }

            }, {

            })


    }


}