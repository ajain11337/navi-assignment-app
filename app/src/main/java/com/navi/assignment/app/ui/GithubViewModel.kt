package com.navi.assignment.app.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.navi.assignment.app.common.Constants
import com.navi.assignment.app.utils.GithubMapper
import com.navi.assignment.app.common.PullRequestState
import com.navi.assignment.app.data.GetGithubUseCase
import com.navi.assignment.app.data.model.GithubDataModel
import com.navi.assignment.app.domain.model.GithubDomainModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class GithubViewModel @Inject constructor(
    private val getGithubUseCase: GetGithubUseCase,
    private val mapper: GithubMapper
): ViewModel(){

    var list = MutableLiveData<List<GithubDataModel>>()

    fun getPullRequestList(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = getGithubUseCase.execute(
                state = PullRequestState.CLOSED,
                page = Constants.PAGE_NUMBER,
                per_page = Constants.PER_PAGE_COUNT
            )
            if(response.isSuccessful){
                Log.d(TAG, "getPullRequestList: " + response.body().toString())
                showSuccess(response.body())
            }else{
                showError()
            }
        }
    }

    private fun showSuccess(body: List<GithubDomainModel>?) {
        body?.let {
            list.postValue(mapper.mapTo(it))
        }
    }

    private fun showError(){

    }

    companion object {
        private const val TAG = "BaseViewModel"
    }
}