package com.andrews.ghanatunes.data.repository

import android.nfc.Tag
import android.util.Log
import com.andrews.ghanatunes.domain.model.RadioModel
import com.andrews.ghanatunes.repositories.IRadioRepository
import com.andrews.ghanatunes.repositories.IRadioService
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

import javax.inject.Inject

class RadioRepositoryImpl @Inject constructor(
    val radioService: IRadioService
): IRadioRepository {
    private val TAG:String = "Radiorepository"
    override suspend fun getAllRadios(): Flow<List<RadioModel>> {
        return flow{
            coroutineScope {
                launch{
                    radioService.loadRadios()
                    Log.d(TAG, "getAllRadios: ")
                }
            }



        }

    }

}