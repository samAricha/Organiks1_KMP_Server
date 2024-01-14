package org.teka.project.data.mysql.mysql_models.egg_collection

import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID


class EggCollectionEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<EggCollectionEntity>(EggCollectionTable)

    var uuid by EggCollectionTable.uuid
    var qty by EggCollectionTable.qty
    var cracked by EggCollectionTable.cracked
    var eggTypeId by EggCollectionTable.eggTypeId
    var date by EggCollectionTable.date
    var isBackedUp by EggCollectionTable.isBackedUp
    var createdAt by EggCollectionTable.createdAt
}

