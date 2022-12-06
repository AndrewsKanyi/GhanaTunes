package com.andrews.ghanatunes.data.di

import com.andrews.ghanatunes.data.repository.FakeNewsRepositoryImplementation
import com.andrews.ghanatunes.repositories.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class DependencyProvider {

    @Binds
    abstract fun getNewsRepository(repository: FakeNewsRepositoryImplementation): NewsRepository
}