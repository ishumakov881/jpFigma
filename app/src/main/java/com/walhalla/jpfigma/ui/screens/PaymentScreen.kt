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
    accountNumber: String,
    onAccountChange: (String) -> Unit,
    amount: String,
    onAmountChange: (String) -> Unit,
    email: String,
    onEmailChange: (String) -> Unit,
    onPayClick: () -> Unit,
    paymentMethods: List<PaymentMethod>,
    paymentPoints: List<PaymentPoint>
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
            accountNumber = "12345678",
            onAccountChange = {},
            amount = "200",
            onAmountChange = {},
            email = "",
            onEmailChange = {},
            onPayClick = {},
            paymentMethods = listOf(
                PaymentMethod(1, "Оплата через СБЕРБАНК", "Оплата доступна через \"СберБанк\" с комиссией 1%"),
                PaymentMethod(2, "Оплата услуг ЛДС в отделениях почты ЛНР", "Вы можете пополнить счет в отделениях почты ЛНР.")
            ),
            paymentPoints = listOf(
                PaymentPoint(
                    1, 
                    "Пункт приёма платежей", 
                    "кв. Жукова 4 Б/1, главный офис ЛДС", 
                    listOf(
                        ScheduleItem(listOf("ПН", "ВТ", "СР", "ЧТ", "ПТ", "СБ"), "с 9:00 до 18:00", "перерыв с 13:00 до 13:45"),
                        ScheduleItem(listOf("ВС"), "выходной", isHoliday = true)
                    ),
                    imageUrl = "https://www.figma.com/api/mcp/asset/e76c7f92-d81b-48d1-81e5-2638909afa9c"
                )
            )
        )
    }
}
