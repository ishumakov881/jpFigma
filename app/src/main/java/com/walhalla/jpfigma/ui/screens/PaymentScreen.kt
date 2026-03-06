package com.walhalla.jpfigma.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.components.*
import com.walhalla.jpfigma.ui.model.*
import com.walhalla.jpfigma.ui.theme.*

/**
 * Payment Screen.
 * Uses [MockData] for demonstration.
 */
@Composable
fun PaymentScreen() {
    val methods = MockData.getPaymentMethods()
    val points = MockData.getPaymentPoints()

    var accountNumber by remember { mutableStateOf("12345678") }
    var amount by remember { mutableStateOf("200") }
    var email by remember { mutableStateOf("") }

    PaymentScreenContent(
        accountNumber = accountNumber,
        onAccountChange = { accountNumber = it },
        amount = amount,
        onAmountChange = { amount = it },
        email = email,
        onEmailChange = { email = it },
        paymentMethods = methods,
        paymentPoints = points
    )
}

@Composable
fun PaymentScreenContent(
    accountNumber: String,
    onAccountChange: (String) -> Unit,
    amount: String,
    onAmountChange: (String) -> Unit,
    email: String,
    onEmailChange: (String) -> Unit,
    paymentMethods: List<PaymentMethod>,
    paymentPoints: List<PaymentPoint>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF4F7FB)),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            Text(
                text = "Способы оплаты",
                color = TitleColor,
                fontSize = 26.sp,
                modifier = Modifier.padding(bottom = 5.dp)
            )
            Text(
                text = "Оплатить услуги компании Луганские Домашние Сети можно следующими способами:",
                color = Text2,
                fontSize = 16.sp,
                lineHeight = 20.sp
            )
        }

        item {
            OnlinePaymentCard(
                accountNumber = accountNumber,
                onAccountChange = onAccountChange,
                amount = amount,
                onAmountChange = onAmountChange,
                email = email,
                onEmailChange = onEmailChange,
                onPayClick = { }
            )
        }

        items(paymentMethods) { method ->
            PaymentMethodCard(
                title = method.title,
                description = method.description,
                hasDetailButton = method.hasDetailButton
            )
        }

        items(paymentPoints) { point ->
            PaymentPointCard(
                title = point.title,
                address = point.address,
                imageUrl = point.imageUrl
            ) {
                point.schedule.forEach { schedule ->
                    ScheduleItemRow(
                        days = schedule.days,
                        time = schedule.time,
                        breakTime = schedule.breakTime,
                        isHoliday = schedule.isHoliday
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PaymentScreenPreview() {
    JpFigmaTheme {
        PaymentScreen()
    }
}
