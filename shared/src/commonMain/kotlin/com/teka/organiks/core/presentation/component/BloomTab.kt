package com.teka.organiks.core.presentation.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.teka.organiks.BuildKonfig
import com.teka.organiks.feature.ai_assistant.image_selection.ImageSelectionScreen
import com.teka.organiks.feature.dashborad.DashboardScreen
import com.teka.organiks.feature.egg_collection.ProductionRecordingScreen
import com.teka.organiks.feature.egg_dashboard.ProductionHomeScreen
import com.teka.organiks.feature.settings.SettingsScreen
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import organiks1.shared.generated.resources.Res
import organiks1.shared.generated.resources.add_outlined
import organiks1.shared.generated.resources.home_outlined
import organiks1.shared.generated.resources.letsgo100
import organiks1.shared.generated.resources.settings_outlined
import organiks1.shared.generated.resources.statistics_outlined
import organiks1.shared.generated.resources.study
import presentation.chat_screens.ChatScreen

internal sealed class BloomTab {

    internal object MainDashboardTab : Tab {
        @OptIn(ExperimentalResourceApi::class)
        override val options: TabOptions
            @Composable
            get() {
                val title = "DashBoard Screen"
                val icon = painterResource(Res.drawable.home_outlined)

                return remember {
                    TabOptions(
                        index = 0u,
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
                val icon = painterResource(Res.drawable.statistics_outlined)

                return remember {
                    TabOptions(
                        index = 1u,
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
                val icon = painterResource(resource = Res.drawable.add_outlined)



                return remember {
                    TabOptions(
                        index = 2u,
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
                val icon = painterResource(Res.drawable.study)

                return remember {
                    TabOptions(
                        index = 3u,
                        title = title,
                        icon = icon,
                    )
                }
            }

        @OptIn(ExperimentalResourceApi::class)
        @Composable
        override fun Content() {
//            ImageSelectionScreen()

            ChatScreen(
                geminiKey = BuildKonfig.GEMINI_API_KEY,
                mainTitle = "OrganiksKMP",
                subTitle = "by aricha",
                brandingImg = painterResource(Res.drawable.letsgo100)
            )
        }
    }



    internal object SettingsTab : Tab {
        @OptIn(ExperimentalResourceApi::class)
        override val options: TabOptions
            @Composable
            get() {
                val title = "Settings"
                val icon = painterResource(Res.drawable.settings_outlined)

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
            SettingsScreen()
        }
    }


}
