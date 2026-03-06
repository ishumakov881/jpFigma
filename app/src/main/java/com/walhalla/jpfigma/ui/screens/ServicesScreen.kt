package com.walhalla.jpfigma.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.walhalla.jpfigma.ui.components.ServiceItemData
import com.walhalla.jpfigma.ui.components.ServicesScreenBody
import com.walhalla.jpfigma.ui.model.MockData
import com.walhalla.jpfigma.ui.theme.JpFigmaTheme

@Composable
fun ServicesScreen() {
    val title = MockData.ServicesScreen.title
    val paid = MockData.ServicesScreen.paid.map {
        ServiceItemData(it.id, it.name, it.statusText, it.statusType, it.canOpen, it.isFree)
    }
    val free = MockData.ServicesScreen.free.map {
        ServiceItemData(it.id, it.name, it.statusText, it.statusType, it.canOpen, it.isFree)
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
