package com.walhalla.jpfigma.ui.mockScreens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.walhalla.jpfigma.ui.components.HyperScreenBody
import com.walhalla.jpfigma.ui.model.MockData

@Composable
fun HyperScreen() {
    val data = MockData.HyperScreen
    HyperScreenBody(
        serviceInfo = data.serviceInfo,
        maxTariffParams = data.maxTariffParams,
        aboutItems = data.aboutItems,
        onChangeSpeedClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun HyperScreenPreview() {
    HyperScreen()
}
