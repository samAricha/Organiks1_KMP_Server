package database

import app.cash.sqldelight.Query
import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlCursor
import app.cash.sqldelight.db.SqlDriver
import kotlin.Any
import kotlin.Long
import kotlin.String

public class Egg_collectionQueries(
  driver: SqlDriver,
) : TransacterImpl(driver) {
  public fun <T : Any> getAllEggCollections(mapper: (
    egg_collection_id: Long,
    uuid: String,
    qty: String,
    cracked: String,
    eggTypeId: Long,
    date: String,
    isBackedUp: Long,
    createdAt: Long,
  ) -> T): Query<T> = Query(2_096_456_000, arrayOf("eggCollectionEntity"), driver,
      "egg_collection.sq", "getAllEggCollections",
      "SELECT * FROM eggCollectionEntity ORDER BY date DESC") { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3)!!,
      cursor.getLong(4)!!,
      cursor.getString(5)!!,
      cursor.getLong(6)!!,
      cursor.getLong(7)!!
    )
  }

  public fun getAllEggCollections(): Query<EggCollectionEntity> = getAllEggCollections {
      egg_collection_id, uuid, qty, cracked, eggTypeId, date, isBackedUp, createdAt ->
    EggCollectionEntity(
      egg_collection_id,
      uuid,
      qty,
      cracked,
      eggTypeId,
      date,
      isBackedUp,
      createdAt
    )
  }

  public fun <T : Any> getEggCollectionById(egg_collection_id: Long, mapper: (
    egg_collection_id: Long,
    uuid: String,
    qty: String,
    cracked: String,
    eggTypeId: Long,
    date: String,
    isBackedUp: Long,
    createdAt: Long,
  ) -> T): Query<T> = GetEggCollectionByIdQuery(egg_collection_id) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3)!!,
      cursor.getLong(4)!!,
      cursor.getString(5)!!,
      cursor.getLong(6)!!,
      cursor.getLong(7)!!
    )
  }

  public fun getEggCollectionById(egg_collection_id: Long): Query<EggCollectionEntity> =
      getEggCollectionById(egg_collection_id) { egg_collection_id_, uuid, qty, cracked, eggTypeId,
      date, isBackedUp, createdAt ->
    EggCollectionEntity(
      egg_collection_id_,
      uuid,
      qty,
      cracked,
      eggTypeId,
      date,
      isBackedUp,
      createdAt
    )
  }

  public fun <T : Any> getEggCollectionByUUId(uuid: String, mapper: (
    egg_collection_id: Long,
    uuid: String,
    qty: String,
    cracked: String,
    eggTypeId: Long,
    date: String,
    isBackedUp: Long,
    createdAt: Long,
  ) -> T): Query<T> = GetEggCollectionByUUIdQuery(uuid) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3)!!,
      cursor.getLong(4)!!,
      cursor.getString(5)!!,
      cursor.getLong(6)!!,
      cursor.getLong(7)!!
    )
  }

  public fun getEggCollectionByUUId(uuid: String): Query<EggCollectionEntity> =
      getEggCollectionByUUId(uuid) { egg_collection_id, uuid_, qty, cracked, eggTypeId, date,
      isBackedUp, createdAt ->
    EggCollectionEntity(
      egg_collection_id,
      uuid_,
      qty,
      cracked,
      eggTypeId,
      date,
      isBackedUp,
      createdAt
    )
  }

  public fun insertEggCollection(
    uuid: String,
    qty: String,
    cracked: String,
    eggTypeId: Long,
    date: String,
    isBackedUp: Long,
    createdAt: Long,
  ) {
    driver.execute(-1_912_166_395, """
        |INSERT OR REPLACE INTO eggCollectionEntity (
        |    uuid,
        |    qty,
        |    cracked,
        |    eggTypeId,
        |    date,
        |    isBackedUp,
        |    createdAt
        |) VALUES (?, ?, ?, ?, ?, ?, ?)
        """.trimMargin(), 7) {
          bindString(0, uuid)
          bindString(1, qty)
          bindString(2, cracked)
          bindLong(3, eggTypeId)
          bindString(4, date)
          bindLong(5, isBackedUp)
          bindLong(6, createdAt)
        }
    notifyQueries(-1_912_166_395) { emit ->
      emit("eggCollectionEntity")
    }
  }

  public fun updateEggCollection(
    uuid: String,
    qty: String,
    cracked: String,
    eggTypeId: Long,
    date: String,
    isBackedUp: Long,
    createdAt: Long,
    egg_collection_id: Long,
  ) {
    driver.execute(-224_162_827, """
        |UPDATE eggCollectionEntity SET
        |    uuid = ?,
        |    qty = ?,
        |    cracked = ?,
        |    eggTypeId = ?,
        |    date = ?,
        |    isBackedUp = ?,
        |    createdAt = ?
        |WHERE egg_collection_id = ?
        """.trimMargin(), 8) {
          bindString(0, uuid)
          bindString(1, qty)
          bindString(2, cracked)
          bindLong(3, eggTypeId)
          bindString(4, date)
          bindLong(5, isBackedUp)
          bindLong(6, createdAt)
          bindLong(7, egg_collection_id)
        }
    notifyQueries(-224_162_827) { emit ->
      emit("eggCollectionEntity")
    }
  }

  public fun updateEggCollectionByUUId(
    qty: String,
    cracked: String,
    eggTypeId: Long,
    date: String,
    isBackedUp: Long,
    createdAt: Long,
    uuid: String,
  ) {
    driver.execute(1_180_098_823, """
        |UPDATE eggCollectionEntity SET
        |    qty = ?,
        |    cracked = ?,
        |    eggTypeId = ?,
        |    date = ?,
        |    isBackedUp = ?,
        |    createdAt = ?
        |WHERE uuid = ?
        """.trimMargin(), 7) {
          bindString(0, qty)
          bindString(1, cracked)
          bindLong(2, eggTypeId)
          bindString(3, date)
          bindLong(4, isBackedUp)
          bindLong(5, createdAt)
          bindString(6, uuid)
        }
    notifyQueries(1_180_098_823) { emit ->
      emit("eggCollectionEntity")
    }
  }

  public fun deleteEggCollectionById(egg_collection_id: Long) {
    driver.execute(-339_268_411, """DELETE FROM eggCollectionEntity WHERE egg_collection_id = ?""",
        1) {
          bindLong(0, egg_collection_id)
        }
    notifyQueries(-339_268_411) { emit ->
      emit("eggCollectionEntity")
    }
  }

  public fun deleteAllEggCollections() {
    driver.execute(-1_118_003_679, """DELETE FROM eggCollectionEntity""", 0)
    notifyQueries(-1_118_003_679) { emit ->
      emit("eggCollectionEntity")
    }
  }

  private inner class GetEggCollectionByIdQuery<out T : Any>(
    public val egg_collection_id: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("eggCollectionEntity", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("eggCollectionEntity", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> =
        driver.executeQuery(-1_419_776_028,
        """SELECT * FROM eggCollectionEntity WHERE egg_collection_id = ?""", mapper, 1) {
      bindLong(0, egg_collection_id)
    }

    override fun toString(): String = "egg_collection.sq:getEggCollectionById"
  }

  private inner class GetEggCollectionByUUIdQuery<out T : Any>(
    public val uuid: String,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("eggCollectionEntity", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("eggCollectionEntity", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> =
        driver.executeQuery(1_395_182_660, """SELECT * FROM eggCollectionEntity WHERE uuid = ?""",
        mapper, 1) {
      bindString(0, uuid)
    }

    override fun toString(): String = "egg_collection.sq:getEggCollectionByUUId"
  }
}
