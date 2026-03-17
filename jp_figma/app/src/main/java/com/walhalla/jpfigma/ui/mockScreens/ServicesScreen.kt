package com.walhalla.jpfigma.ui.mockScreens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.walhalla.jpfigma.ui.components.ServiceItemData
import com.walhalla.jpfigma.ui.components.ServicesScreenBody
import com.walhalla.jpfigma.ui.model.MockData
import com.walhalla.jpfigma.ui.model.ServiceStatusType

@Composable
fun ServicesScreen() {
    val data = MockData.ServicesScreen
    val paid = data.paid.map {
        ServiceItemData(
            id = it.id,
            name = it.name,
            statusText = it.statusText,
            isActive = it.statusType == ServiceStatusType.ACTIVE,
            isNotAvailable = it.statusType == ServiceStatusType.NOT_AVAILABLE,
            isNotConnected = it.statusType == ServiceStatusType.NOT_CONNECTED,
            canOpen = it.canOpen,
            isFree = it.isFree
        )
    }
    val free = data.free.map {
        ServiceItemData(
            id = it.id,
            name = it.name,
            statusText = it.statusText,
            isActive = it.statusType == ServiceStatusType.ACTIVE,
            isNotAvailable = it.statusType == ServiceStatusType.NOT_AVAILABLE,
            isNotConnected = it.statusType == ServiceStatusType.NOT_CONNECTED,
            canOpen = it.canOpen,
            isFree = it.isFree
        )
    }

    ServicesScreenBody(
        title = data.title,
        paidServices = paid,
        freeServices = free
    )
}

@Preview(showBackground = true)
@Composable
fun ServicesScreenPreview() {
    ServicesScreen()
}
