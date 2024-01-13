package com.joelkanyi.focusbloom.database

import app.cash.sqldelight.Transacter
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import com.joelkanyi.focusbloom.database.Organiks1.shared.newInstance
import com.joelkanyi.focusbloom.database.Organiks1.shared.schema
import database.TaskEntity
import database.TaskQueries
import kotlin.Unit

public interface BloomDatabase : Transacter {
  public val taskQueries: TaskQueries

  public companion object {
    public val Schema: SqlSchema<QueryResult.Value<Unit>>
      get() = BloomDatabase::class.schema

    public operator fun invoke(driver: SqlDriver, taskEntityAdapter: TaskEntity.Adapter):
        BloomDatabase = BloomDatabase::class.newInstance(driver, taskEntityAdapter)
  }
}
