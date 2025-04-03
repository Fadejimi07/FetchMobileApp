package com.example.fetchmobileapp.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.fetchmobileapp.ui.viewmodel.FetchItemsViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Items(viewModel: FetchItemsViewModel = hiltViewModel(), modifier: Modifier) {
    val groupedItems = viewModel.items

    LazyColumn(modifier = modifier) {
        groupedItems.forEach { (header, items) ->
            stickyHeader {
                ItemHeader(header.toString())
            }

            items(items) { item ->
                ListItem(item)
            }
        }
    }
}