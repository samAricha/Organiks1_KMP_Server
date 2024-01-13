package database

import app.cash.sqldelight.ColumnAdapter
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String

public data class TaskEntity(
  public val id: Int,
  public val name: String,
  public val description: String?,
  public val type: String,
  public val start: String,
  public val color: Long,
  public val current: String,
  public val date: String,
  public val focusSessions: Int,
  public val currentCycle: Int,
  public val completed: Boolean,
  public val consumedFocusTime: Long,
  public val consumedShortBreakTime: Long,
  public val consumedLongBreakTime: Long,
  public val inProgressTask: Boolean,
  public val active: Boolean,
) {
  public class Adapter(
    public val idAdapter: ColumnAdapter<Int, Long>,
    public val colorAdapter: ColumnAdapter<Long, Long>,
    public val currentAdapter: ColumnAdapter<String, String>,
    public val focusSessionsAdapter: ColumnAdapter<Int, Long>,
    public val currentCycleAdapter: ColumnAdapter<Int, Long>,
    public val consumedFocusTimeAdapter: ColumnAdapter<Long, Long>,
    public val consumedShortBreakTimeAdapter: ColumnAdapter<Long, Long>,
    public val consumedLongBreakTimeAdapter: ColumnAdapter<Long, Long>,
  )
}
