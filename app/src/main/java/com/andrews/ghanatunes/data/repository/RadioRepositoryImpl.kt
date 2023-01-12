package com.andrews.ghanatunes.data.repository

import com.andrews.ghanatunes.domain.model.RadioModel
import com.andrews.ghanatunes.repositories.RadioRepository
import javax.inject.Inject

class RadioRepositoryImpl @Inject constructor(): RadioRepository {
    override fun getAllRadios(): List<RadioModel> {
        TODO("Not yet implemented")
    }

}