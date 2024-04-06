package com.teka.organiks.core.presentation.utils

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.Tab
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import organiks1.shared.generated.resources.Res
import organiks1.shared.generated.resources.add_filled
import organiks1.shared.generated.resources.home_filled
import organiks1.shared.generated.resources.settings_filled
import organiks1.shared.generated.resources.statistics_filled
import organiks1.shared.generated.resources.study

@Composable
@OptIn(ExperimentalResourceApi::class)
fun FilledIcon(item: Tab) = when (item.options.index) {
    (0u).toUShort() -> painterResource(Res.drawable.home_filled)
    (1u).toUShort() -> painterResource(Res.drawable.statistics_filled)
    (2u).toUShort() -> painterResource(Res.drawable.add_filled)
    (3u).toUShort() -> painterResource(Res.drawable.study)
    (4u).toUShort() -> painterResource(Res.drawable.settings_filled)
    else -> painterResource(Res.drawable.home_filled)
}
