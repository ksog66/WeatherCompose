package com.notchdev.weathercompose.data.repository
//
//import androidx.annotation.MainThread
//import androidx.annotation.WorkerThread
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MediatorLiveData
//import com.notchdev.weathercompose.common.Resource
//import retrofit2.Response
//
//abstract class NetworkBoundResource<ResultType, RequestType>
//@MainThread internal constructor() {
//
//    private val result = MediatorLiveData<Resource<ResultType>>()
//    private var dbSource: LiveData<ResultType>
//
//    init {
//        result.value = Resource.Loading(null)
//        @Suppress("LeakingThis")
//        dbSource = loadFromDb()
//        result.addSource(dbSource) { data ->
//            result.removeSource(dbSource)
//            if (shouldFetch(data)) {
//                fetchFromNetwork(dbSource)
//            } else {
//                result.addSource(dbSource) { newData ->
//                    setValue(Resource.Success(newData))
//                }
//            }
//        }
//    }
//
//    @MainThread
//    private fun setValue(newValue: Resource<ResultType>) {
//        if (result.value != newValue) {
//            result.value = newValue
//        }
//    }
//
//    private fun fetchFromNetwork(dbSource: LiveData<ResultType>) {
//        val apiResponse = createCall()
//        // we re-attach dbSource as a new source, it will dispatch its latest value quickly
//        result.addSource(dbSource) { newData ->
//            setValue(Resource.Loading(newData))
//        }
//        if (apiResponse.isSuccessful) {
//            result.removeSource(dbSource)
//            saveResultAndReInit(requestType)
//        } else {
//            onFetchFailed()
//            result.removeSource(dbSource)
//            result.addSource(dbSource) { newData ->
//                result.value = Resource.Error(e)
//            }
//        }
//    }
//
//    protected open fun onFetchFailed() {}
//
//    fun asLiveData() = result as LiveData<Resource<ResultType>>
//
//    @WorkerThread
//    protected abstract fun saveCallResult(item: RequestType)
//
//    @MainThread
//    protected abstract fun shouldFetch(data: ResultType?): Boolean
//
//    @MainThread
//    protected abstract fun loadFromDb(): LiveData<ResultType>
//
//    @MainThread
//    protected abstract fun createCall(): Response<RequestType>
//}