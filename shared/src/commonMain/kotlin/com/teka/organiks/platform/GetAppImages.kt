package com.teka.organiks.platform

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

class GetAppImages{
    fun getDataFromBackend():String{
        return MyAppImages().name
    }

    @Composable
    fun getLaughingLogo():Painter{
        return MyAppImages().getCealChroniclerLogo()
    }

}


expect class MyAppImages(){
    val name:String
    @Composable
    fun getCealChroniclerLogo(): Painter

    @Composable
    fun getAmazedLogo(): Painter

    @Composable
    fun getEggLogo(): Painter

    @Composable
    fun getWelcome55Logo(): Painter

    @Composable
    fun getWelcome100Logo(): Painter

    @Composable
    fun getLetsgo100Logo(): Painter

    @Composable
    fun getPerfect100Logo(): Painter
}
