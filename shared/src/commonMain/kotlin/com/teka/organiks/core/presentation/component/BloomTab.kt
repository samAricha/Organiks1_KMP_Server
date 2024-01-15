package com.teka.organiks.core.presentation.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.teka.organiks.feature.ai_assistant.image_selection.ImageSelectionScreen
import com.teka.organiks.feature.dashborad.DashboardScreen
import com.teka.organiks.feature.egg_collection.ProductionRecordingScreen
import com.teka.organiks.feature.egg_dashboard.ProductionHomeScreen
import com.teka.organiks.feature.settings.SettingsScreen
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

internal sealed class BloomTab {

    internal object SettingsTab : Tab {
        @OptIn(ExperimentalResourceApi::class)
        override val options: TabOptions
            @Composable
            get() {
                val title = "Settings"
                val icon = painterResource("settings_outlined.xml")
                val filledIcon = Icons.Filled.Home
                val outlinedIcon = Icons.Outlined.Home

                return remember {
                    TabOptions(
                        index = 3u,
                        title = title,
                        icon = icon,
                    )
                }
            }

        @Composable
        override fun Content() {
            SettingsScreen()
        }
    }


    internal object MainDashboardTab : Tab {
        @OptIn(ExperimentalResourceApi::class)
        override val options: TabOptions
            @Composable
            get() {
                val title = "DashBoard Screen"
                val icon = painterResource("home_outlined.xml")

                return remember {
                    TabOptions(
                        index = 4u,
                        title = title,
                        icon = icon,
                    )
                }
            }

        @Composable
        override fun Content() {
            DashboardScreen()
        }
    }


    internal object ProductionHomeTab : Tab {
        @OptIn(ExperimentalResourceApi::class)
        override val options: TabOptions
            @Composable
            get() {
                val title = "Records"
                val icon = painterResource("statistics_outlined.xml")

                return remember {
                    TabOptions(
                        index = 4u,
                        title = title,
                        icon = icon,
                    )
                }
            }

        @Composable
        override fun Content() {
            ProductionHomeScreen()
        }
    }

    internal data class ProductionRecordingTab(
        val collectionId: Int? = null,
    ) : Tab {
        @OptIn(ExperimentalResourceApi::class)
        override val options: TabOptions
            @Composable
            get() {
                val title = "Record Collection"
                val icon = painterResource("add_outlined.xml")



                return remember {
                    TabOptions(
                        index = 4u,
                        title = title,
                        icon = icon,
                    )
                }
            }

        @Composable
        override fun Content() {
            ProductionRecordingScreen(collectionId)
        }
    }


    internal object AiAssistantTab : Tab {
        @OptIn(ExperimentalResourceApi::class)
        override val options: TabOptions
            @Composable
            get() {
                val title = "AI Assistant"
                val icon = painterResource("work.xml")



                return remember {
                    TabOptions(
                        index = 4u,
                        title = title,
                        icon = icon,
                    )
                }
            }

        @Composable
        override fun Content() {
            ImageSelectionScreen()
        }
    }

}
