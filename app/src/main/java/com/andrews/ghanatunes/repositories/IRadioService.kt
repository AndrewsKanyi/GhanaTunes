package com.andrews.ghanatunes.repositories

import com.andrews.ghanatunes.domain.model.RadioModel

interface IRadioService {

    fun loadRadios() : Collection<RadioModel>
}