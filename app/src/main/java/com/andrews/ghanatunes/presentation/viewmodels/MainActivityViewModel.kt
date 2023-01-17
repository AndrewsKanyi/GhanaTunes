package com.andrews.ghanatunes.presentation.viewmodels
import androidx.lifecycle.ViewModel
import com.andrews.ghanatunes.domain.model.NewsModel
import com.andrews.ghanatunes.domain.model.RadioModel
import com.andrews.ghanatunes.repositories.INewsRepository
import com.andrews.ghanatunes.repositories.IRadioRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val newsRepository: INewsRepository,
    private val radioRepository: IRadioRepository
) : ViewModel() {

    fun getNews(): Collection<NewsModel>{
        return newsRepository.getEntertainmentNews()
    }

    fun getRadios(): Collection<RadioModel>{
         return radioRepository.getAllRadios()
    }
}