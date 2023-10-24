package com.example.horrorscope.domain.model.repositories

import com.example.horrorscope.domain.model.PredictionModel

interface Repository {
    suspend fun getPredictions(sign: String): PredictionModel?
}