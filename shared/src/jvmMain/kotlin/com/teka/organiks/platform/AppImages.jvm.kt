package com.teka.organiks.platform

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

actual class MyAppImages actual constructor(){
    actual val name: String
        get() = "Desktop"

    @Composable
    actual fun getCealChroniclerLogo(): Painter {
        return painterResource("images/laughing7.png")
    }

    @Composable
    actual fun getAmazedLogo(): Painter {
        return painterResource("images/amazed100.png")
    }

    @Composable
    actual fun getEggLogo(): Painter {
        return painterResource("images/egg100.png")
    }

    @Composable
    actual fun getWelcome55Logo(): Painter {
        return painterResource("images/welcome55.png")

    }

    @Composable
    actual fun getWelcome100Logo(): Painter {
        return painterResource("images/welcome100.png")

    }

    @Composable
    actual fun getLetsgo100Logo(): Painter {
        return painterResource("images/letsgo100.png")
    }

    @Composable
    actual fun getPerfect100Logo(): Painter {
        return painterResource("images/perfect100.png")
    }
}