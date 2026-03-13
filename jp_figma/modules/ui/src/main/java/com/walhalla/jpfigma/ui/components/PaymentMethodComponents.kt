package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.background
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.SubcomposeAsyncImage
import com.walhalla.jpfigma.ui.model.MockData
import com.walhalla.jpfigma.ui.model.PaymentPoint
import com.walhalla.jpfigma.ui.model.ScheduleItem
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun PaymentScreenBody(
    modifier: Modifier = Modifier,
    title: String = MockData.PaymentMethodsScreen.title,
    description: String = MockData.PaymentMethodsScreen.description,
    onlinePaymentData: MockData.PaymentMethodsScreen = MockData.PaymentMethodsScreen,
    paymentPoints: List<PaymentPoint> = MockData.PaymentMethodsScreen.paymentPoints
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(FigmaBackgroundGray)
            .verticalScroll(scrollState)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = title,
            color = FigmaTitleColor,
            fontSize = 26.sp,
            lineHeight = 28.6.sp,
            fontWeight = FontWeight.Normal
        )

        Text(
            text = description,
            color = FigmaTextPrimary,
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
            .background(FigmaLightBlueBg)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Text(text = data.onlinePaymentTitle, fontSize = 20.sp, color = FigmaTitleColor)
        Text(text = data.onlinePaymentSubtitle, fontSize = 14.sp, color = FigmaTitleColor, lineHeight = 17.5.sp)

        Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
            PaymentInput(label = data.labelAccountNumber, value = "12345678", modifier = Modifier.weight(1.2f))
            PaymentInput(label = data.labelAmount, value = "200", suffix = "₽", modifier = Modifier.weight(0.8f))
        }

        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(text = data.labelEmail, fontSize = 16.sp, color = FigmaTextPrimary)
            PaymentInput(label = "E-mail", value = "")
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(FigmaCardWhite)
                .padding(horizontal = 30.dp, vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(text = "Сумма платежа", fontSize = 18.sp, color = FigmaTitleColor)
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                Text(text = "200", fontSize = 26.sp, fontWeight = FontWeight.Bold, color = FigmaTitleColor)
                Text(text = "₽", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = FigmaTitleColor)
            }
            Button(
                onClick = { },
                modifier = Modifier.fillMaxWidth().height(60.dp),
                colors = ButtonDefaults.buttonColors(containerColor = FigmaBrandBlue),
                shape = RoundedCornerShape(30.dp)
            ) {
                Text(text = data.btnPay, color = FigmaCardWhite, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
            Text(
                text = data.consentText,
                fontSize = 13.sp,
                color = FigmaTextLight,
                textAlign = TextAlign.Center,
                lineHeight = 15.6.sp
            )
        }
    }
}

@Composable
fun PaymentInput(label: String, value: String, suffix: String? = null, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(FigmaCardWhite)
            .padding(horizontal = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(text = label, color = FigmaInputLabel, fontSize = 14.sp)
        Text(text = value, color = FigmaTextPrimary, fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
        if (suffix != null) {
            Text(text = suffix, color = FigmaTextPrimary, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun SberPaymentCard(logoUrl: Int, titlePrefix: String, description: String, btnText: String, iconArrowUrl: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(FigmaCardWhite)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(text = titlePrefix, fontSize = 20.sp, color = FigmaTitleColor)
            AsyncImageWithPlaceholder(imageUrl = logoUrl, modifier = Modifier.width(149.dp).height(23.dp))
        }
        Row(horizontalArrangement = Arrangement.spacedBy(20.dp), verticalAlignment = Alignment.Top) {
            Text(text = description, modifier = Modifier.weight(1f), color = FigmaTextPrimary, fontSize = 14.sp, lineHeight = 18.2.sp)
            DetailsButton(btnText, iconArrowUrl)
        }
    }
}

@Composable
fun SimplePaymentCard(title: String, description: String, btnText: String, iconArrowUrl: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(FigmaCardWhite)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Text(text = title, fontSize = 20.sp, color = FigmaTitleColor)
        Row(horizontalArrangement = Arrangement.spacedBy(20.dp), verticalAlignment = Alignment.Top) {
            Text(text = description, modifier = Modifier.weight(1f), color = FigmaTextPrimary, fontSize = 14.sp, lineHeight = 18.2.sp)
            DetailsButton(btnText, iconArrowUrl)
        }
    }
}

@Composable
fun TerminalPaymentCard(title: String, description: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(FigmaCardWhite)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(text = title, fontSize = 20.sp, color = FigmaTitleColor)
        Text(text = description, color = FigmaTextPrimary, fontSize = 14.sp, lineHeight = 18.2.sp)
        MapHolder()
    }
}

@Composable
fun MapHolder() {
    Box(
        modifier = Modifier.fillMaxWidth().background(Color.Yellow).height(300.dp).clip(RoundedCornerShape(10.dp))
    )
}

@Composable
fun PaymentPointCard(point: PaymentPoint) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(FigmaCardWhite)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Text(text = point.title, fontSize = 20.sp, color = FigmaTitleColor)
        
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(text = "Адрес:", fontSize = 15.sp, fontWeight = FontWeight.Medium, color = FigmaTextPrimary)
            Text(text = point.address, fontSize = 14.sp, color = FigmaTextPrimary, lineHeight = 18.2.sp)
        }

        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(text = "График работы:", fontSize = 15.sp, fontWeight = FontWeight.Medium, color = FigmaTextPrimary)
            point.schedule.forEach { schedule ->
                ScheduleItemRow(
                    days = schedule.days,
                    time = schedule.time,
                    breakTime = schedule.breakTime,
                    isHoliday = schedule.isHoliday
                )
            }
        }

        MapHolder()

    }
}

@Composable
fun ScheduleItemRow(
    days: List<String>,
    time: String,
    breakTime: String? = null,
    isHoliday: Boolean = false
) {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
            days.forEach { day ->
                Box(
                    modifier = Modifier
                        .size(width = 36.dp, height = 20.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(if (isHoliday) FigmaBrandOrange else FigmaStatusGrayBg),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = day,
                        color = if (isHoliday) Color.White else FigmaBrandBlue,
                        fontSize = 13.sp
                    )
                }
            }
        }
        if (!isHoliday) {
            HorizontalDivider(color = FigmaBrandBlue, thickness = 2.dp, modifier = Modifier.width(226.dp))
            Column {
                Text(
                    text = time,
                    color = FigmaBrandBlue,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                if (breakTime != null) {
                    Text(text = breakTime, color = FigmaTextPrimary, fontSize = 14.sp)
                }
            }
        } else {
            Text(text = "выходной", color = FigmaBrandOrange, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun DetailsButton(text: String, iconUrl: Int) {
    Row(
        modifier = Modifier
            .height(40.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(FigmaSecondaryBtnBg)
            .padding(horizontal = 20.dp)
            .clickable { },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(text = text, color = FigmaBrandBlue, fontSize = 15.sp)
        AsyncImageWithPlaceholder(imageUrl = iconUrl, modifier = Modifier.size(18.dp))
    }
}
