package com.walhalla.jpfigma.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

/**
 * Цвета и градиенты из Figma.
 * Имена соответствуют макетам.
 */

// Текст
val FigmaTitleColor = Color(0xFF060606)
val FigmaTextPrimary = Color(0xFF313E49)
val FigmaTextSecondary = Color(0xFF60778E)
val FigmaTextHint = Color(0xFF8A9CAF)
val FigmaTextLight = Color(0xFF687F8F)
val FigmaDarkTitle = Color(0xFF041E37)

// Брендовые цвета
val FigmaBrandBlue = Color(0xFF1880D0)
val FigmaBrandOrange = Color(0xFFF04E23)
val FigmaBrandGreen = Color(0xFF0FB752)
val FigmaSuccessGreen = Color(0xFF2EA201)
val FigmaErrorRed = Color(0xFFDB2525)

// Поверхности
val FigmaBackgroundGray = Color(0xFFF5F5F5)
val FigmaCardWhite = Color(0xFFFFFFFF)
val FigmaLineColor = Color(0xFFB2D4EE)
val FigmaLightBlueBg = Color(0xFFD5E6F5)
val FigmaSecondaryBtnBg = Color(0xFFE4F2FF)
val FigmaStatusGrayBg = Color(0xFFF1F1F1)
val FigmaFilterSelectedBg = Color(0xFFFFFFFF)
val FigmaFilterUnselectedBg = Color(0xFFE8EFF6)

// Тени
val FigmaShadowColor = Color(0x40000000)

// Градиенты
val FigmaBlueGradient = Brush.linearGradient(
    colors = listOf(Color(0xFFCCE6FF), Color(0xFF95C5F3))
)

val FigmaOrangeGradient = Brush.linearGradient(
    colors = listOf(Color(0xFFFFE4CC), Color(0xFFF3BD95))
)

val FigmaPurpleGradient = Brush.linearGradient(
    colors = listOf(Color(0xFFCCD1FF), Color(0xFF95AAF3))
)

// Чаты
val FigmaChatBubbleOperator = Color(0xFFE8F3FB)
val FigmaChatBubbleUser = Color(0xFFFBF0E8)
