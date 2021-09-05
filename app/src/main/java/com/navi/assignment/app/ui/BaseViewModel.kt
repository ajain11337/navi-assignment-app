package com.navi.assignment.app.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.navi.assignment.app.common.GithubDataMapper
import com.navi.assignment.app.common.PRStatus
import com.navi.assignment.app.data.GetPRUseCase
import com.navi.assignment.app.data.model.GithubDataModel
import com.navi.assignment.app.domain.model.GithubDomainModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class BaseViewModel @Inject constructor(
    private val getPRUseCase: GetPRUseCase,
    private val mapper: GithubDataMapper
): ViewModel(){

    var list = MutableLiveData<List<GithubDataModel>>()

    fun getPullRequestList(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = getPRUseCase.execute(
                PRStatus.CLOSED,
                1,
                30
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