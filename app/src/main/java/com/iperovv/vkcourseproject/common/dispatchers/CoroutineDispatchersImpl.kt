package com.iperovv.vkcourseproject.common.dispatchers

import com.iperovv.vkcourseproject.di.qualifiers.DefaultDispatcher
import com.iperovv.vkcourseproject.di.qualifiers.IoDispatcher
import com.iperovv.vkcourseproject.di.qualifiers.MainDispatcher
import com.iperovv.vkcourseproject.di.qualifiers.UnconfinedDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class CoroutineDispatchersImpl @Inject constructor(
    @MainDispatcher private val mainDispatcher: CoroutineDispatcher,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher,
    @UnconfinedDispatcher private val unconfinedDispatcher: CoroutineDispatcher,
) : CoroutineDispatchers {
    override fun main(): CoroutineDispatcher = mainDispatcher

    override fun io(): CoroutineDispatcher = ioDispatcher

    override fun default(): CoroutineDispatcher = defaultDispatcher

    override fun unconfined(): CoroutineDispatcher = unconfinedDispatcher
}
