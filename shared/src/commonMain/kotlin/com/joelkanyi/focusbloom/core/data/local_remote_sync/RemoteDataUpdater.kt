package com.joelkanyi.focusbloom.core.data.local_remote_sync


import com.joelkanyi.focusbloom.core.data.local_remote_sync.models.RemoteEggCollectionResponse
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

    suspend fun updateRemoteEggCollectionData(eggCollections: List<EggCollectionModel>, repository: EggCollectionsRepository): UpdateResult {

        return try{
            withContext(Dispatchers.IO) {
                eggCollections.forEach { eggCollection ->

//                    val eggCollectionRequest = eggCollection.toEggCollectionRequest()

//                        val response = RetrofitProvider.createEggCollectionService().createRemoteEggCollection(eggCollectionRequest)
                    val response = RemoteEggCollectionResponse(success = false, message = null)
                    if (response.success){
                        val updatedEggCollection = eggCollection.copy(isBackedUp = true)

//                        eggCollection.isBackedUp = 1
//                        repository.updateEggCollection(eggCollection)
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