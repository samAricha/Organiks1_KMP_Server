package com.joelkanyi.focusbloom.feature.dashborad

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Egg
import androidx.compose.material.icons.outlined.SyncProblem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.joelkanyi.focusbloom.core.presentation.theme.PrimaryLightColor
import org.koin.compose.rememberKoinInject


@Composable
fun DashboardScreen() {
    val viewModel = rememberKoinInject<DashboardViewModel>()

    val eggs by viewModel.eggCollections.collectAsState()
    val totalEggsCollected =  eggs.size
    val totalNotBackedUpCount by viewModel.totalNotBackedUpCount.collectAsState()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Dashboard",
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.h6
        )
        Column(
        ) {
            DashboardCard(
                title = "Egg Collections",
                value = "$totalEggsCollected Collections",
                iconVector = Icons.Outlined.Egg,
                color = PrimaryLightColor
            )

            DashboardCard(
                title = "Not Backed up",
                value = "$totalNotBackedUpCount Records",
                iconVector = Icons.Outlined.SyncProblem,
                color = Color(0xFFE57373)
            )
        }
    }
}

@Composable
fun DashboardCard(
    title: String,
    value: String,
    iconVector: ImageVector, // Resource ID for the icon drawable
    color: Color
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = iconVector, // Use the loaded drawable
                contentDescription = null,
                tint = color,
                modifier = Modifier.size(48.dp)
            )
            Text(
                text = title,
                modifier = Modifier.padding(top = 8.dp),
            )
            Text(
                text = value,
                style = TextStyle(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(top = 8.dp),
            )
        }
    }
}

