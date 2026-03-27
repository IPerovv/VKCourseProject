package com.iperovv.vkcourseproject.di.modules

import android.content.Context
import androidx.room.Room
import com.iperovv.vkcourseproject.data.local.AppDatabase
import com.iperovv.vkcourseproject.data.local.dao.AppDetailedDao

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext context: Context,
    ): AppDatabase = Room.databaseBuilder(context, AppDatabase::class.java, "apps_database").build()

    @Provides
    fun provideAppDetailedDao(db: AppDatabase): AppDetailedDao = db.appDetailedDao()
}
