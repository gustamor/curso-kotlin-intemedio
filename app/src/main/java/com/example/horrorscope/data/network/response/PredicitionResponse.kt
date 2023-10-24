package com.example.horrorscope.data.network.response

import com.example.horrorscope.domain.model.PredictionModel
import com.google.gson.annotations.SerializedName

data class PredicitionResponse(
    @SerializedName("date") val date: String,
    @SerializedName("horoscope") val horoscope: String,
    @SerializedName("sign") val sign: String,
) {

    fun toDomain(): PredictionModel {
        return PredictionModel(horoscope = horoscope, sign = sign)
    }
}

