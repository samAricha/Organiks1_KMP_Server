package database

import app.cash.sqldelight.Query
import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlCursor
import app.cash.sqldelight.db.SqlDriver
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String

public class TaskQueries(
  driver: SqlDriver,
  private val taskEntityAdapter: TaskEntity.Adapter,
) : TransacterImpl(driver) {
  public fun <T : Any> getAllTasks(mapper: (
    id: Int,
    name: String,
    description: String?,
    type: String,
    start: String,
    color: Long,
    current: String,
    date: String,
    focusSessions: Int,
    currentCycle: Int,
    completed: Boolean,
    consumedFocusTime: Long,
    consumedShortBreakTime: Long,
    consumedLongBreakTime: Long,
    inProgressTask: Boolean,
    active: Boolean,
  ) -> T): Query<T> = Query(-437_603_375, arrayOf("taskEntity"), driver, "task.sq", "getAllTasks",
      "SELECT * FROM taskEntity ORDER BY date DESC") { cursor ->
    mapper(
      taskEntityAdapter.idAdapter.decode(cursor.getLong(0)!!),
      cursor.getString(1)!!,
      cursor.getString(2),
      cursor.getString(3)!!,
      cursor.getString(4)!!,
      taskEntityAdapter.colorAdapter.decode(cursor.getLong(5)!!),
      taskEntityAdapter.currentAdapter.decode(cursor.getString(6)!!),
      cursor.getString(7)!!,
      taskEntityAdapter.focusSessionsAdapter.decode(cursor.getLong(8)!!),
      taskEntityAdapter.currentCycleAdapter.decode(cursor.getLong(9)!!),
      cursor.getBoolean(10)!!,
      taskEntityAdapter.consumedFocusTimeAdapter.decode(cursor.getLong(11)!!),
      taskEntityAdapter.consumedShortBreakTimeAdapter.decode(cursor.getLong(12)!!),
      taskEntityAdapter.consumedLongBreakTimeAdapter.decode(cursor.getLong(13)!!),
      cursor.getBoolean(14)!!,
      cursor.getBoolean(15)!!
    )
  }

  public fun getAllTasks(): Query<TaskEntity> = getAllTasks { id, name, description, type, start,
      color, current, date, focusSessions, currentCycle, completed, consumedFocusTime,
      consumedShortBreakTime, consumedLongBreakTime, inProgressTask, active ->
    TaskEntity(
      id,
      name,
      description,
      type,
      start,
      color,
      current,
      date,
      focusSessions,
      currentCycle,
      completed,
      consumedFocusTime,
      consumedShortBreakTime,
      consumedLongBreakTime,
      inProgressTask,
      active
    )
  }

  public fun <T : Any> getTaskById(id: Int, mapper: (
    id: Int,
    name: String,
    description: String?,
    type: String,
    start: String,
    color: Long,
    current: String,
    date: String,
    focusSessions: Int,
    currentCycle: Int,
    completed: Boolean,
    consumedFocusTime: Long,
    consumedShortBreakTime: Long,
    consumedLongBreakTime: Long,
    inProgressTask: Boolean,
    active: Boolean,
  ) -> T): Query<T> = GetTaskByIdQuery(id) { cursor ->
    mapper(
      taskEntityAdapter.idAdapter.decode(cursor.getLong(0)!!),
      cursor.getString(1)!!,
      cursor.getString(2),
      cursor.getString(3)!!,
      cursor.getString(4)!!,
      taskEntityAdapter.colorAdapter.decode(cursor.getLong(5)!!),
      taskEntityAdapter.currentAdapter.decode(cursor.getString(6)!!),
      cursor.getString(7)!!,
      taskEntityAdapter.focusSessionsAdapter.decode(cursor.getLong(8)!!),
      taskEntityAdapter.currentCycleAdapter.decode(cursor.getLong(9)!!),
      cursor.getBoolean(10)!!,
      taskEntityAdapter.consumedFocusTimeAdapter.decode(cursor.getLong(11)!!),
      taskEntityAdapter.consumedShortBreakTimeAdapter.decode(cursor.getLong(12)!!),
      taskEntityAdapter.consumedLongBreakTimeAdapter.decode(cursor.getLong(13)!!),
      cursor.getBoolean(14)!!,
      cursor.getBoolean(15)!!
    )
  }

  public fun getTaskById(id: Int): Query<TaskEntity> = getTaskById(id) { id_, name, description,
      type, start, color, current, date, focusSessions, currentCycle, completed, consumedFocusTime,
      consumedShortBreakTime, consumedLongBreakTime, inProgressTask, active ->
    TaskEntity(
      id_,
      name,
      description,
      type,
      start,
      color,
      current,
      date,
      focusSessions,
      currentCycle,
      completed,
      consumedFocusTime,
      consumedShortBreakTime,
      consumedLongBreakTime,
      inProgressTask,
      active
    )
  }

  public fun <T : Any> getActiveTask(mapper: (
    id: Int,
    name: String,
    description: String?,
    type: String,
    start: String,
    color: Long,
    current: String,
    date: String,
    focusSessions: Int,
    currentCycle: Int,
    completed: Boolean,
    consumedFocusTime: Long,
    consumedShortBreakTime: Long,
    consumedLongBreakTime: Long,
    inProgressTask: Boolean,
    active: Boolean,
  ) -> T): Query<T> = Query(-1_734_921_713, arrayOf("taskEntity"), driver, "task.sq",
      "getActiveTask", "SELECT * FROM taskEntity WHERE active = 1") { cursor ->
    mapper(
      taskEntityAdapter.idAdapter.decode(cursor.getLong(0)!!),
      cursor.getString(1)!!,
      cursor.getString(2),
      cursor.getString(3)!!,
      cursor.getString(4)!!,
      taskEntityAdapter.colorAdapter.decode(cursor.getLong(5)!!),
      taskEntityAdapter.currentAdapter.decode(cursor.getString(6)!!),
      cursor.getString(7)!!,
      taskEntityAdapter.focusSessionsAdapter.decode(cursor.getLong(8)!!),
      taskEntityAdapter.currentCycleAdapter.decode(cursor.getLong(9)!!),
      cursor.getBoolean(10)!!,
      taskEntityAdapter.consumedFocusTimeAdapter.decode(cursor.getLong(11)!!),
      taskEntityAdapter.consumedShortBreakTimeAdapter.decode(cursor.getLong(12)!!),
      taskEntityAdapter.consumedLongBreakTimeAdapter.decode(cursor.getLong(13)!!),
      cursor.getBoolean(14)!!,
      cursor.getBoolean(15)!!
    )
  }

  public fun getActiveTask(): Query<TaskEntity> = getActiveTask { id, name, description, type,
      start, color, current, date, focusSessions, currentCycle, completed, consumedFocusTime,
      consumedShortBreakTime, consumedLongBreakTime, inProgressTask, active ->
    TaskEntity(
      id,
      name,
      description,
      type,
      start,
      color,
      current,
      date,
      focusSessions,
      currentCycle,
      completed,
      consumedFocusTime,
      consumedShortBreakTime,
      consumedLongBreakTime,
      inProgressTask,
      active
    )
  }

  public fun insertTask(
    name: String,
    description: String?,
    type: String,
    start: String,
    color: Long,
    current: String,
    date: String,
    focusSessions: Int,
    currentCycle: Int,
    completed: Boolean,
    consumedFocusTime: Long,
    consumedShortBreakTime: Long,
    consumedLongBreakTime: Long,
    inProgressTask: Boolean,
    active: Boolean,
  ) {
    driver.execute(411_707_952, """
        |INSERT OR REPLACE
        |INTO taskEntity (name, description, type, start, color, current, date, focusSessions, currentCycle, completed, consumedFocusTime, consumedShortBreakTime, consumedLongBreakTime, inProgressTask, active)
        |VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)
        """.trimMargin(), 15) {
          bindString(0, name)
          bindString(1, description)
          bindString(2, type)
          bindString(3, start)
          bindLong(4, taskEntityAdapter.colorAdapter.encode(color))
          bindString(5, taskEntityAdapter.currentAdapter.encode(current))
          bindString(6, date)
          bindLong(7, taskEntityAdapter.focusSessionsAdapter.encode(focusSessions))
          bindLong(8, taskEntityAdapter.currentCycleAdapter.encode(currentCycle))
          bindBoolean(9, completed)
          bindLong(10, taskEntityAdapter.consumedFocusTimeAdapter.encode(consumedFocusTime))
          bindLong(11,
              taskEntityAdapter.consumedShortBreakTimeAdapter.encode(consumedShortBreakTime))
          bindLong(12, taskEntityAdapter.consumedLongBreakTimeAdapter.encode(consumedLongBreakTime))
          bindBoolean(13, inProgressTask)
          bindBoolean(14, active)
        }
    notifyQueries(411_707_952) { emit ->
      emit("taskEntity")
    }
  }

  public fun updateTask(
    name: String,
    description: String?,
    start: String,
    color: Long,
    current: String,
    date: String,
    focusSessions: Int,
    completed: Boolean,
    active: Boolean,
    id: Int,
  ) {
    driver.execute(-850_388_928,
        """UPDATE taskEntity SET name = ?, description = ?, start = ?, color = ?, current = ?, date = ?, focusSessions = ?, completed = ?, active = ? WHERE id = ?""",
        10) {
          bindString(0, name)
          bindString(1, description)
          bindString(2, start)
          bindLong(3, taskEntityAdapter.colorAdapter.encode(color))
          bindString(4, taskEntityAdapter.currentAdapter.encode(current))
          bindString(5, date)
          bindLong(6, taskEntityAdapter.focusSessionsAdapter.encode(focusSessions))
          bindBoolean(7, completed)
          bindBoolean(8, active)
          bindLong(9, taskEntityAdapter.idAdapter.encode(id))
        }
    notifyQueries(-850_388_928) { emit ->
      emit("taskEntity")
    }
  }

  public fun updateConsumedFocusTime(consumedFocusTime: Long, id: Int) {
    driver.execute(727_061_986, """UPDATE taskEntity SET consumedFocusTime = ? WHERE id = ?""", 2) {
          bindLong(0, taskEntityAdapter.consumedFocusTimeAdapter.encode(consumedFocusTime))
          bindLong(1, taskEntityAdapter.idAdapter.encode(id))
        }
    notifyQueries(727_061_986) { emit ->
      emit("taskEntity")
    }
  }

  public fun updateConsumedShortBreakTime(consumedShortBreakTime: Long, id: Int) {
    driver.execute(-392_916_141,
        """UPDATE taskEntity SET consumedShortBreakTime = ? WHERE id = ?""", 2) {
          bindLong(0,
              taskEntityAdapter.consumedShortBreakTimeAdapter.encode(consumedShortBreakTime))
          bindLong(1, taskEntityAdapter.idAdapter.encode(id))
        }
    notifyQueries(-392_916_141) { emit ->
      emit("taskEntity")
    }
  }

  public fun updateConsumedLongBreakTime(consumedLongBreakTime: Long, id: Int) {
    driver.execute(1_229_536_493,
        """UPDATE taskEntity SET consumedLongBreakTime = ? WHERE id = ?""", 2) {
          bindLong(0, taskEntityAdapter.consumedLongBreakTimeAdapter.encode(consumedLongBreakTime))
          bindLong(1, taskEntityAdapter.idAdapter.encode(id))
        }
    notifyQueries(1_229_536_493) { emit ->
      emit("taskEntity")
    }
  }

  public fun updateInProgressTask(inProgressTask: Boolean, id: Int) {
    driver.execute(-7_646_190, """UPDATE taskEntity SET inProgressTask = ? WHERE id = ?""", 2) {
          bindBoolean(0, inProgressTask)
          bindLong(1, taskEntityAdapter.idAdapter.encode(id))
        }
    notifyQueries(-7_646_190) { emit ->
      emit("taskEntity")
    }
  }

  public fun updateCurrentSessionName(current: String, id: Int) {
    driver.execute(-1_803_539_837, """UPDATE taskEntity SET current = ? WHERE id = ?""", 2) {
          bindString(0, taskEntityAdapter.currentAdapter.encode(current))
          bindLong(1, taskEntityAdapter.idAdapter.encode(id))
        }
    notifyQueries(-1_803_539_837) { emit ->
      emit("taskEntity")
    }
  }

  public fun updateTaskCompleted(completed: Boolean, id: Int) {
    driver.execute(1_165_641_195, """UPDATE taskEntity SET completed = ? WHERE id = ?""", 2) {
          bindBoolean(0, completed)
          bindLong(1, taskEntityAdapter.idAdapter.encode(id))
        }
    notifyQueries(1_165_641_195) { emit ->
      emit("taskEntity")
    }
  }

  public fun updateTaskCycleNumber(currentCycle: Int, id: Int) {
    driver.execute(1_463_059_311, """UPDATE taskEntity SET currentCycle = ? WHERE id = ?""", 2) {
          bindLong(0, taskEntityAdapter.currentCycleAdapter.encode(currentCycle))
          bindLong(1, taskEntityAdapter.idAdapter.encode(id))
        }
    notifyQueries(1_463_059_311) { emit ->
      emit("taskEntity")
    }
  }

  public fun updateTaskActiveStatus(active: Boolean, id: Int) {
    driver.execute(-1_654_297_864, """UPDATE taskEntity SET active = ? WHERE id = ?""", 2) {
          bindBoolean(0, active)
          bindLong(1, taskEntityAdapter.idAdapter.encode(id))
        }
    notifyQueries(-1_654_297_864) { emit ->
      emit("taskEntity")
    }
  }

  public fun updateAllTasksActiveStatusToInactive() {
    driver.execute(-1_736_967_546, """UPDATE taskEntity SET active = 0""", 0)
    notifyQueries(-1_736_967_546) { emit ->
      emit("taskEntity")
    }
  }

  public fun deleteTaskById(id: Int) {
    driver.execute(1_290_670_868, """DELETE FROM taskEntity WHERE id = ?""", 1) {
          bindLong(0, taskEntityAdapter.idAdapter.encode(id))
        }
    notifyQueries(1_290_670_868) { emit ->
      emit("taskEntity")
    }
  }

  public fun deleteAllTasks() {
    driver.execute(-806_074_742, """DELETE FROM taskEntity""", 0)
    notifyQueries(-806_074_742) { emit ->
      emit("taskEntity")
    }
  }

  private inner class GetTaskByIdQuery<out T : Any>(
    public val id: Int,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("taskEntity", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("taskEntity", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> =
        driver.executeQuery(1_659_142_235, """SELECT * FROM taskEntity WHERE id = ?""", mapper, 1) {
      bindLong(0, taskEntityAdapter.idAdapter.encode(id))
    }

    override fun toString(): String = "task.sq:getTaskById"
  }
}
