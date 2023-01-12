package com.andrews.ghanatunes.repositories

import com.andrews.ghanatunes.domain.model.RadioModel

interface RadioRepository {
    fun getAllRadios(): List<RadioModel>
}