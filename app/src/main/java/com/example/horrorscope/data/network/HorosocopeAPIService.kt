package com.example.horrorscope.data.network

import com.example.horrorscope.data.network.response.PredicitionResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HorosocopeAPIService {

    @GET("/{sign}")
    suspend fun getHoroscope(@Path("sign") sign: String): PredicitionResponse
}