package com.walhalla.jpfigma.ui.mockScreens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.walhalla.jpfigma.ui.components.OffersScreenBody
import com.walhalla.jpfigma.ui.model.MockData

@Composable
fun OffersScreen() {
    val data = MockData.OffersScreen
    OffersScreenBody(
        offers = data.offers,
        onOfferClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun OffersScreenPreview() {
    OffersScreen()
}
