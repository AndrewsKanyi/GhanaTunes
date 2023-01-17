package com.andrews.ghanatunes.data.di

import android.provider.MediaStore.Audio.Radio
import com.andrews.ghanatunes.data.repository.FakeNewsRepositoryImplementation
import com.andrews.ghanatunes.data.repository.RadioRepositoryImpl
import com.andrews.ghanatunes.data.services.RadioServiceImpl
import com.andrews.ghanatunes.repositories.INewsRepository
import com.andrews.ghanatunes.repositories.IRadioRepository
import com.andrews.ghanatunes.repositories.IRadioService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

@InstallIn(ViewModelComponent::class)
@Module
object DependencyProvider {

    @Provides
    fun getNewsRepository(repository: FakeNewsRepositoryImplementation): INewsRepository{
        return repository
    }

    @Provides
    fun getHttpClient(): OkHttpClient{
        return OkHttpClient()
    }

    @Provides
    fun getRadioService(httpClient: OkHttpClient): IRadioService{
        return RadioServiceImpl(httpClient)
    }

    @Provides
    fun getRadioRepository(radioServiceImpl: RadioServiceImpl): IRadioRepository{
        return RadioRepositoryImpl(radioServiceImpl,)
    }
}
