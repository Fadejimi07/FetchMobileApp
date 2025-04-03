package com.example.fetchmobileapp.domain.usecases

import com.example.fetchmobileapp.data.repository.FetchItemsRepository
import javax.inject.Inject

class GetItemCountInDBUseCase @Inject constructor(
    private val fetchItemsRepository: FetchItemsRepository
) {
    suspend operator fun invoke(): Int {
        return fetchItemsRepository.getItemsCountInDB()
    }
}