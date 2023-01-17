package com.andrews.ghanatunes.repositories

import com.andrews.ghanatunes.domain.model.RadioModel

interface IRadioRepository {
    fun getAllRadios(): List<RadioModel>
}