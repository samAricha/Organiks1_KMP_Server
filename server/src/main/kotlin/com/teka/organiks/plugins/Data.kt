package com.teka.organiks.plugins


import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import com.teka.organiks.data.mysql.migrations.migration1
import com.teka.organiks.data.mysql.seeders.eggCollectionsDemoData

fun Application.configureDataBase() {
    val database: Database = Database.connect(
        url ="jdbc:mysql://localhost:3306/organiks-ktor",
        user = "root",
        password = ""
    )

    transaction(database) {
        //migrations
        migration1()
        //seeders
        eggCollectionsDemoData()
    }

}