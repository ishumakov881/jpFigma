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
import com.walhalla.jpfigma.ui.model.MockData
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
    iconCalendar: String,
    iconWallet: String
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
fun DateInput(date: String, iconUrl: String, modifier: Modifier = Modifier) {
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

@Composable
fun PaymentMethodsScreenBody(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    onlinePaymentData: MockData.PaymentMethodsScreen, // Passing data object for brevity in this complex screen
    paymentPoints: List<com.walhalla.jpfigma.ui.model.PaymentPoint>
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .verticalScroll(scrollState)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = title,
            color = TitleColor,
            fontSize = 22.sp,
            fontWeight = FontWeight.Normal
        )

        Text(
            text = description,
            color = Text2,
            fontSize = 16.sp,
            lineHeight = 20.8.sp
        )

        OnlinePaymentCard(onlinePaymentData)

        SberPaymentCard(
            logoUrl = onlinePaymentData.sberLogo,
            titlePrefix = onlinePaymentData.sberTitle,
            description = onlinePaymentData.sberDescription,
            btnText = onlinePaymentData.btnDetails,
            iconArrowUrl = onlinePaymentData.iconArrowRight
        )

        SimplePaymentCard(
            title = onlinePaymentData.postTitle,
            description = onlinePaymentData.postDescription,
            btnText = onlinePaymentData.btnDetails,
            iconArrowUrl = onlinePaymentData.iconArrowRight
        )

        TerminalPaymentCard(
            title = onlinePaymentData.terminalTitle,
            description = onlinePaymentData.terminalDescription,
            imageUrl = onlinePaymentData.terminalImage
        )

        paymentPoints.forEach { point ->
            PaymentPointCard(point)
        }
    }
}

@Composable
fun OnlinePaymentCard(data: MockData.PaymentMethodsScreen) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFFD5E6F5))
            .padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Text(text = data.onlinePaymentTitle, fontSize = 20.sp, color = TitleColor)
        Text(text = data.onlinePaymentSubtitle, fontSize = 14.sp, color = TitleColor, lineHeight = 17.5.sp)

        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            PaymentInput(label = data.labelAccountNumber, value = "12345678")
            PaymentInput(label = data.labelAmount, value = "200", suffix = "₽")
        }

        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(text = data.labelEmail, fontSize = 16.sp, color = Text2)
            PaymentInput(label = "E-mail", value = "")
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(White)
                .padding(horizontal = 30.dp, vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(text = "Сумма платежа", fontSize = 18.sp, color = TitleColor)
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                Text(text = "200", fontSize = 26.sp, fontWeight = FontWeight.Bold, color = TitleColor)
                Text(text = "₽", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = TitleColor)
            }
            Button(
                onClick = { },
                modifier = Modifier.fillMaxWidth().height(40.dp),
                colors = ButtonDefaults.buttonColors(containerColor = BrandColor1),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(text = data.btnPay, color = White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
            Text(
                text = data.consentText,
                fontSize = 13.sp,
                color = SecondaryText,
                textAlign = TextAlign.Center,
                lineHeight = 15.6.sp
            )
        }
    }
}

@Composable
fun PaymentInput(label: String, value: String, suffix: String? = null) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(White)
            .padding(horizontal = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(text = label, color = Color(0xFF60778E), fontSize = 14.sp)
        Text(text = value, color = Text2, fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
        if (suffix != null) {
            Text(text = suffix, color = Text2, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun SberPaymentCard(logoUrl: String, titlePrefix: String, description: String, btnText: String, iconArrowUrl: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(White)
            .padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(text = titlePrefix, fontSize = 20.sp, color = TitleColor)
            AsyncImageWithPlaceholder(imageUrl = logoUrl, modifier = Modifier.width(149.dp).height(23.dp))
        }
        Text(text = description, color = Text2, fontSize = 14.sp, lineHeight = 18.2.sp)
        DetailsButton(btnText, iconArrowUrl)
    }
}

@Composable
fun SimplePaymentCard(title: String, description: String, btnText: String, iconArrowUrl: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(White)
            .padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Text(text = title, fontSize = 20.sp, color = TitleColor)
        Text(text = description, color = Text2, fontSize = 14.sp, lineHeight = 18.2.sp)
        DetailsButton(btnText, iconArrowUrl)
    }
}

@Composable
fun TerminalPaymentCard(title: String, description: String, imageUrl: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(White)
            .padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Text(text = title, fontSize = 20.sp, color = TitleColor)
        Text(text = description, color = Text2, fontSize = 14.sp, lineHeight = 18.2.sp)
        AsyncImageWithPlaceholder(
            imageUrl = imageUrl,
            modifier = Modifier.fillMaxWidth().height(300.dp).clip(RoundedCornerShape(10.dp))
        )
    }
}

@Composable
fun PaymentPointCard(point: com.walhalla.jpfigma.ui.model.PaymentPoint) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(White)
            .padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(text = point.title, fontSize = 20.sp, color = TitleColor)
        
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(text = "Адрес:", fontSize = 15.sp, fontWeight = FontWeight.Medium, color = Text2)
            Text(text = point.address, fontSize = 14.sp, color = Text2, lineHeight = 18.2.sp)
        }

        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(text = "График работы:", fontSize = 15.sp, fontWeight = FontWeight.Medium, color = Text2)
            point.schedule.forEach { schedule ->
                ScheduleRow(schedule)
            }
        }

        if (point.imageUrl != null) {
            AsyncImageWithPlaceholder(
                imageUrl = point.imageUrl,
                modifier = Modifier.fillMaxWidth().height(300.dp).clip(RoundedCornerShape(10.dp))
            )
        }
    }
}

@Composable
fun ScheduleRow(schedule: com.walhalla.jpfigma.ui.model.ScheduleItem) {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
            listOf("ПН", "ВТ", "СР", "ЧТ", "ПТ", "СБ", "ВС").forEach { day ->
                val isSelected = day in schedule.days
                val bgColor = if (isSelected) {
                    if (schedule.isHoliday) BrandColor2 else Color(0xFFF1F1F1)
                } else Color.Transparent
                val textColor = if (isSelected) {
                    if (schedule.isHoliday) White else BrandColor1
                } else Color.Transparent

                if (bgColor != Color.Transparent) {
                    Box(
                        modifier = Modifier
                            .size(width = 36.dp, height = 20.dp)
                            .clip(RoundedCornerShape(5.dp))
                            .background(bgColor),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = day, color = textColor, fontSize = 13.sp)
                    }
                }
            }
        }
        if (!schedule.isHoliday) {
            HorizontalDivider(color = BrandColor1, thickness = 2.dp, modifier = Modifier.fillMaxWidth())
            Column {
                Text(
                    text = "с ${schedule.time.split(" - ")[0]} до ${schedule.time.split(" - ")[1]}",
                    color = BrandColor1,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                if (schedule.breakTime != null) {
                    Text(text = schedule.breakTime, color = Text2, fontSize = 14.sp)
                }
            }
        } else {
            Text(text = "выходной", color = BrandColor2, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun DetailsButton(text: String, iconUrl: String) {
    Row(
        modifier = Modifier
            .height(40.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(SecondaryBtn)
            .padding(horizontal = 20.dp)
            .clickable { },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(text = text, color = BrandColor1, fontSize = 15.sp)
        AsyncImageWithPlaceholder(imageUrl = iconUrl, modifier = Modifier.size(18.dp))
    }
}
