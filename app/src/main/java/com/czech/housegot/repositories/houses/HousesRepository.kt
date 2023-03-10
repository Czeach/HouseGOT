package com.czech.housegot.repositories.houses

import androidx.paging.PagingData
import com.czech.housegot.models.Houses
import kotlinx.coroutines.flow.Flow

interface HousesRepository {

    fun getPagedHouses(): Flow<PagingData<Houses>>
}