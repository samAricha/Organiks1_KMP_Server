package com.joelkanyi.focusbloom.feature.egg_collection

import database.EggTypeEntity
import java.util.Date

data class ProductionRecordingState(
    val eggTypes: List<EggTypeEntity> = emptyList(),
    val eggCollectionQty: String = "",
    var eggTypeName : String = "",
    val eggsCracked: String = "",
    val date: Date = Date(),
    val isScreenDialogDismissed: Boolean = true,
    val isUpdatingItem: Boolean = false,
)