package com.andrews.ghanatunes.data.services

import com.andrews.ghanatunes.domain.model.RadioModel
import com.andrews.ghanatunes.repositories.IRadioService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URL
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


class RadioServiceImpl @Inject constructor (
    val client: OkHttpClient
) : IRadioService{
    val radiosFromService: Flow<List<RadioModel>> = flow{

        emit(listOf<RadioModel>())
    }
        .flowOn(Dispatchers.Default)

    override suspend fun loadRadios(): Flow<List<RadioModel>> {
        return radiosFromService
    }

}