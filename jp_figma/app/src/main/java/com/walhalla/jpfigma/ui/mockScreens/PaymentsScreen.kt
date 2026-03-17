package com.walhalla.jpfigma.ui.mockScreens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.walhalla.jpfigma.ui.components.PaymentsScreenBody
import com.walhalla.jpfigma.ui.model.MockData

@Composable
fun PaymentsScreen() {
    val data = MockData.PaymentsScreen

    PaymentsScreenBody(
        dateFrom = data.dateFrom,
        dateTo = data.dateTo,
        transactions = data.transactions,
        balanceValue = data.balanceValue,
        balanceUntil = data.balanceUntil,
        onShowClick = {},
        onHistoryClick = {},
        onTopUpClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun PaymentsScreenPreview() {
    PaymentsScreen()
}
