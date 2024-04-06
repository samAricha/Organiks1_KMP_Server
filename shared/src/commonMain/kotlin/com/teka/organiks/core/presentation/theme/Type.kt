package com.teka.organiks.core.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font
import organiks1.shared.generated.resources.Res
import organiks1.shared.generated.resources.montserrat_black
import organiks1.shared.generated.resources.montserrat_bold
import organiks1.shared.generated.resources.montserrat_extrabold
import organiks1.shared.generated.resources.montserrat_extralight
import organiks1.shared.generated.resources.montserrat_light
import organiks1.shared.generated.resources.montserrat_medium
import organiks1.shared.generated.resources.montserrat_regular
import organiks1.shared.generated.resources.montserrat_semi_bold
import organiks1.shared.generated.resources.montserrat_thin

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun getTypography(): Typography {


    val montserratRegular =
        Font(
            resource = Res.font.montserrat_regular,
            weight = FontWeight.Normal,
            style = FontStyle.Normal,
        )

    val montserratBold =
        Font(
            resource = Res.font.montserrat_bold,
            weight = FontWeight.Bold,
            style = FontStyle.Normal,
        )

    val montserratLight =
        Font(
            resource = Res.font.montserrat_light,
            weight = FontWeight.Light,
            style = FontStyle.Normal,
        )

    val montserratMedium =
        Font(
            resource = Res.font.montserrat_medium,
            weight = FontWeight.Medium,
            style = FontStyle.Normal,
        )

    val montserratSemiBold =
        Font(
            resource = Res.font.montserrat_semi_bold,
            weight = FontWeight.SemiBold,
            style = FontStyle.Normal,
        )

    val montserratThin =
        Font(
            resource = Res.font.montserrat_thin,
            weight = FontWeight.Thin,
            style = FontStyle.Normal,
        )

    val montserratExtraBold =
        Font(
            resource = Res.font.montserrat_extrabold,
            weight = FontWeight.ExtraBold,
            style = FontStyle.Normal,
        )

    val montserratExtraLight =
        Font(
            resource = Res.font.montserrat_extralight,
            weight = FontWeight.ExtraLight,
            style = FontStyle.Normal,
        )

    val montserratBlack =
        Font(
            resource = Res.font.montserrat_black,
            weight = FontWeight.Black,
            style = FontStyle.Normal,
    )

    @Composable
    fun montserrat() = FontFamily(
        montserratThin,
        montserratExtraLight,
        montserratLight,
        montserratRegular,
        montserratMedium,
        montserratSemiBold,
        montserratBold,
        montserratExtraBold,
        montserratBlack,
    )

    return Typography(
        displayLarge = TextStyle(
            fontFamily = montserrat(),
            fontWeight = FontWeight.W400,
            fontSize = 50.sp,
//             lineHeight = 64.sp,
            // letterSpacing = (-0.25).sp,
        ),
        displayMedium = TextStyle(
            fontFamily = montserrat(),
            fontWeight = FontWeight.W400,
            fontSize = 40.sp,
            // lineHeight = 52.sp,
        ),
        displaySmall = TextStyle(
            fontFamily = montserrat(),
            fontWeight = FontWeight.W400,
            fontSize = 30.sp,
            // lineHeight = 44.sp,
        ),
        headlineLarge = TextStyle(
            fontFamily = montserrat(),
            fontWeight = FontWeight.W400,
            fontSize = 28.sp,
            // lineHeight = 40.sp,
        ),
        headlineMedium = TextStyle(
            fontFamily = montserrat(),
            fontWeight = FontWeight.W400,
            fontSize = 24.sp,
            // lineHeight = 36.sp,
        ),
        headlineSmall = TextStyle(
            fontFamily = montserrat(),
            fontWeight = FontWeight.W400,
            fontSize = 20.sp,
            // lineHeight = 32.sp,
        ),
        titleLarge = TextStyle(
            fontFamily = montserrat(),
            fontWeight = FontWeight.W700,
            fontSize = 18.sp,
            // lineHeight = 28.sp,
        ),
        titleMedium = TextStyle(
            fontFamily = montserrat(),
            fontWeight = FontWeight.W700,
            fontSize = 14.sp,
            // lineHeight = 24.sp,
            // letterSpacing = 0.1.sp,
        ),
        titleSmall = TextStyle(
            fontFamily = montserrat(),
            fontWeight = FontWeight.W500,
            fontSize = 12.sp,
            // lineHeight = 20.sp,
            // letterSpacing = 0.1.sp,
        ),
        bodyLarge = TextStyle(
            fontFamily = montserrat(),
            fontWeight = FontWeight.W400,
            fontSize = 14.sp,
            // lineHeight = 24.sp,
            // letterSpacing = 0.5.sp,
        ),
        bodyMedium = TextStyle(
            fontFamily = montserrat(),
            fontWeight = FontWeight.W400,
            fontSize = 12.sp,
            // lineHeight = 20.sp,
            // letterSpacing = 0.25.sp,
        ),
        bodySmall = TextStyle(
            fontFamily = montserrat(),
            fontWeight = FontWeight.W400,
            fontSize = 11.sp,
            // lineHeight = 16.sp,
            // letterSpacing = 0.4.sp,
        ),
        labelLarge = TextStyle(
            fontFamily = montserrat(),
            fontWeight = FontWeight.W400,
            fontSize = 13.sp,
            // lineHeight = 20.sp,
            // letterSpacing = 0.1.sp,
        ),
        labelMedium = TextStyle(
            fontFamily = montserrat(),
            fontWeight = FontWeight.W400,
            fontSize = 11.sp,
            // lineHeight = 16.sp,
            // letterSpacing = 0.5.sp,
        ),
        labelSmall = TextStyle(
            fontFamily = montserrat(),
            fontWeight = FontWeight.W500,
            fontSize = 9.sp,
            // lineHeight = 16.sp,
        ),
    )
}
