package com.example.horrorscope.data.network

import android.util.Log
import com.example.horrorscope.domain.model.PredictionModel
import com.example.horrorscope.domain.model.repositories.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val api: HorosocopeAPIService) : Repository {
    override suspend fun getPredictions(sign: String): PredictionModel? {
        runCatching {
            api.getHoroscope(sign)
        }.onSuccess {
            return it.toDomain()
        }.onFailure {
            Log.i("GusMor", "Ha ocurrido una desgracia, no me amo ${it.message}")
        }
        return null
    }
}