package com.iperovv.vkcourseproject.data.remote.mapper.di

import com.iperovv.vkcourseproject.data.remote.mapper.AppDetailedMapper
import com.iperovv.vkcourseproject.data.remote.mapper.AppSummaryMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MappersModule {
    @Provides
    fun provideAppDetailedMapper(): AppDetailedMapper = AppDetailedMapper()

    @Provides
    fun provideAppSummaryMapper(): AppSummaryMapper = AppSummaryMapper()
}
