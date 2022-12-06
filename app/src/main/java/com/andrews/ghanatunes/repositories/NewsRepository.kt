package com.andrews.ghanatunes.repositories

import com.andrews.ghanatunes.domain.model.NewsModel

interface NewsRepository {
    fun getEntertainmentNews(): Collection<NewsModel>
}