package com.rafif.gamebargainhub.core.data.source.remote

import android.util.Log
import com.rafif.gamebargainhub.core.data.source.remote.network.ApiResponse
import com.rafif.gamebargainhub.core.data.source.remote.network.ApiService
import com.rafif.gamebargainhub.core.data.source.remote.response_model.DealResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource private constructor(private val apiService: ApiService) {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: ApiService): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(service)
            }
    }

    suspend fun getAllDeal(): Flow<ApiResponse<List<DealResponse>>> {
        return flow {
            try {
                val response = apiService.getList()
                if (response.isNotEmpty()) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}