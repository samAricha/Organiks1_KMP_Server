package com.joelkanyi.focusbloom.feature.egg_dashboard


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.Locale
import androidx.compose.foundation.Canvas
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.CloudDone
import androidx.compose.material.icons.filled.CloudOff
import androidx.compose.ui.graphics.PathEffect
import com.joelkanyi.focusbloom.core.domain.model.EggCollectionModel
import com.joelkanyi.focusbloom.core.presentation.theme.PrimaryColor
import org.koin.compose.rememberKoinInject


@Composable
fun ProductionHomeScreen(
    onNavigate:(Int) -> Unit
){
    val productionHomeViewModel = rememberKoinInject<ProductionHomeViewModel>()

//    val productionHomeViewModel : ProductionHomeViewModel = hiltViewModel()
    val eggCollections by productionHomeViewModel.eggCollections.collectAsState()


    val isSyncing by productionHomeViewModel.isSyncing.collectAsState()
    val fabClicked = remember { mutableStateOf(false) }

    val scaffoldState = rememberScaffoldState()

    val snackbarData by productionHomeViewModel.snackbarData.collectAsState()

    if (snackbarData != null) {
        LaunchedEffect(snackbarData) {
            scaffoldState.snackbarHostState.showSnackbar(snackbarData!!.message)
            productionHomeViewModel.clearSnackbar()
        }
    }



    val eggCollectionsState by productionHomeViewModel.eggCollections.collectAsState()



    Scaffold(
        floatingActionButton = {
        FloatingActionButton(onClick = {
            fabClicked.value = true
            productionHomeViewModel.syncRoomDbToRemote()
            fabClicked.value = false

        },
        backgroundColor = PrimaryColor) {
            Icon(
                imageVector = Icons.Filled.Cloud,
                contentDescription = null,
                tint = Color.White
            )
        }
    },
    snackbarHost = {
        SnackbarHost(
            hostState = scaffoldState.snackbarHostState,
            modifier = Modifier.padding(16.dp)
        ) { snackbarData ->
            Snackbar(
                modifier = Modifier.padding(8.dp),
                snackbarData = snackbarData
            )
        }
    }) {
        Box(
            modifier = Modifier.fillMaxSize().padding(top = 16.dp, start = 16.dp, end = 16.dp)
        ){
            LazyColumn {
                items(eggCollectionsState) { collection ->


                    EggCollectionItem(
                        eggCollection = collection as EggCollectionModel,
                        onItemClick = {
//                            onNavigate.invoke(collection.id)
                        }
                    )
                }
            }



            if (isSyncing) {
                ProgressIndicator()
            }
        }
    }
}

@Composable
fun ProgressIndicator(){
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(color = PrimaryColor)
    }
}


@Composable
fun EggCollectionItem(
    eggCollection: EggCollectionModel,
    onItemClick: () -> Unit
){

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onItemClick.invoke()
            }
            .padding(top = 8.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 3.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            val icon = if (eggCollection.isBackedUp) {
                Icons.Filled.CloudDone
            } else {
                Icons.Filled.CloudOff

            }

            Column(modifier = Modifier.padding(0.dp)) {
                Image(
                    imageVector = icon,
                    contentDescription = if (eggCollection.isBackedUp) "Backed Up" else "Not Backed Up"
                )
            }

            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = "Kienyeji",
                )
                Text(text = "Total: ${eggCollection.qty} Eggs",
                )
                Text(text = "Cracked: ${eggCollection.cracked} Eggs",
                )
            }
            Box(modifier = Modifier
                .padding(8.dp)
                .fillMaxSize()) {
                // Date Text
                val formattedDate = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
                    .format(eggCollection.date)
                Text(text = formattedDate,
                    modifier = Modifier.align(Alignment.BottomEnd)
                )
            }

        }

    }
}

@Composable
private fun DrawVerticalDashLine() {
    val pathEffect = PathEffect.dashPathEffect(floatArrayOf(20f, 10f), 0f)
    Canvas(
        modifier = Modifier
            .fillMaxHeight()
            .width(1.5.dp)
    ) {
        drawLine(
            color = Color.Black, // Line color
            strokeWidth = 5f, // Line width
            start = Offset(0f, 0f), // Starting point (left side)
            end = Offset(0f, size.height), // Ending point (bottom)
            pathEffect = pathEffect
        )
    }
}



