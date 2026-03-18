package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.R
import com.walhalla.jpfigma.ui.model.*
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun PaymentsScreenBody(
    dateFrom: String,
    dateTo: String,
    transactions: List<PaymentTransaction>,
    balanceValue: String,
    balanceUntil: String,
    modifier: Modifier = Modifier,
    onShowClick: () -> Unit = {},
    onHistoryClick: () -> Unit = {},
    onTopUpClick: () -> Unit = {}
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(FigmaBackgroundGray)
            .verticalScroll(scrollState)
            .padding(vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // Title
        Text(
            text = "Платежи",
            color = FigmaTitleColor,
            fontSize = 22.sp,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        // Date Selectors and Buttons
        Column(
            modifier = Modifier.padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                DateInputItem(date = dateFrom, modifier = Modifier.weight(1f))
                Text(text = "-", color = FigmaTextPrimary, fontSize = 16.sp)
                DateInputItem(date = dateTo, modifier = Modifier.weight(1f))
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                OutlinedButton(
                    onClick = onShowClick,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(20.dp),
                    border = BorderStroke(1.dp, FigmaBrandBlue),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = FigmaBrandBlue)
                ) {
                    Text(text = "Показать", fontSize = 15.sp)
                }
                OutlinedButton(
                    onClick = onHistoryClick,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(20.dp),
                    border = BorderStroke(1.dp, FigmaBrandBlue),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = FigmaBrandBlue)
                ) {
                    Text(text = "История баланса", fontSize = 15.sp)
                }
            }
        }

        // Transactions Table
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(FigmaCardWhite)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Table Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "Дата",
                    modifier = Modifier.width(100.dp),
                    color = FigmaTitleColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Сумма и вид платежа",
                    modifier = Modifier.weight(1f),
                    color = FigmaTitleColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            // Transaction Items
            transactions.forEach { transaction ->
                HorizontalDivider(color = FigmaLineColor, thickness = 1.dp)
                TransactionItemRow(transaction)
            }

            // Balance Summary
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Column {
                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Text(
                            text = "Ваш баланс:",
                            color = FigmaTextPrimary,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = balanceValue,
                            color = FigmaSuccessGreen,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "₽",
                            color = FigmaSuccessGreen,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                    }
                    Text(
                        text = balanceUntil,
                        color = FigmaTextLight,
                        fontSize = 13.sp,
                        lineHeight = 16.9.sp
                    )
                }

                Button(
                    onClick = onTopUpClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = FigmaBrandBlue),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        FigmaImage(
                            model = R.drawable.ic_wallet,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "Пополнить счёт",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun DateInputItem(date: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .height(40.dp)
            .border(1.dp, FigmaInputBorder, RoundedCornerShape(5.dp))
            .background(Color.White)
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = date, color = FigmaTextPrimary, fontSize = 15.sp)
        FigmaImage(model = R.drawable.ic_calendar, modifier = Modifier.size(24.dp))
    }
}

@Composable
fun TransactionItemRow(transaction: PaymentTransaction) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = transaction.date,
            modifier = Modifier.width(100.dp),
            color = FigmaInputLabel,
            fontSize = 14.sp
        )
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(5.dp)) {
            Text(
                text = "${transaction.amount} ₽",
                color = if (transaction.isPositive) FigmaSuccessGreen else FigmaTextPrimary,
                fontSize = 14.sp,
                fontWeight = if (transaction.isPositive) FontWeight.Bold else FontWeight.SemiBold
            )
            Column {
                Text(
                    text = transaction.description,
                    color = FigmaTextPrimary,
                    fontSize = 14.sp
                )
                if (transaction.hasReceipt == true) {
                    Text(
                        text = "Скачать чек",
                        color = FigmaBrandBlue,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 5.dp)
                    )
                }
            }
        }
    }
}
