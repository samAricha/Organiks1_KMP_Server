package com.teka.organiks.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Key
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teka.organiks.core.presentation.theme.Cream2
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalMaterial3Api::class, ExperimentalResourceApi::class)
@Composable
fun CustomAppBar(onActionClick: () -> Unit = {}, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .background(Cream2)
            .fillMaxWidth()
    ) {
        TopAppBar(
            modifier = Modifier
                .fillMaxWidth(),
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Cream2,
            ),
            scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(),
            title = {
                Column {
                    Text(
                        text = "OrganiksAiAssistant",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.Black,
                        ),
                    )
                    Text(
                        text = "Organiks + Gemini",
                        style = TextStyle(
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Gray,
                        ),
                    )
                }
            },
            navigationIcon = {
                Row {
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(
                        painter = painterResource("perfect100.png"),
                        contentDescription = "Organiks Mascot",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(45.dp)
                            .clip(CircleShape)
                            .clickable {}
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                }
            },
        )
    }
}