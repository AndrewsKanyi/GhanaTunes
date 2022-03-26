package com.andrews.ghanatunes
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val newsRepository: NewsRepository) : ViewModel() {

    fun getNews(): Collection<NewsModel>{
        return newsRepository.getNews()
    }
}