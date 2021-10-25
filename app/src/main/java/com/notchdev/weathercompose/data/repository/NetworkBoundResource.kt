package com.notchdev.weathercompose.data.repository
//
import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.notchdev.weathercompose.common.Resource
import kotlinx.coroutines.flow.*

inline fun <ResultType,RequestType> networkBoundResource(
    crossinline query : () -> Flow<ResultType>,
    crossinline fetch : suspend () -> RequestType,
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    crossinline shouldFetch: (ResultType) -> Boolean = { true }
    ) = flow {
        val data = query().first()

        val flow  = if (shouldFetch(data)) {
            emit(Resource.Loading(data))

           try {
               saveFetchResult(fetch())
               query().map { Resource.Success(it)}
           } catch (throwable: Throwable) {
               query().map { Resource.Error(throwable,it) }
           }
        } else {
            query().map { Resource.Success(it) }
        }
    emitAll(flow)
}