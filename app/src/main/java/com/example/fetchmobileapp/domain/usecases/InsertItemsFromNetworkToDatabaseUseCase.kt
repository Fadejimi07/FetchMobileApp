package com.example.fetchmobileapp.domain.usecases


import com.example.fetchmobileapp.data.local.model.ItemDb
import com.example.fetchmobileapp.data.repository.FetchItemsRepository
import javax.inject.Inject

class InsertItemsFromNetworkToDatabaseUseCase @Inject constructor(
    private val fetchItemsRepository: FetchItemsRepository
) {
    suspend operator fun invoke(items: List<ItemDb>) {
        fetchItemsRepository.insertItemsIntoDB(items)
    }
}