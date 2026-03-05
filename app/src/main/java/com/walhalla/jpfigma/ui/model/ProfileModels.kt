package com.walhalla.jpfigma.ui.model

data class PhoneInfo(
    val number: String,
    val isPrimary: Boolean = false,
    val isActualized: Boolean = false
)

data class SubscriberProfile(
    val accountNumber: String,
    val fullName: String,
    val address: String,
    val phones: List<PhoneInfo>
)
