package database

import kotlin.Long
import kotlin.String

public data class Egg_collections(
  public val egg_collection_id: Long,
  public val uuid: String,
  public val qty: String,
  public val cracked: String,
  public val eggTypeId: Long,
  public val date: String,
  public val isBackedUp: Long,
  public val createdAt: Long,
)
