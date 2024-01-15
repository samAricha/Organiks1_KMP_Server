package org.teka.project.data.mysql.migrations

import org.teka.project.data.mysql.mysql_models.egg_collection.EggCollectionTable
import org.jetbrains.exposed.sql.SchemaUtils

fun migration1(){
        SchemaUtils.create(EggCollectionTable)
}