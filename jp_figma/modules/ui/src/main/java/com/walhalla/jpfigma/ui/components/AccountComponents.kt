package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.HelpOutline
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.Payment
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.model.*
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun AccountScreenBody(
    status: String,
    balance: String,
    balanceUntil: String,
    tariffName: String,
    accountNumber: String,
    fullName: String,
    address: String,
    phone: String,
    internetStatus: String,
    macAddress: String,
    tvStatus: String,
    totalPrice: String,
    services: List<ServicePriceData>,
    modifier: Modifier = Modifier,
    oldTotalPrice: String? = null,
    onTopUpClick: () -> Unit = {},
    onChangeTariffClick: () -> Unit = {},
    onActualizeClick: () -> Unit = {},
    onDisconnectInternetClick: () -> Unit = {},
    onChangeMacClick: () -> Unit = {},
    onAllServicesClick: () -> Unit = {}
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(FigmaBackgroundGray),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Ваш аккаунт", color = FigmaTitleColor, fontSize = 22.sp)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.padding(top = 5.dp)
                ) {
                    Text(text = status, color = FigmaSuccessGreen, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.HelpOutline,
                        contentDescription = null,
                        tint = FigmaTextHint,
                        modifier = Modifier.size(25.dp)
                    )
                }
            }
        }

        item {
            AccountSectionCard(
                title = "Баланс",
                gradient = FigmaBlueGradient
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text(text = balance, color = FigmaSuccessGreen, fontSize = 32.sp, fontWeight = FontWeight.Bold)
                        Text(text = "₽", color = FigmaSuccessGreen, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    }
                    Text(text = balanceUntil, color = FigmaTextLight, fontSize = 13.sp)
                }

                Button(
                    onClick = onTopUpClick,
                    modifier = Modifier.fillMaxWidth().height(40.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = FigmaBrandBlue),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Icon(Icons.Default.Payment, contentDescription = null, modifier = Modifier.size(24.dp))
                    Spacer(Modifier.width(10.dp))
                    Text(text = "Пополнить", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }

                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(text = "Отложенный платёж:", color = FigmaTextPrimary, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        OutlinedButton(onClick = { }, modifier = Modifier.weight(1f).height(40.dp), shape = RoundedCornerShape(20.dp), border = BorderStroke(1.dp, FigmaBrandBlue.copy(alpha = 0.5f))) { Text(text = "на 24 часа", color = FigmaBrandBlue, fontSize = 15.sp) }
                        OutlinedButton(onClick = { }, modifier = Modifier.weight(1f).height(40.dp), shape = RoundedCornerShape(20.dp), border = BorderStroke(1.dp, FigmaBrandBlue.copy(alpha = 0.5f))) { Text(text = "на 72 часа", color = FigmaBrandBlue, fontSize = 15.sp) }
                    }
                }

                HorizontalDivider(color = FigmaLineColor)

                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = "Тарифный план:", color = FigmaTextLight, fontSize = 14.sp)
                        Text(text = tariffName, color = FigmaTextPrimary, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }
                    OutlinedButton(onClick = onChangeTariffClick, shape = RoundedCornerShape(20.dp), border = BorderStroke(1.dp, FigmaBrandBlue)) { Text(text = "Сменить", color = FigmaBrandBlue, fontSize = 15.sp) }
                }

                HorizontalDivider(color = FigmaLineColor)

                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                    Icon(Icons.Default.NotificationsActive, contentDescription = null, tint = FigmaBrandBlue, modifier = Modifier.size(24.dp))
                    Spacer(Modifier.width(5.dp))
                    Text(text = "Уведомления о состоянии баланса", color = FigmaInfoBlue, fontSize = 14.sp)
                }
            }
        }

        item {
            AccountSectionCard(title = "Информация", gradient = FigmaOrangeGradient) {
                InfoRowItem(label = "Лицевой счёт:", value = accountNumber)
                HorizontalDivider(color = FigmaLineColor)
                InfoRowItem(label = "Ф.И.О.:", value = fullName)
                HorizontalDivider(color = FigmaLineColor)
                InfoRowItem(label = "Адрес подключения:", value = address)
                HorizontalDivider(color = FigmaLineColor)
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    InfoRowItem(label = "Актуальный номер телефона:", value = phone)
                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        OutlinedButton(onClick = { }, modifier = Modifier.size(40.dp), shape = RoundedCornerShape(20.dp), border = BorderStroke(1.dp, FigmaBrandBlue), contentPadding = PaddingValues(0.dp)) { Text("+", color = FigmaBrandBlue, fontSize = 20.sp) }
                        OutlinedButton(onClick = onActualizeClick, modifier = Modifier.height(40.dp), shape = RoundedCornerShape(20.dp), border = BorderStroke(1.dp, FigmaBrandBlue)) { Text(text = "Актуализировать", color = FigmaBrandBlue, fontSize = 15.sp) }
                    }
                }
            }
        }

        item {
            AccountSectionCard(title = "Состояние услуг", gradient = FigmaPurpleGradient) {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(text = "Состояние подключения к сети Интернет", color = FigmaTextLight, fontSize = 14.sp)
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        Text(text = internetStatus, color = FigmaTextPrimary, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                        Icon(Icons.AutoMirrored.Filled.HelpOutline, contentDescription = null, tint = FigmaTextHint, modifier = Modifier.size(25.dp))
                    }
                    OutlinedButton(onClick = onDisconnectInternetClick, shape = RoundedCornerShape(20.dp), border = BorderStroke(1.dp, FigmaBrandBlue)) { Text(text = "Разъединить", color = FigmaBrandBlue, fontSize = 15.sp) }
                }
                HorizontalDivider(color = FigmaLineColor)
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(text = "МАС адрес:", color = FigmaTextLight, fontSize = 14.sp)
                    Text(text = macAddress, color = FigmaTextPrimary, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    OutlinedButton(onClick = onChangeMacClick, shape = RoundedCornerShape(20.dp), border = BorderStroke(1.dp, FigmaBrandBlue)) { Text(text = "Сменить", color = FigmaBrandBlue, fontSize = 15.sp) }
                }
                HorizontalDivider(color = FigmaLineColor)
                Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                    Text(text = "Состояние подключения к кабельному телевидению", color = FigmaTextLight, fontSize = 14.sp)
                    Text(text = tvStatus, color = FigmaTextPrimary, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        item {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Ваш пакет услуг", color = FigmaDarkTitle, fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
                OutlinedButton(onClick = onAllServicesClick, shape = RoundedCornerShape(20.dp), border = BorderStroke(1.dp, FigmaBrandBlue)) { Text(text = "Все услуги", color = FigmaBrandBlue, fontSize = 15.sp) }
            }
            Spacer(Modifier.height(10.dp))
            FigmaCard(padding = 20.dp) {
                Column(verticalArrangement = Arrangement.spacedBy(15.dp)) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(text = "Оказываемая услуга", color = FigmaTextLight, fontSize = 14.sp, modifier = Modifier.weight(1f))
                        Text(text = "Стоимость\nза 30 дней", color = FigmaTextLight, fontSize = 14.sp, textAlign = TextAlign.End)
                    }
                    HorizontalDivider(color = FigmaLineColor)
                    services.forEach { service ->
                        ServicePriceRow(service)
                        HorizontalDivider(color = FigmaLineColor, modifier = Modifier.padding(vertical = 5.dp))
                    }
                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "Итого за 30 дней", color = FigmaTextPrimary, fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
                        if (oldTotalPrice != null) { Text(text = "$oldTotalPrice ₽", color = FigmaBrandOrange, fontSize = 15.sp, textDecoration = TextDecoration.LineThrough, modifier = Modifier.padding(end = 10.dp)) }
                        Text(text = "$totalPrice ₽", color = FigmaTextPrimary, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Composable
fun AccountSectionCard(
    title: String,
    gradient: Brush,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = FigmaCardWhite),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(gradient),
                contentAlignment = Alignment.Center
            ) {
                Text(text = title, color = FigmaDarkTitle, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 30.dp, vertical = 20.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                content()
            }
        }
    }
}

@Composable
fun InfoRowItem(label: String, value: String, isBold: Boolean = true) {
    Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
        Text(text = label, color = FigmaTextLight, fontSize = 14.sp)
        Text(text = value, color = FigmaTextPrimary, fontSize = 16.sp, fontWeight = if (isBold) FontWeight.Bold else FontWeight.Normal)
    }
}

@Composable
fun ServicePriceRow(service: ServicePriceData) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = service.name, color = FigmaTextPrimary, fontSize = 14.sp)
            if (service.hasOffer) {
                Surface(color = FigmaBrandOrange, shape = RoundedCornerShape(5.dp), modifier = Modifier.padding(top = 5.dp)) {
                    Text(text = "АКЦИЯ", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp))
                }
            }
        }
        Column(horizontalAlignment = Alignment.End) {
            Text(text = "${service.price} ₽", color = FigmaTextPrimary, fontSize = 14.sp)
            if (service.oldPrice != null) { Text(text = "${service.oldPrice} ₽", color = FigmaBrandOrange, fontSize = 12.sp, textDecoration = TextDecoration.LineThrough) }
        }
    }
}

data class ServicePriceData(val name: String, val price: String, val oldPrice: String? = null, val hasOffer: Boolean = false)
