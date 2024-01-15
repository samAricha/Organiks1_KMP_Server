package com.teka.organiks.core.domain.repository

import com.teka.organiks.core.data.mapper.toEggCollectionEntity
import com.teka.organiks.core.domain.model.EggCollectionModel


class DbRepository(
//    private val eggTypeDao: EggTypeDao,
//    private val eggCollectionDao: EggCollectionDao,
//    private val productionCategoryDao: ProductionCategoryDao
) {
    //the following are methods which are going to help us get our data.

//    val getProductionCategories = productionCategoryDao.getProductionCategories()
//
//    val eggTypes = eggTypeDao.getAllEggTypes()
//    val getEggCollections = eggCollectionDao.getAllEggCollections()
//    val getEggCollectionsWithEggTypes = eggCollectionDao.getEggCollectionsWithEggTypes()
//
//
//
//    //getting our data while filtering it
//    fun getEggCollectionById(id: Int) = eggCollectionDao
//        .getEggCollectionById(id)
//
//    fun getEggTypeById(id: Int) = eggTypeDao
//        .getEggType(id)
//
//
//    //the following are functions that are going to help us insert/save our data
//    suspend fun insertProductionCategory(productionCategory: ProductionCategory){
//        productionCategoryDao.insertProductionCategory(productionCategory = productionCategory)
//    }
    suspend fun insertEggCollection(eggCollection: EggCollectionModel){
        eggCollection.toEggCollectionEntity().let {


        }
    }
//    suspend fun insertEggType(eggType: EggType){
//        eggTypeDao.insert(eggType)
//    }
//
//
//    //the following are functions that are going to help us update our data
//    suspend fun updateEggCollection(eggCollection: EggCollection){
//        eggCollectionDao.update(eggCollection = eggCollection)
//    }
//
//    //the following are functions that are going to help us delete/erase data
//    suspend fun deleteEggCollection(eggCollection: EggCollection){
//        eggCollectionDao.delete(eggCollection = eggCollection)
//    }
//    suspend fun saveRemoteEggCollections(eggCollections: List<EggCollection>){
//        eggCollectionDao.insertEggCollections(eggCollections)
//    }
}