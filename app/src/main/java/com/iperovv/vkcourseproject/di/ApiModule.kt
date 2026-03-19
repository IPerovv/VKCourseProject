package com.iperovv.vkcourseproject.di

import com.iperovv.vkcourseproject.data.remote.AppsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    fun provideAppsApi(): AppsApi = AppsApi()
}
