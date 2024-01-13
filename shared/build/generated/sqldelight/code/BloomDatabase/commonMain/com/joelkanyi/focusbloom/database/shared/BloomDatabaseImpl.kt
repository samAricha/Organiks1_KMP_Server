package com.joelkanyi.focusbloom.database.shared

import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.AfterVersion
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import com.joelkanyi.focusbloom.database.BloomDatabase
import database.TaskEntity
import database.TaskQueries
import kotlin.Long
import kotlin.Unit
import kotlin.reflect.KClass

internal val KClass<BloomDatabase>.schema: SqlSchema<QueryResult.Value<Unit>>
  get() = BloomDatabaseImpl.Schema

internal fun KClass<BloomDatabase>.newInstance(driver: SqlDriver,
    taskEntityAdapter: TaskEntity.Adapter): BloomDatabase = BloomDatabaseImpl(driver,
    taskEntityAdapter)

private class BloomDatabaseImpl(
  driver: SqlDriver,
  taskEntityAdapter: TaskEntity.Adapter,
) : TransacterImpl(driver), BloomDatabase {
  override val taskQueries: TaskQueries = TaskQueries(driver, taskEntityAdapter)

  public object Schema : SqlSchema<QueryResult.Value<Unit>> {
    override val version: Long
      get() = 1

    override fun create(driver: SqlDriver): QueryResult.Value<Unit> {
      driver.execute(null, """
          |CREATE TABLE taskEntity (
          |    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
          |    name TEXT NOT NULL,
          |    description TEXT,
          |    type TEXT NOT NULL,
          |    start TEXT NOT NULL,
          |    color INTEGER NOT NULL,
          |    current TEXT NOT NULL,
          |    date TEXT NOT NULL,
          |    focusSessions INTEGER NOT NULL,
          |    currentCycle INTEGER NOT NULL,
          |    completed INTEGER NOT NULL,
          |    consumedFocusTime INTEGER NOT NULL,
          |    consumedShortBreakTime INTEGER NOT NULL,
          |    consumedLongBreakTime INTEGER NOT NULL,
          |    inProgressTask INTEGER NOT NULL,
          |    active INTEGER NOT NULL
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
