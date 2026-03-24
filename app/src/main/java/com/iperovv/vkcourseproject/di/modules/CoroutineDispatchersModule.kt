package com.iperovv.vkcourseproject.di.modules

import com.iperovv.vkcourseproject.common.dispatchers.CoroutineDispatchers
import com.iperovv.vkcourseproject.common.dispatchers.CoroutineDispatchersImpl
import com.iperovv.vkcourseproject.di.qualifiers.DefaultDispatcher
import com.iperovv.vkcourseproject.di.qualifiers.IoDispatcher
import com.iperovv.vkcourseproject.di.qualifiers.MainDispatcher
import com.iperovv.vkcourseproject.di.qualifiers.UnconfinedDispatcher
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CoroutineDispatchersModule {
    @Binds
    @Singleton
    abstract fun bindCoroutineDispatchers(impl: CoroutineDispatchersImpl): CoroutineDispatchers

    companion object {
        @IoDispatcher
        @Provides
        fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

        @MainDispatcher
        @Provides
        fun provideMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

        @DefaultDispatcher
        @Provides
        fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

        @UnconfinedDispatcher
        @Provides
        fun provideUnconfinedDispatcher(): CoroutineDispatcher = Dispatchers.Unconfined
    }
}
