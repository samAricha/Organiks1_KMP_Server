package org.teka.project.plugins


import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import org.teka.project.data.mysql.migrations.migration1
import org.teka.project.data.mysql.seeders.eggCollectionsDemoData

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