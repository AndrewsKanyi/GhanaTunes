package com.andrews.ghanatunes.repositories

import com.andrews.ghanatunes.domain.model.RadioModel
import kotlinx.coroutines.flow.Flow

interface IRadioService {

    suspend fun loadRadios() : Flow<List<RadioModel>>
}