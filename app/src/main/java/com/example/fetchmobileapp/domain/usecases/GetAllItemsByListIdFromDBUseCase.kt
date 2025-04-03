package com.example.fetchmobileapp.domain.usecases

import com.example.fetchmobileapp.data.repository.FetchItemsRepository
import com.example.fetchmobileapp.ui.model.Item
import javax.inject.Inject

class GetAllItemsByListIdFromDBUseCase @Inject constructor(
    val fetchItemsRepository: FetchItemsRepository
) {
    suspend operator fun invoke(listId: Int): List<Item> {
        return fetchItemsRepository.getItemsByListIdFromDB(listId)
    }
}