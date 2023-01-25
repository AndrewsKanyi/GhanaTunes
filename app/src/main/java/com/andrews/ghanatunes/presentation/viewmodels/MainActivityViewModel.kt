package com.andrews.ghanatunes.presentation.viewmodels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andrews.ghanatunes.domain.model.NewsModel
import com.andrews.ghanatunes.domain.model.RadioModel
import com.andrews.ghanatunes.repositories.INewsRepository
import com.andrews.ghanatunes.repositories.IRadioRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val newsRepository: INewsRepository,
    private val radioRepository: IRadioRepository
) : ViewModel() {

    private val radios:MutableCollection<RadioModel> = mutableListOf<RadioModel>()
    init {
        viewModelScope.launch {
            radioRepository.getAllRadios().collect{radiolist->
             radiolist.forEach{
                 radios.add(it)
             }
            }

        }
    }
    fun getNews(): Collection<NewsModel>{
        return newsRepository.getEntertainmentNews()
    }




}