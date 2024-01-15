package com.teka.organiks.data.mysql.seeders


import com.teka.organiks.data.remote.dto.egg_collection.CreateEggCollectionDto
import com.teka.organiks.domain.repository.EggCollectionRepository


fun eggCollectionsDemoData(){
    val repository = EggCollectionRepository()

    repository.create(
        CreateEggCollectionDto(
        uuid = "c8c2b450-67d5-4e2c-b3a2-3f8ef0012345",
        qty = "10",
        cracked = "2",
        eggTypeId = 1,
        date = "2024-01-15",
        isBackedUp = 0,
        createdAt = 1642252800
    )
    )

    repository.create(
        CreateEggCollectionDto(
        uuid = "another-uuid-here",
        qty = "15",
        cracked = "5",
        eggTypeId = 2,
        date = "2024-02-20",
        isBackedUp = 1,
        createdAt = 1643462400
    )
    )

    repository.create(
        CreateEggCollectionDto(
        uuid = "yet-another-uuid",
        qty = "8",
        cracked = "1",
        eggTypeId = 3,
        date = "2024-03-10",
        isBackedUp = 0,
        createdAt = 1646764800
    )
    )

}
