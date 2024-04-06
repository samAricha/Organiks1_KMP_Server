package com.teka.organiks.database.shared

import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.AfterVersion
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import com.teka.organiks.database.OrganiksDatabase
import database.Egg_collectionQueries
import database.Egg_typeQueries
import kotlin.Long
import kotlin.Unit
import kotlin.reflect.KClass

internal val KClass<OrganiksDatabase>.schema: SqlSchema<QueryResult.Value<Unit>>
  get() = OrganiksDatabaseImpl.Schema

internal fun KClass<OrganiksDatabase>.newInstance(driver: SqlDriver): OrganiksDatabase =
    OrganiksDatabaseImpl(driver)

private class OrganiksDatabaseImpl(
  driver: SqlDriver,
) : TransacterImpl(driver), OrganiksDatabase {
  override val egg_collectionQueries: Egg_collectionQueries = Egg_collectionQueries(driver)

  override val egg_typeQueries: Egg_typeQueries = Egg_typeQueries(driver)

  public object Schema : SqlSchema<QueryResult.Value<Unit>> {
    override val version: Long
      get() = 1

    override fun create(driver: SqlDriver): QueryResult.Value<Unit> {
      driver.execute(null, """
          |CREATE TABLE eggCollectionEntity (
          |    egg_collection_id INTEGER PRIMARY KEY AUTOINCREMENT,
          |    uuid TEXT NOT NULL,
          |    qty TEXT NOT NULL,
          |    cracked TEXT NOT NULL,
          |    eggTypeId INTEGER NOT NULL,
          |    date TEXT NOT NULL,
          |    isBackedUp INTEGER NOT NULL,
          |    createdAt INTEGER NOT NULL
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE eggTypeEntity (
          |    egg_type_id INTEGER PRIMARY KEY AUTOINCREMENT,
          |    name TEXT NOT NULL
          |)
          """.trimMargin(), 0)
      return QueryResult.Unit
    }

    override fun migrate(
      driver: SqlDriver,
      oldVersion: Long,
      newVersion: Long,
      vararg callbacks: AfterVersion,
    ): QueryResult.Value<Unit> = QueryResult.Unit
  }
}
