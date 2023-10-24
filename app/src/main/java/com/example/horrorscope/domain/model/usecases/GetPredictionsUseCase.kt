package com.example.horrorscope.domain.model.usecases

import com.example.horrorscope.domain.model.repositories.Repository
import javax.inject.Inject

class GetPredictionsUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(sign: String) = repository.getPredictions(sign)

}