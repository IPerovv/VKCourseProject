package com.iperovv.vkcourseproject.di

import com.iperovv.vkcourseproject.data.AppDetailedRepositoryImpl
import com.iperovv.vkcourseproject.data.AppSummaryRepositoryImpl
import com.iperovv.vkcourseproject.domain.AppDetailedRepository
import com.iperovv.vkcourseproject.domain.AppSummaryRepository
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
    abstract fun bindAppDetailedRepository(impl: AppDetailedRepositoryImpl): AppDetailedRepository

    @Binds
    @Singleton
    abstract fun bindAppSummaryRepository(impl: AppSummaryRepositoryImpl): AppSummaryRepository
}
