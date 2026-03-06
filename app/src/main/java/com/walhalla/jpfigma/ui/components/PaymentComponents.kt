package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun PaymentsScreenBody(
    modifier: Modifier = Modifier,
    title: String,
    incomes: List<TransactionData>,
    expenses: List<TransactionData>
) {
    val backgroundColor = Color(0xFFF4F7FB)
    val cardPadding = 20.dp

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor),
        contentPadding = PaddingValues(cardPadding),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                text = title,
                color = TitleColor,
                fontSize = 22.sp,
                modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp)
            )
        }

        // Incomes
        item {
            AccountCard(
                title = "Приходы на счёт",
                gradient = Brush.linearGradient(listOf(Color(0xFFCCE6FF), Color(0xFF95C5F3))),
                horizontalPadding = 20.dp
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    incomes.forEachIndexed { index, transaction ->
                        PaymentTransactionItem(
                            date = transaction.date,
                            description = transaction.description,
                            amount = transaction.amount,
                            isIncome = transaction.isIncome,
                            balanceAfter = transaction.balanceAfter
                        )
                        if (index < incomes.size - 1) {
                            HorizontalDivider(color = LineColor)
                        }
                    }
                }
            }
        }

        // Expenses
        item {
            AccountCard(
                title = "Списания со счёта",
                gradient = Brush.linearGradient(listOf(Color(0xFFFFE4CC), Color(0xFFF3BD95))),
                horizontalPadding = 20.dp
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    expenses.forEachIndexed { index, transaction ->
                        PaymentTransactionItem(
                            date = transaction.date,
                            description = transaction.description,
                            amount = transaction.amount,
                            isIncome = transaction.isIncome,
                            balanceAfter = transaction.balanceAfter
                        )
                        if (index < expenses.size - 1) {
                            HorizontalDivider(color = LineColor)
                        }
                    }
                }
            }
        }
    }
}

data class TransactionData(
    val date: String,
    val description: String,
    val amount: String,
    val isIncome: Boolean,
    val balanceAfter: String? = null
)
