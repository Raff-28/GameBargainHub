package com.rafif.gamebargainhub.core.data.source.remote.network

import com.rafif.gamebargainhub.core.data.source.remote.response_model.DealResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("deals")
    fun getList(): Call<List<DealResponse>>
}