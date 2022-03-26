package com.andrews.ghanatunes

interface NewsRepository {
    fun getNews(): Collection<NewsModel>
}