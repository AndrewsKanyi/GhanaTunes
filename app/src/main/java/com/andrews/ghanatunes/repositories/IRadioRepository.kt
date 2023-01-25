package com.andrews.ghanatunes.repositories

import com.andrews.ghanatunes.domain.model.RadioModel
import kotlinx.coroutines.flow.Flow

interface IRadioRepository {
    suspend fun getAllRadios(): Flow<List<RadioModel>>
}