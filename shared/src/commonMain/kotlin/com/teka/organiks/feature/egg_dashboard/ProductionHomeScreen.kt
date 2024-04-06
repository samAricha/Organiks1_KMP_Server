package com.teka.organiks.feature.egg_dashboard


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CloudDone
import androidx.compose.material.icons.filled.CloudOff
import androidx.compose.material.icons.outlined.CloudUpload
import androidx.compose.ui.graphics.PathEffect
import com.teka.organiks.core.domain.model.EggCollectionModel
import com.teka.organiks.core.presentation.component.BloomTopAppBar
import com.teka.organiks.core.presentation.theme.PrimaryColor
import com.teka.organiks.core.presentation.theme.SecondaryColor
import com.teka.organiks.core.presentation.theme.SurfaceDark
import com.teka.organiks.core.utils.UiEvents
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.rememberKoinInject
import organiks1.shared.generated.resources.Res
import organiks1.shared.generated.resources.ic_complete


@OptIn(ExperimentalResourceApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ProductionHomeScreen(){
    val productionHomeViewModel = rememberKoinInject<ProductionHomeViewModel>()

    val snackbarHostState = remember { SnackbarHostState() }


    val isSyncing by productionHomeViewModel.isSyncing.collectAsState()



    val eggCollectionsState by productionHomeViewModel.eggCollections.collectAsState()

    LaunchedEffect(key1 = true) {
        withContext(Dispatchers.Main.immediate) {
            productionHomeViewModel.eventsFlow.collect { event ->
                when (event) {
                    is UiEvents.ShowSnackbar -> {
                        snackbarHostState.showSnackbar(
                            message = event.message,
                        )
                    }
                    else -> {}
                }
            }
        }
    }



    Scaffold(
        topBar = {
            BloomTopAppBar(
                hasBackNavigation = false,
            ) {
                Text(text = "Records")
            }
        },
        snackbarHost = {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopCenter, // Change to your desired position
            ) {
                SnackbarHost(
                    hostState = snackbarHostState,
                    snackbar = {
                        Card(
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                                .clickable {
                                    snackbarHostState.currentSnackbarData?.dismiss()
                                },
                            border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary),
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.secondary,
                            ),
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                            ) {
                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth(.85f),
                                    text = it.visuals.message,
                                    style = MaterialTheme.typography.titleSmall.copy(
                                        color = MaterialTheme.colorScheme.onPrimary,
                                    ),
                                )
                                Image(
                                    modifier = Modifier
                                        .size(32.dp),
                                    painter = painterResource(
                                        Res.drawable.ic_complete
                                    ),
                                    contentDescription = "Task Options",
                                )
                            }
                        }
                    },
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                containerColor = MaterialTheme.colorScheme.primary,
                onClick = {
                    productionHomeViewModel.syncRoomDbToRemote()
                },
                elevation = FloatingActionButtonDefaults.elevation(
                    defaultElevation = 0.dp,
                ),
                shape = CircleShape,
            ) {
                Icon(
                    imageVector = Icons.Outlined.CloudUpload,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(24.dp),
                )
            }
        }
    ) {



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
                Icon(
                    imageVector = icon,
                    contentDescription = if (eggCollection.isBackedUp) "Backed Up" else "Not Backed Up",
                    tint = if (eggCollection.isBackedUp) SecondaryColor else SurfaceDark,
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
                val formattedDate = eggCollection.date.date.toString()
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



