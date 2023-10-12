package com.rafif.gamebargainhub.core.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rafif.gamebargainhub.core.data.source.remote.network.ApiResponse
import com.rafif.gamebargainhub.core.data.source.remote.network.ApiService
import com.rafif.gamebargainhub.core.data.source.remote.response_model.DealResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource private constructor(private val apiService: ApiService) {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: ApiService): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(service)
            }
    }

    fun getAllDeal(): LiveData<ApiResponse<List<DealResponse>>> {
        val resultData = MutableLiveData<ApiResponse<List<DealResponse>>>()
        val client = apiService.getList()

        client.enqueue(object: Callback<List<DealResponse>> {
            override fun onResponse(
                call: Call<List<DealResponse>>,
                response: Response<List<DealResponse>>
            ) {
                val dataArray = response.body()
                resultData.value = if (dataArray != null) ApiResponse.Success(dataArray) else ApiResponse.Empty
            }

            override fun onFailure(call: Call<List<DealResponse>>, t: Throwable) {
                resultData.value = ApiResponse.Error(t.message.toString())
                Log.e("RemoteDataSource", t.message.toString())
            }
        })

        return resultData
    }
}