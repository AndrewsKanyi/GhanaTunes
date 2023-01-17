package com.andrews.ghanatunes.data.repository

import com.andrews.ghanatunes.domain.model.NewsModel
import com.andrews.ghanatunes.repositories.INewsRepository
import javax.inject.Inject

class FakeNewsRepositoryImplementation @Inject constructor(): INewsRepository {
    override fun getEntertainmentNews(): Collection<NewsModel> {
        return mutableListOf<NewsModel>(
            NewsModel("Fake news for testing", "Test content", "PeaceFm")
        )
    }
}