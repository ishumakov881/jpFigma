package com.walhalla.jpfigma.ui.model

enum class ServiceStatusType {
    ACTIVE, NOT_AVAILABLE, NOT_CONNECTED, NONE
}

data class ServiceInfo(
    val id: Int,
    val name: String,
    val statusText: String? = null,
    val statusType: ServiceStatusType = ServiceStatusType.NONE,
    val canOpen: Boolean = true,
    val isFree: Boolean = false
)
