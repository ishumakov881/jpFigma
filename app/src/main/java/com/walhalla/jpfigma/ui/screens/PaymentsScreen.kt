package com.walhalla.jpfigma.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.walhalla.jpfigma.ui.components.PaymentsScreenBody
import com.walhalla.jpfigma.ui.components.TransactionData
import com.walhalla.jpfigma.ui.model.MockData
import com.walhalla.jpfigma.ui.theme.JpFigmaTheme

@Composable
fun PaymentsScreen() {
    val title = MockData.PaymentsScreen.title
    val transactions = MockData.PaymentsScreen.transactions
    val incomes = transactions.filter { it.isIncome }.map {
        TransactionData(it.date, it.description, it.amount, it.isIncome, it.balanceAfter)
    }
    val expenses = transactions.filter { !it.isIncome }.map {
        TransactionData(it.date, it.description, it.amount, it.isIncome, it.balanceAfter)
    }

    PaymentsScreenBody(
        title = title,
        incomes = incomes,
        expenses = expenses
    )
}

@Preview(showBackground = true)
@Composable
fun PaymentsScreenPreview() {
    JpFigmaTheme {
        PaymentsScreen()
    }
}
