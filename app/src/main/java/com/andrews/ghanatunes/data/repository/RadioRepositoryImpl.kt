package com.andrews.ghanatunes.data.repository

import com.andrews.ghanatunes.domain.model.RadioModel
import com.andrews.ghanatunes.repositories.IRadioRepository
import com.andrews.ghanatunes.repositories.IRadioService
import javax.inject.Inject

class RadioRepositoryImpl @Inject constructor(
    val radioService: IRadioService
): IRadioRepository {
    override fun getAllRadios(): List<RadioModel> {
        val test = radioService.loadRadios()
        return mutableListOf<RadioModel>()
    }

}