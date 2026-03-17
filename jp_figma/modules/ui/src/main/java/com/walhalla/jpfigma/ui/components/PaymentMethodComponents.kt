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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.R
import com.walhalla.jpfigma.ui.model.PaymentPoint
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun PaymentScreenBody(
    accountNumber: String,
    paymentAmount: String,
    email: String,
    paymentPoints: List<PaymentPoint>,
    modifier: Modifier = Modifier,
    onPayClick: () -> Unit = {},
    onDetailsClick: (String) -> Unit = {}
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
            text = "Способы оплаты",
            color = FigmaTitleColor,
            fontSize = 26.sp,
            lineHeight = 28.6.sp,
            fontWeight = FontWeight.Normal
        )

        Text(
            text = "Оплатить услуги компании Луганские Домашние Сети можно следующими способами:",
            color = FigmaTextPrimary,
            fontSize = 16.sp,
            lineHeight = 20.8.sp
        )

        OnlinePaymentCard(
            accountNumber = accountNumber,
            amount = paymentAmount,
            email = email,
            onPayClick = onPayClick
        )

        SberPaymentCard(
            onDetailsClick = { onDetailsClick("sber") }
        )

        SimplePaymentCard(
            title = "Оплата услуг ЛДС в отделениях почты ЛНР",
            description = "Вы можете пополнить счет в отделениях почты ЛНР.",
            onDetailsClick = { onDetailsClick("post") }
        )

        TerminalPaymentCard()

        paymentPoints.forEach { point ->
            PaymentPointCard(point)
        }
    }
}

@Composable
fun OnlinePaymentCard(
    accountNumber: String,
    amount: String,
    email: String,
    onPayClick: () -> Unit
) {
    FigmaCard(backgroundColor = FigmaLightBlueBg) {
        Text(text = "Оплата онлайн", fontSize = 20.sp, color = FigmaTitleColor)
        Text(
            text = "Введите номер Вашего лицевого счета и сумму платежа",
            fontSize = 14.sp, color = FigmaTitleColor, lineHeight = 17.5.sp
        )

        Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
            PaymentInput(label = "Лицевой счёт", value = accountNumber, modifier = Modifier.weight(1.2f))
            PaymentInput(label = "Сумма", value = amount, suffix = "₽", modifier = Modifier.weight(0.8f))
        }

        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(text = "E-mail (необязательно)", fontSize = 16.sp, color = FigmaTextPrimary)
            PaymentInput(label = "E-mail", value = email)
        }

        FigmaCard(padding = 30.dp) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(text = "Сумма платежа", fontSize = 18.sp, color = FigmaTitleColor)
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                    Text(text = amount, fontSize = 26.sp, fontWeight = FontWeight.Bold, color = FigmaTitleColor)
                    Text(text = "₽", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = FigmaTitleColor)
                }
                Button(
                    onClick = onPayClick,
                    modifier = Modifier.fillMaxWidth().height(60.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = FigmaBrandBlue),
                    shape = RoundedCornerShape(30.dp)
                ) {
                    Text(text = "Оплатить", color = FigmaCardWhite, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }
                Text(
                    text = "Нажимая на кнопку \"Оплатить\", Вы соглашаетесь с условиями на обработку персональных данных",
                    fontSize = 13.sp,
                    color = FigmaTextLight,
                    textAlign = TextAlign.Center,
                    lineHeight = 15.6.sp
                )
            }
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
fun SberPaymentCard(onDetailsClick: () -> Unit) {
    FigmaCard {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(text = "Оплата через", fontSize = 20.sp, color = FigmaTitleColor)
            FigmaImage(model = R.drawable.ic_sber_logo, modifier = Modifier.width(149.dp).height(23.dp))
        }
        Row(horizontalArrangement = Arrangement.spacedBy(20.dp), verticalAlignment = Alignment.Top) {
            Text(
                text = "Оплата услуг компнании ООО \"Луганские сети\" доступна через \"СберБанк\" с комиссией 1%",
                modifier = Modifier.weight(1f), color = FigmaTextPrimary, fontSize = 14.sp, lineHeight = 18.2.sp
            )
            ActionDetailsButton(text = "Детальнее", onClick = onDetailsClick)
        }
    }
}

@Composable
fun SimplePaymentCard(title: String, description: String, onDetailsClick: () -> Unit) {
    FigmaCard {
        Text(text = title, fontSize = 20.sp, color = FigmaTitleColor)
        Row(horizontalArrangement = Arrangement.spacedBy(20.dp), verticalAlignment = Alignment.Top) {
            Text(text = description, modifier = Modifier.weight(1f), color = FigmaTextPrimary, fontSize = 14.sp, lineHeight = 18.2.sp)
            ActionDetailsButton(text = "Детальнее", onClick = onDetailsClick)
        }
    }
}

@Composable
fun TerminalPaymentCard() {
    FigmaCard {
        Text(text = "Оплата услуг ЛДС с помощью платежных терминалов", fontSize = 20.sp, color = FigmaTitleColor)
        Text(
            text = "Абоненты ЛДС могут произвести оплату в сети платежных терминалов, которые расположены в магазинах и супермаркетах Вашего населенного пункта. Для оплаты услуг Вам потребуется лицевой счет, который был присвоен Вам при подключении. Номер лицевого счета указан в памятке пользователя. Для восстановления номера лицевого счета в случае его утери обратитесь в техническую поддержку компании ЛДС.",
            color = FigmaTextPrimary, fontSize = 14.sp, lineHeight = 18.2.sp
        )
        Box(modifier = Modifier.fillMaxWidth().height(300.dp).background(FigmaBackgroundGray, RoundedCornerShape(10.dp)))
    }
}

@Composable
fun PaymentPointCard(point: PaymentPoint) {
    FigmaCard {
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
        
        Box(modifier = Modifier.fillMaxWidth().height(300.dp).background(FigmaBackgroundGray, RoundedCornerShape(10.dp)))
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
                        color = if (isHoliday) White else FigmaBrandBlue,
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
