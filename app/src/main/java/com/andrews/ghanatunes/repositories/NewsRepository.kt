package com.andrews.ghanatunes.repositories

import com.andrews.ghanatunes.models.NewsModel

interface NewsRepository {
    fun getNews(): Collection<NewsModel>
}