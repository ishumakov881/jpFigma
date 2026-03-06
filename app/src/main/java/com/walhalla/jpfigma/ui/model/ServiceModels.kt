package com.walhalla.jpfigma.ui.model

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

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




