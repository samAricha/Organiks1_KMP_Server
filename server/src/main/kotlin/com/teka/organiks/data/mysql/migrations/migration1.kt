package com.teka.organiks.data.mysql.migrations

import com.teka.organiks.data.mysql.mysql_models.egg_collection.EggCollectionTable
import org.jetbrains.exposed.sql.SchemaUtils

fun migration1(){
        SchemaUtils.create(EggCollectionTable)
}