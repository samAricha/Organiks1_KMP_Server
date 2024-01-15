package com.joelkanyi.focusbloom.core.data.local_remote_sync

import com.joelkanyi.focusbloom.core.domain.repository.DbRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
//import teka.android.organiks_platform_android.data.remote.retrofit.RetrofitProvider
//import teka.android.organiks_platform_android.data.remote.retrofit.toEggCollection
//import teka.android.organiks_platform_android.data.remote.retrofit.toMilkCollection
//import teka.android.organiks_platform_android.data.room.models.EggCollection
//import teka.android.organiks_platform_android.data.room.models.MilkCollection
//import teka.android.organiks_platform_android.repository.DbRepository


class FetchRemoteData {
    suspend fun fetchRemoteEggCollectionDataAndSaveLocally(repository: DbRepository){
        withContext(Dispatchers.IO) {
            try {
//                val response = RetrofitProvider.createEggCollectionService().getEggCollections()
//                val eggCollections: List<EggCollection> = response.results.map { it.toEggCollection() }
//                val repositoryResponse = repository.saveRemoteEggCollections(eggCollections)

            } catch (e: Exception) {

            }
        }
    }

}