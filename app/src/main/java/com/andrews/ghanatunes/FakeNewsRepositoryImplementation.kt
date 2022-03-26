package com.andrews.ghanatunes

import javax.inject.Inject

class FakeNewsRepositoryImplementation @Inject constructor(): NewsRepository {
    override fun getNews(): Collection<NewsModel> {
        return mutableListOf<NewsModel>(
            NewsModel("Fake news for testing", "Test content", "PeaceFm")
        )
    }
}