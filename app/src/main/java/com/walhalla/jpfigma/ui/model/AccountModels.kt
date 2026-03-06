package com.walhalla.jpfigma.ui.model

data class AccountInfo(
    val status: String,
    val balance: String,
    val balanceUntil: String,
    val tariffName: String,
    val accountNumber: String,
    val fullName: String,
    val address: String,
    val phone: String,
    val internetStatus: String,
    val macAddress: String,
    val tvStatus: String
)

data class ServiceDetail(
    val name: String,
    val price: String,
    val oldPrice: String? = null,
    val hasOffer: Boolean = false,
    val isMainService: Boolean = false
)
data class UserServicePackage(
    val packageName: String,
    val services: List<ServiceDetail>,
    val totalPrice: String,
    val oldTotalPrice: String? = null
)