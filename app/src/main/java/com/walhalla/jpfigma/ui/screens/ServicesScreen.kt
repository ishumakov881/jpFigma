package com.walhalla.jpfigma.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.walhalla.jpfigma.ui.components.ServiceItemData
import com.walhalla.jpfigma.ui.components.ServicesScreenBody
import com.walhalla.jpfigma.ui.model.MockData
import com.walhalla.jpfigma.ui.model.ServiceStatusType
import com.walhalla.jpfigma.ui.theme.JpFigmaTheme

@Composable
fun ServicesScreen() {
    val title = MockData.ServicesScreen.title
    val paid = MockData.ServicesScreen.paid.map {
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
    val free = MockData.ServicesScreen.free.map {
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
        title = title,
        paidServices = paid,
        freeServices = free,
        onInfoClick = {},
        onActionClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun ServicesScreenPreview() {
    JpFigmaTheme {
        ServicesScreen()
    }
}
