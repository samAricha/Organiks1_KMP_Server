package com.teka.organiks.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.outlined.ImageSearch
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mohamedrejeb.calf.io.readByteArray
import com.mohamedrejeb.calf.picker.FilePickerFileType
import com.mohamedrejeb.calf.picker.FilePickerSelectionMode
import com.mohamedrejeb.calf.picker.rememberFilePickerLauncher
import com.mohamedrejeb.calf.picker.toImageBitmap
import com.teka.organiks.core.presentation.theme.Cream1
import com.teka.organiks.core.presentation.theme.Cream2
import com.teka.organiks.core.presentation.theme.Gray700
import com.teka.organiks.core.presentation.theme.SecondaryLightColor
import com.teka.organiks.domain.model.ChatStatusModel

@Composable
fun CustomBottomSearchBar(
    modifier: Modifier = Modifier,
    status: ChatStatusModel,
    onSendClick: (String, List<ByteArray>) -> Unit
) {
    val textState = remember { mutableStateOf("") }
    val images = remember { mutableStateOf(listOf<ByteArray>()) }
    val scope = rememberCoroutineScope()

    val pickerLauncher = rememberFilePickerLauncher(
        type = FilePickerFileType.Image,
        selectionMode = FilePickerSelectionMode.Multiple,
        onResult = { images.value = it.map { kmpFile -> kmpFile.readByteArray() } }
    )
    Column {
        LazyRow {
            items(images.value.size) { index ->
                val bitmap = images.value[index].toImageBitmap()
                ImageAttachment(
                    bitmap = bitmap,
                    onCloseClick = {
                        val mutableImages = images.value.toMutableList()
                        mutableImages.removeAt(index)
                        images.value = mutableImages
                    }
                )
            }
        }
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextField(
                modifier = Modifier
                    .weight(1f),
                value = textState.value,
                onValueChange = { textState.value = it },
                maxLines = 3,
                placeholder = {
                    Text(
                        text = "Message...",
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = Gray700,
                        ),
                        textAlign = TextAlign.Center
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Cream2,
                    unfocusedContainerColor = Cream2,
                    disabledContainerColor = Cream2,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                leadingIcon = {
                    IconButton(
                        onClick = {
                            pickerLauncher.launch()
                        },
                        content = {
                            Icon(
                                Icons.Outlined.ImageSearch,
                                contentDescription = null,
                                tint = SecondaryLightColor
                            )
                        },
                    )
                },
                shape = RoundedCornerShape(50),
            )

            IconButton(
                modifier = Modifier.padding(5.dp),
                onClick = {
                    onSendClick(textState.value, images.value)
                    images.value = emptyList()
                    textState.value = ""
                },
                enabled = textState.value.isNotBlank() && status != ChatStatusModel.Loading,
                content = {
                    var tintColor = SecondaryLightColor
                    var iconRotation = 0F

                    if (status is ChatStatusModel.Loading) {
                        tintColor = Color.LightGray
                        iconRotation = -90.0F
                    } else {
                        tintColor = SecondaryLightColor
                        iconRotation = 0F
                    }

                    Icon(
                        Icons.Default.Send,
                        contentDescription = null,
                        modifier = Modifier.rotate(iconRotation),
                        tint = tintColor,
                    )
                },
                colors = IconButtonDefaults.iconButtonColors(
                    contentColor = Cream1,
                    containerColor = Cream1,
                    disabledContainerColor = Cream2
                ),
            )

        }

    }
}

@Composable
private fun ImageAttachment(bitmap: ImageBitmap, onCloseClick: () -> Unit = {}) {

    val iconSize = 20.dp
    val offsetInPx = LocalDensity.current.run { (iconSize / 2).roundToPx() }

    Box(modifier = Modifier.padding((iconSize / 3))) {
        Image(
            bitmap = bitmap,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(80.dp)
                .wrapContentWidth()
                .shadow(1.dp, RoundedCornerShape(12.dp)),
        )

        IconButton(
            onClick = {
                onCloseClick()
            },
            modifier = Modifier
                .offset {
                    IntOffset(x = +offsetInPx, y = -offsetInPx)
                }
                .padding(5.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primaryContainer)
                .size(iconSize)
                .align(Alignment.TopEnd)
        ) {
            Icon(
                imageVector = Icons.Rounded.Close,
                contentDescription = "",
                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.size(12.dp)
            )
        }
    }
}
