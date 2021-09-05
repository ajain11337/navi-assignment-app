package com.navi.assignment.app.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.navi.assignment.app.common.PRStatus
import com.navi.assignment.app.data.GetPRUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class BaseViewModel @Inject constructor(
    private val getPRUseCase: GetPRUseCase
): ViewModel(){

    fun getPullRequestList(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = getPRUseCase.execute(
                PRStatus.CLOSED,
                1,
                30
            )
            if(response.isSuccessful){
                Log.d(TAG, "getPullRequestList: " + response.body().toString())
                showSuccess()
            }else{
                showError()
            }
        }
    }

    private fun showSuccess(){

    }

    private fun showError(){

    }

    companion object {
        private const val TAG = "BaseViewModel"
    }
}