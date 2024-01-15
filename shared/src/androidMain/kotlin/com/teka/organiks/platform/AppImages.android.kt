package com.teka.organiks.platform

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.teka.organiks.shared.R

actual class MyAppImages actual constructor(){
    actual val name: String
        get() = "Desktop"

    @Composable
    actual fun getCealChroniclerLogo(): Painter {
        return painterResource(R.drawable.laughing7)
    }

    @Composable
    actual fun getAmazedLogo(): Painter {
        return painterResource(R.drawable.amazed100)
    }

    @Composable
    actual fun getEggLogo(): Painter {
        return painterResource(R.drawable.egg100)
    }

    @Composable
    actual fun getWelcome55Logo(): Painter {
        return painterResource(R.drawable.welcome55)
    }

    @Composable
    actual fun getWelcome100Logo(): Painter {
        return painterResource(R.drawable.welcome100)
    }

    @Composable
    actual fun getLetsgo100Logo(): Painter {
        return painterResource(R.drawable.letsgo100)
    }

    @Composable
    actual fun getPerfect100Logo(): Painter {
        return painterResource(R.drawable.perfect100)
    }
}