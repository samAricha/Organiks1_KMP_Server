package com.joelkanyi.focusbloom.feature.egg_collection

import com.joelkanyi.focusbloom.core.domain.model.EggCollectionModel
import com.joelkanyi.focusbloom.core.domain.model.EggTypeModel
import java.util.Date

data class ProductionRecordingState(
    val eggTypes: List<EggTypeModel> = emptyList(),
    val eggCollectionModel: EggCollectionModel = EggCollectionModel(),
    var eggTypeName : String = "",
    val date: Date = Date(),
    val isScreenDialogDismissed: Boolean = true,
    val isUpdatingItem: Boolean = false,
)