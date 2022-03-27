package com.andrews.ghanatunes

import com.andrews.ghanatunes.repositories.FakeNewsRepositoryImplementation
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