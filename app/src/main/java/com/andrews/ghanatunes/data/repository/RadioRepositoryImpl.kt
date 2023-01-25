package com.andrews.ghanatunes.data.repository

import com.andrews.ghanatunes.domain.model.RadioModel
import com.andrews.ghanatunes.repositories.IRadioRepository
import com.andrews.ghanatunes.repositories.IRadioService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

import javax.inject.Inject

class RadioRepositoryImpl @Inject constructor(
    val radioService: IRadioService
): IRadioRepository {

    override suspend fun getAllRadios(): Flow<List<RadioModel>> {
     return radioService.loadRadios()
    }



}