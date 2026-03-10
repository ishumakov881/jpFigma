package com.walhalla.jpfigma.ui.model

data class HyperServiceInfo(
    val currentSpeed: Int,
    val targetSpeed: Int,
    val currentPrice: Int,
    val targetPrice: Int,
    val speedUnit: String = "Мбит/с",
    val currencyUnit: String = "₽/30 дней",
    val stepValue: Int = 50,
    val stepPrice: String = "+18 руб/мес",
    val userTariff: String = "Безлим 100+"
)

data class HyperParameter(
    val label: String,
    val value: String
)
