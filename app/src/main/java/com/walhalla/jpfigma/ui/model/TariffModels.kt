package com.walhalla.jpfigma.ui.model

data class TariffInfo(
    val id: Int,
    val name: String,
    val internetSpeed: String,
    val internetSpeedLabel: String,
    val tvChannels: String,
    val tvChannelsLabel: String,
    val isHyperAvailable: Boolean,
    val price: String,
    val pricePeriod: String,
    val isCurrent: Boolean = false,
    val speedIconType: String = "internet--9"
)

data class NetworkInfoItem(
    val title: String,
    val description: String,
    val priceLabel: String,
    val isFree: Boolean = true
)
