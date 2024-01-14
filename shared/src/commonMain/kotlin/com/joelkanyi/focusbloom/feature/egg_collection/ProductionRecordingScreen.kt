package com.joelkanyi.focusbloom.feature.egg_collection


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.joelkanyi.focusbloom.feature.onboarding.OnboadingViewModel
import com.joelkanyi.focusbloom.ui.components.EggProductionEntryComponent
import org.koin.compose.rememberKoinInject
import java.util.*

@Composable
fun ProductionRecordingScreen(
    collectionId: Int? = null,
    ){
    val viewModel = rememberKoinInject<ProductionRecordingViewModel>()

//    val viewModel: ProductionRecordingViewModel = hiltViewModel()

    Scaffold() {
        ProductionRecording(
            state = viewModel.state,
            viewModel = viewModel,
        )
    }
}


@Composable
fun ProductionRecording(
    state: ProductionRecordingState,
    viewModel: ProductionRecordingViewModel,
) {
    Column(Modifier.padding(horizontal = 16.dp, vertical = 16.dp)) {

        Spacer(modifier = Modifier.size(16.dp))

        EggProductionEntryComponent(
            state,
            onDateSelected = viewModel::onDateChange,
            onEggTypeChange = viewModel::onEggTypeChange,
            onCollectionQuantityChange = viewModel::onQtyChange,
            onCrackedQuantityChange = viewModel::onCrackedQtyChange,
            onDialogDismissed = viewModel::onScreenDialogDismissed,
            onSaveEggType = viewModel::onSaveEggCollection,
//                    updateEggCollectionQty =  viewModel::updateEggCollection ,
            onSaveEggCollection = viewModel::onSaveEggCollection,
        )

    }
}
