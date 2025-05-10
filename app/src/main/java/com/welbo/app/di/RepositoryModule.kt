package com.welbo.app.di

import com.welbo.app.data.ImagesRepository
import com.welbo.app.data.ImagesRepositoryImplementation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindImagesRepository(implementation: ImagesRepositoryImplementation): ImagesRepository
}