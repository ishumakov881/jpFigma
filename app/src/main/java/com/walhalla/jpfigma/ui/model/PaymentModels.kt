package com.walhalla.jpfigma.ui.model

data class PaymentMethod(
    val id: Int,
    val title: String,
    val description: String,
    val imageUrl: String? = null,
    val hasDetailButton: Boolean = true
)

data class ScheduleItem(
    val days: List<String>,
    val time: String,
    val breakTime: String? = null,
    val isHoliday: Boolean = false
)

data class PaymentPoint(
    val id: Int,
    val title: String,
    val address: String,
    val schedule: List<ScheduleItem>,
    val imageUrl: String? = null
)

data class PaymentTransaction(
    val id: Int,
    val date: String,
    val description: String,
    val amount: String,
    val isPositive: Boolean,
    val balanceAfter: String? = null,
    val hasReceipt: Boolean = false
)
