package com.teka.organiks

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.teka.organiks.core.presentation.theme.FocusBloomTheme
import com.teka.organiks.core.utils.ProvideAppNavigator
import com.teka.organiks.feature.onboarding.OnboardingScreen
import com.teka.organiks.main.MainScreen
import com.teka.organiks.main.MainViewModel
import com.teka.organiks.main.OnBoardingState
import com.teka.organiks.platform.StatusBarColors
import org.koin.compose.KoinContext
import org.koin.compose.koinInject

@Composable
fun FocusBloomApp(
    mainViewModel: MainViewModel = koinInject(),
) {
    val darkTheme = when (mainViewModel.appTheme.collectAsState().value) {
        1 -> true
        else -> false
    }
    val onBoardingCompleted = mainViewModel.onBoardingCompleted.collectAsState().value

    KoinContext {
        FocusBloomTheme(
            useDarkTheme = darkTheme,
        ) {
            StatusBarColors(
                statusBarColor = MaterialTheme.colorScheme.background,
                navBarColor = MaterialTheme.colorScheme.background,
            )
            when (onBoardingCompleted) {
                is OnBoardingState.Success -> {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background,
                    ) {
                        Navigator(
                            screen = if (onBoardingCompleted.completed) {
                                MainScreen()
                            } else {
                                OnboardingScreen()
                            },
                            content = { navigator ->
                                ProvideAppNavigator(
                                    navigator = navigator,
                                    content = { SlideTransition(navigator = navigator) },
                                )
                            },
                        )
                    }
                }

                else -> {}
            }
        }
    }
}
