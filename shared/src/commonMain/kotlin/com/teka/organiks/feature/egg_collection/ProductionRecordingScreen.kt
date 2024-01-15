package com.teka.organiks.feature.egg_collection


import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.teka.organiks.core.presentation.component.BloomTopAppBar
import com.teka.organiks.ui.components.EggProductionEntryComponent
import org.koin.compose.rememberKoinInject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductionRecordingScreen(
    collectionId: Int? = null,
    ){
    val viewModel = rememberKoinInject<ProductionRecordingViewModel>()

//    val viewModel: ProductionRecordingViewModel = hiltViewModel()

    Scaffold(
        topBar = {
            BloomTopAppBar(
                hasBackNavigation = false,
            ) {
                androidx.compose.material3.Text(text = "Data Collection")
            }
        },
    ) {
        ProductionRecording(
            state = viewModel.screenState,
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
