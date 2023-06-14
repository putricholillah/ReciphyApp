package com.example.reciphyapp.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.reciphyapp.api.ApiConfig
import com.example.reciphyapp.database.DetailResponse
import com.example.reciphyapp.recommendation.RecommendationActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel: ViewModel() {

    private val _recipe = MutableLiveData<DetailResponse?>()
    val recipe: LiveData<DetailResponse?> = _recipe

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun findDetail(ID : String) {
        _isLoading.value = true
        val client = ApiConfig.getApiDatabase().getDetail(ID)
        client.enqueue(object : Callback<DetailResponse> {
            override fun onResponse(
                call: Call<DetailResponse>,
                response: Response<DetailResponse>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        _recipe.value = responseBody
                    }
                } else {
                    Log.e(RecommendationActivity.TAG, "onFailure: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<DetailResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(RecommendationActivity.TAG, "onFailure: ${t.message}")
            }
        })
    }

}