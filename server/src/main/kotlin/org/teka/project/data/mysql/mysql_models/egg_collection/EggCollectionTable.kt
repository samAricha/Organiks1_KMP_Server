package org.teka.project.data.mysql.mysql_models.egg_collection

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.dao.id.LongIdTable

object EggCollectionTable : LongIdTable("egg_collections") {
    val uuid = varchar("uuid", 255)
    val qty = varchar("qty", 255)
    val cracked = varchar("cracked", 255)
    val eggTypeId = long("egg_type_id")
    val date = varchar("date", 255)
    val isBackedUp = long("is_backed_up")
    val createdAt = long("created_at")
}
