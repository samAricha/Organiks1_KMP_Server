package com.joelkanyi.focusbloom.core.data.local_remote_sync


import com.joelkanyi.focusbloom.core.data.local_remote_sync.models.RemoteEggCollectionResponse
import com.joelkanyi.focusbloom.core.data.mapper.toEggCollectionDTO
import com.joelkanyi.focusbloom.core.data.mapper.toEggCollectionEntity
import com.joelkanyi.focusbloom.core.data.remote.RetrofitProvider
import com.joelkanyi.focusbloom.core.domain.model.EggCollectionModel
import com.joelkanyi.focusbloom.core.domain.repository.DbRepository
import com.joelkanyi.focusbloom.core.domain.repository.egg_collections.EggCollectionsRepository
import database.EggCollectionEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


sealed class UpdateResult {
    data class Success(val message: String) : UpdateResult()
    data class Failure(val errorMessage: String) : UpdateResult()
}

class RemoteDataUpdater () {

    suspend fun updateRemoteEggCollectionData(
        eggCollections: List<EggCollectionModel>,
        repository: EggCollectionsRepository
    ): UpdateResult {

        return try{
            withContext(Dispatchers.IO) {
                eggCollections.forEach { eggCollection ->

                        val response = RetrofitProvider.createEggCollectionBackup(eggCollection.toEggCollectionDTO())
//                    val response = RemoteEggCollectionResponse(success = false, message = null)
                    if (response.isSuccess){
                        val updatedEggCollection = eggCollection.copy(isBackedUp = true)

                        repository.updateEggCollection(updatedEggCollection)
//                        Toast.makeText(appContext, "Sync successful.", Toast.LENGTH_SHORT).show()
                        UpdateResult.Success("Data updated successfully.")
                    }else{

                    }
                }
                UpdateResult.Success("Data updated successfully.")
            }
        } catch (e: Exception) {
                e.printStackTrace()
            UpdateResult.Failure("Error updating data: ${e.message}")
        }
    }
}