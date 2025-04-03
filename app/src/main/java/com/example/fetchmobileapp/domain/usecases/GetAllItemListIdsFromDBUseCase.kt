package com.example.fetchmobileapp.domain.usecases

import com.example.fetchmobileapp.data.repository.FetchItemsRepository
import javax.inject.Inject

class GetAllItemListIdsFromDBUseCase @Inject constructor(
    private val fetchItemsRepository: FetchItemsRepository
) {
    suspend operator fun invoke(): List<Int> {
        return fetchItemsRepository.getListIdsFromDB()
    }
}