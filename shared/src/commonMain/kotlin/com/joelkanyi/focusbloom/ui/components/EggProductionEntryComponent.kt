package com.joelkanyi.focusbloom.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.joelkanyi.focusbloom.core.presentation.theme.ButtonShapes
import com.joelkanyi.focusbloom.core.presentation.theme.Shapes
import com.joelkanyi.focusbloom.feature.egg_collection.ProductionRecordingState
import database.EggTypeEntity
import java.util.*

@Composable
fun EggProductionEntryComponent(
    state: ProductionRecordingState,
    onDateSelected: (Date) -> Unit,
    onEggTypeChange:(String) -> Unit,
    onCollectionQuantityChange:(String) -> Unit,
    onCrackedQuantityChange:(String) -> Unit,
    onDialogDismissed:(Boolean) -> Unit,
    onSaveEggType:() -> Unit,
    onSaveEggCollection: () -> Unit,
//    updateEggCollectionQty:() -> Unit,
){

    val eggTypeItems = listOf(
        EggTypeEntity(1, "Kienyeji"),
        EggTypeEntity(2, "Grade")
    )
    var selectedEggTypeItem by remember { mutableStateOf(eggTypeItems[0]) }

    var expanded by remember { mutableStateOf(false) }

    state.eggTypeName = selectedEggTypeItem.name


    var isNewEnabled by remember {
        mutableStateOf(false)
    }

    Column(
    ) {

        TextField(
            value = state.eggCollectionModel.qty,
            label = { Text(text = "Total Eggs Collected") },
            onValueChange = {onCollectionQuantityChange(it)},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
            ),
            shape = Shapes.large
        )

        Spacer(modifier = Modifier.size(24.dp))

        TextField(
            value = state.eggCollectionModel.cracked,
            label = { Text(text = "Cracked Eggs") },
            onValueChange = {onCrackedQuantityChange(it)},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
            ),
            shape = Shapes.large
        )

        Spacer(modifier = Modifier.size(24.dp))


        Row(
            horizontalArrangement = Arrangement.End
        ) {

            //Text("Selected Item: ${selectedEggTypeItem.name}")

            Row(modifier = Modifier
                .width(200.dp)
                .height(40.dp)
                .background(Color.LightGray, Shapes.large)
                .clickable { expanded = true },
                horizontalArrangement = Arrangement.SpaceBetween,

            ) {
                Text(
                    text = selectedEggTypeItem.name,
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .align(Alignment.CenterVertically),

                )
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(end = 8.dp)
                )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                eggTypeItems.forEach { item ->
                    DropdownMenuItem(onClick = {
                        onEggTypeChange(item.name)
                        selectedEggTypeItem = item
                        expanded = false
                    }) {
                        Text(item.name)
                    }
                }
            }
        }


        Spacer(modifier = Modifier.height(34.dp))

        Canvas(
            modifier = Modifier.fillMaxWidth()
        ) {
            val startY = size.height / 2f
            val startX = 0f
            val endX = size.width

            drawLine(
                color = Color.Black, // You can change the color here
                start = Offset(startX, startY),
                end = Offset(endX, startY),
                strokeWidth = 2f, // You can change the line thickness here
                cap = StrokeCap.Round
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        val buttonTitle = if (state.isUpdatingItem) "Update"
        else "Save"

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ){
            Button(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .width(155.dp),
                onClick ={
                    when(state.isUpdatingItem){
                        true -> {
//                            updateEggCollectionQty.invoke()
                        }
                        false -> {
                            onSaveEggCollection.invoke()
                        }
                    }
                },
                enabled = state.eggCollectionModel.qty.isNotEmpty()&&
                        state.eggCollectionModel.cracked.isNotEmpty()&&
                        state.eggTypeName.isNotEmpty(),
                shape = ButtonShapes.large,
            ) {
                Text(text = buttonTitle)

            }
        }
    }


}


