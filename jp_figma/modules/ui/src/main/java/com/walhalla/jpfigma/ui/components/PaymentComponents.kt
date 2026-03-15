package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.model.PaymentTransaction
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun PaymentsScreenBody(
    modifier: Modifier = Modifier,
    title: String,
    dateFrom: String,
    dateTo: String,
    btnShow: String,
    btnHistory: String,
    headerDate: String,
    headerDescription: String,
    transactions: List<PaymentTransaction>,
    balanceLabel: String,
    balanceValue: String,
    balanceUntil: String,
    btnTopUp: String,
    iconCalendar: Int,
    iconWallet: Int
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .verticalScroll(scrollState)
            .padding(vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // Title
        Text(
            text = title,
            color = TitleColor,
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
                DateInput(date = dateFrom, iconUrl = iconCalendar, modifier = Modifier.weight(1f))
                Text(text = "-", color = Text2, fontSize = 16.sp)
                DateInput(date = dateTo, iconUrl = iconCalendar, modifier = Modifier.weight(1f))
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                OutlinedButton(
                    onClick = { },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(20.dp),
                    border = BorderStroke(1.dp, BrandColor1),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = BrandColor1)
                ) {
                    Text(text = btnShow, fontSize = 15.sp)
                }
                OutlinedButton(
                    onClick = { },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(20.dp),
                    border = BorderStroke(1.dp, BrandColor1),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = BrandColor1)
                ) {
                    Text(text = btnHistory, fontSize = 15.sp)
                }
            }
        }

        // Transactions Table
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(White)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Table Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = headerDate,
                    modifier = Modifier.width(100.dp),
                    color = TitleColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = headerDescription,
                    modifier = Modifier.weight(1f),
                    color = TitleColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            // Transaction Items
            transactions.forEach { transaction ->
                HorizontalDivider(color = LineColor, thickness = 1.dp)
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
                            text = balanceLabel,
                            color = Text2,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = balanceValue,
                            color = Green,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "₽",
                            color = Green,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                    }
                    Text(
                        text = balanceUntil,
                        color = SecondaryText,
                        fontSize = 13.sp,
                        lineHeight = 16.9.sp
                    )
                }

                Button(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = BrandColor1),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        AsyncImageWithPlaceholder(
                            imageUrl = iconWallet,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = btnTopUp,
                            color = White,
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
fun DateInput(date: String, iconUrl: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .height(40.dp)
            .border(1.dp, Color(0xFF60778E), RoundedCornerShape(5.dp))
            .background(White)
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = date, color = Text2, fontSize = 15.sp)
        AsyncImageWithPlaceholder(imageUrl = iconUrl, modifier = Modifier.size(24.dp))
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
            color = Color(0xFF60778E),
            fontSize = 14.sp
        )
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(5.dp)) {
            Text(
                text = "${transaction.amount} ₽",
                color = if (transaction.isPositive) Green else Text2,
                fontSize = 14.sp,
                fontWeight = if (transaction.isPositive) FontWeight.Bold else FontWeight.SemiBold
            )
            Column {
                Text(
                    text = transaction.description,
                    color = Text2,
                    fontSize = 14.sp
                )
                if (transaction.hasReceipt == true) {
                    Text(
                        text = "Скачать чек",
                        color = BrandColor1,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 5.dp)
                    )
                }
            }
        }
    }
}
