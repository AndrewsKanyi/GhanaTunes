package com.andrews.ghanatunes.repositories

import com.andrews.ghanatunes.domain.model.NewsModel

interface INewsRepository {
    fun getEntertainmentNews(): Collection<NewsModel>
}