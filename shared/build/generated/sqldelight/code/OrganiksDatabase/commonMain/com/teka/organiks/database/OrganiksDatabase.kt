package com.teka.organiks.database

import app.cash.sqldelight.Transacter
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import com.teka.organiks.database.shared.newInstance
import com.teka.organiks.database.shared.schema
import database.Egg_collectionQueries
import database.Egg_typeQueries
import kotlin.Unit

public interface OrganiksDatabase : Transacter {
  public val egg_collectionQueries: Egg_collectionQueries

  public val egg_typeQueries: Egg_typeQueries

  public companion object {
    public val Schema: SqlSchema<QueryResult.Value<Unit>>
      get() = OrganiksDatabase::class.schema

    public operator fun invoke(driver: SqlDriver): OrganiksDatabase =
        OrganiksDatabase::class.newInstance(driver)
  }
}
