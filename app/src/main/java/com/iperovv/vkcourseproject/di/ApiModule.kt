package com.iperovv.vkcourseproject.di

import com.iperovv.vkcourseproject.data.remote.api.AppsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    fun provideAppsApi(retrofit: Retrofit): AppsApi = retrofit.create(AppsApi::class.java)
}