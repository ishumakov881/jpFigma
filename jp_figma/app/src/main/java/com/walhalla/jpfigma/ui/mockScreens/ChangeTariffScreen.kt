package com.walhalla.jpfigma.ui.mockScreens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.walhalla.jpfigma.ui.components.ChangeTariffScreenBody
import com.walhalla.jpfigma.ui.model.MockData

@Composable
fun ChangeTariffScreen() {
    val data = MockData.ChangeTariffScreen
    ChangeTariffScreenBody(
        tariffs = data.tariffs,
        importantInfo = data.importantInfo,
        localNetworkItems = data.localNetworkItems,
        localNetworkRules = data.localNetworkRules,
        additionalChanges = data.additionalChanges,
        extraServices = data.extraServices,
        onTariffOrderClick = {},
        onTariffDetailsClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun ChangeTariffScreenPreview() {
    ChangeTariffScreen()
}
