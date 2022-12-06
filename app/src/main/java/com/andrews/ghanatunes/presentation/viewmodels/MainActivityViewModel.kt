package com.andrews.ghanatunes.presentation.viewmodels
import androidx.lifecycle.ViewModel
import com.andrews.ghanatunes.domain.model.NewsModel
import com.andrews.ghanatunes.repositories.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val newsRepository: NewsRepository) : ViewModel() {

    fun getNews(): Collection<NewsModel>{
        return newsRepository.getEntertainmentNews()
    }
}