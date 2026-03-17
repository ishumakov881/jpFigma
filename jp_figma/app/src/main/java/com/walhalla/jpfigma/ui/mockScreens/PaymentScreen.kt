package com.walhalla.jpfigma.ui.mockScreens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.walhalla.jpfigma.ui.components.PaymentScreenBody
import com.walhalla.jpfigma.ui.model.MockData

@Composable
fun PaymentScreen() {
    val data = MockData.PaymentMethodsScreen
    PaymentScreenBody(
        accountNumber = "12345678",
        paymentAmount = "200",
        email = "",
        paymentPoints = data.paymentPoints,
        onPayClick = {},
        onDetailsClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun PaymentScreenPreview() {
    PaymentScreen()
}
