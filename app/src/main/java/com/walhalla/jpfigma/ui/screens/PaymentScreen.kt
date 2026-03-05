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

@Composable
fun PaymentScreen(
    modifier: Modifier = Modifier,
    onPayClick: () -> Unit = {}
) {
    val paymentMethods = MockData.getPaymentMethods()
    val paymentPoints = MockData.getPaymentPoints()

    var accountNumber by remember { mutableStateOf("12345678") }
    var amount by remember { mutableStateOf("200") }
    var email by remember { mutableStateOf("") }

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
                onAccountChange = { accountNumber = it },
                amount = amount,
                onAmountChange = { amount = it },
                email = email,
                onEmailChange = { email = it },
                onPayClick = onPayClick
            )
        }

        items(paymentMethods) { method ->
            PaymentMethodCard(method = method)
        }

        items(paymentPoints) { point ->
            PaymentPointCard(point = point)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PaymentScreenPreview() {
    JpFigmaTheme {
        PaymentScreen(
        )
    }
}
