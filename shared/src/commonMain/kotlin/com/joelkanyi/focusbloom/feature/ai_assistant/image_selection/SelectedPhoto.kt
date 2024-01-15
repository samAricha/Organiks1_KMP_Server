package com.joelkanyi.focusbloom.feature.ai_assistant.image_selection

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mohamedrejeb.calf.picker.toImageBitmap

@Composable
fun SelectedPhoto(
    imageByteArray: ByteArray,
    modifier: Modifier = Modifier,
    iconSize: Dp = 25.dp
) {
    val photoModifier = modifier.clip(RoundedCornerShape(35))

    if(imageByteArray != null) {
        Image(
            bitmap = imageByteArray.toImageBitmap(),
            contentDescription = "selctedImage",
            modifier = photoModifier,
            contentScale = ContentScale.Crop
        )
    } else {
        Box(
            modifier = photoModifier
                .background(MaterialTheme.colors.secondary),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Rounded.Person,
                contentDescription = "imageIcon",
                modifier = Modifier.size(iconSize),
                tint = MaterialTheme.colors.onSecondary
            )
        }
    }
}