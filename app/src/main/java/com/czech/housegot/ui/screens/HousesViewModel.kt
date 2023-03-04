package com.czech.housegot.ui.screens

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.czech.housegot.models.Houses
import com.czech.housegot.repositories.HousesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HousesViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val housesRepository: HousesRepository,
): ViewModel() {

    init {
        savedStateHandle.get<Int>("house_id").let { houseId ->
        }
    }

    fun getPagedHouses(): Flow<PagingData<Houses>> =
        housesRepository.getPagedHouses().cachedIn(viewModelScope)

}