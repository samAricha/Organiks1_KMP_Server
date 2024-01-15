package database

import app.cash.sqldelight.Query
import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlCursor
import app.cash.sqldelight.db.SqlDriver
import kotlin.Any
import kotlin.Long
import kotlin.String

public class Egg_typeQueries(
  driver: SqlDriver,
) : TransacterImpl(driver) {
  public fun <T : Any> getAllEggTypes(mapper: (egg_type_id: Long, name: String) -> T): Query<T> =
      Query(1_510_353_088, arrayOf("eggTypeEntity"), driver, "egg_type.sq", "getAllEggTypes",
      "SELECT * FROM eggTypeEntity") { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!
    )
  }

  public fun getAllEggTypes(): Query<EggTypeEntity> = getAllEggTypes { egg_type_id, name ->
    EggTypeEntity(
      egg_type_id,
      name
    )
  }

  public fun <T : Any> getEggTypeById(egg_type_id: Long, mapper: (egg_type_id: Long,
      name: String) -> T): Query<T> = GetEggTypeByIdQuery(egg_type_id) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!
    )
  }

  public fun getEggTypeById(egg_type_id: Long): Query<EggTypeEntity> = getEggTypeById(egg_type_id) {
      egg_type_id_, name ->
    EggTypeEntity(
      egg_type_id_,
      name
    )
  }

  public fun insertEggType(name: String) {
    driver.execute(2_046_111_237, """INSERT OR REPLACE INTO eggTypeEntity (name) VALUES (?)""", 1) {
          bindString(0, name)
        }
    notifyQueries(2_046_111_237) { emit ->
      emit("eggTypeEntity")
    }
  }

  public fun updateEggType(name: String, egg_type_id: Long) {
    driver.execute(1_061_668_341, """UPDATE eggTypeEntity SET name = ? WHERE egg_type_id = ?""", 2)
        {
          bindString(0, name)
          bindLong(1, egg_type_id)
        }
    notifyQueries(1_061_668_341) { emit ->
      emit("eggTypeEntity")
    }
  }

  public fun deleteEggTypeById(egg_type_id: Long) {
    driver.execute(1_933_559_109, """DELETE FROM eggTypeEntity WHERE egg_type_id = ?""", 1) {
          bindLong(0, egg_type_id)
        }
    notifyQueries(1_933_559_109) { emit ->
      emit("eggTypeEntity")
    }
  }

  public fun deleteAllEggTypes() {
    driver.execute(-337_755_095, """DELETE FROM eggTypeEntity""", 0)
    notifyQueries(-337_755_095) { emit ->
      emit("eggTypeEntity")
    }
  }

  private inner class GetEggTypeByIdQuery<out T : Any>(
    public val egg_type_id: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("eggTypeEntity", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("eggTypeEntity", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> =
        driver.executeQuery(-513_300_004, """SELECT * FROM eggTypeEntity WHERE egg_type_id = ?""",
        mapper, 1) {
      bindLong(0, egg_type_id)
    }

    override fun toString(): String = "egg_type.sq:getEggTypeById"
  }
}
