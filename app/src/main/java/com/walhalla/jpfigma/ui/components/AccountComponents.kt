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
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun AccountScreenBody(
    modifier: Modifier = Modifier,
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
    oldTotalPrice: String? = null,
    services: List<ServicePriceData>,
    onTopUpClick: () -> Unit = {},
    onChangeTariffClick: () -> Unit = {},
    onActualizeClick: () -> Unit = {},
    onDisconnectInternetClick: () -> Unit = {},
    onChangeMacClick: () -> Unit = {},
    onAllServicesClick: () -> Unit = {}
) {
    val backgroundColor = Color(0xFFF4F7FB)
    val screenPadding = 20.dp

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor),
        contentPadding = PaddingValues(screenPadding),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Ваш аккаунт", color = TitleColor, fontSize = 22.sp)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.padding(top = 5.dp)
                ) {
                    Text(text = status, color = Green, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.HelpOutline,
                        contentDescription = null,
                        tint = Color.LightGray,
                        modifier = Modifier.size(25.dp)
                    )
                }
            }
        }

        item {
            AccountCard(
                title = "Баланс",
                gradient = Brush.linearGradient(listOf(Color(0xFFCCE6FF), Color(0xFF95C5F3)))
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
                        Text(text = balance, color = Green, fontSize = 32.sp, fontWeight = FontWeight.Bold)
                        Text(text = "₽", color = Green, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    }
                    Text(text = balanceUntil, color = SecondaryText, fontSize = 13.sp)
                }

                Button(
                    onClick = onTopUpClick,
                    modifier = Modifier.fillMaxWidth().height(40.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = BrandColor1),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Icon(Icons.Default.Payment, contentDescription = null, modifier = Modifier.size(24.dp))
                    Spacer(Modifier.width(10.dp))
                    Text(text = "Пополнить", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }

                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(text = "Отложенный платёж:", color = Text2, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        OutlinedButton(onClick = { }, modifier = Modifier.weight(1f).height(40.dp), shape = RoundedCornerShape(20.dp), border = BorderStroke(1.dp, BrandColor1.copy(alpha = 0.5f))) { Text(text = "на 24 часа", color = BrandColor1, fontSize = 15.sp) }
                        OutlinedButton(onClick = { }, modifier = Modifier.weight(1f).height(40.dp), shape = RoundedCornerShape(20.dp), border = BorderStroke(1.dp, BrandColor1.copy(alpha = 0.5f))) { Text(text = "на 72 часа", color = BrandColor1, fontSize = 15.sp) }
                    }
                }

                HorizontalDivider(color = LineColor)

                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = "Тарифный план:", color = SecondaryText, fontSize = 14.sp)
                        Text(text = tariffName, color = Text2, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }
                    OutlinedButton(onClick = onChangeTariffClick, shape = RoundedCornerShape(20.dp), border = BorderStroke(1.dp, BrandColor1)) { Text(text = "Сменить", color = BrandColor1, fontSize = 15.sp) }
                }

                HorizontalDivider(color = LineColor)

                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                    Icon(Icons.Default.NotificationsActive, contentDescription = null, tint = BrandColor1, modifier = Modifier.size(24.dp))
                    Spacer(Modifier.width(5.dp))
                    Text(text = "Уведомления о состоянии баланса", color = Color(0xFF0880C5), fontSize = 14.sp)
                }
            }
        }

        item {
            AccountCard(title = "Информация", gradient = Brush.linearGradient(listOf(Color(0xFFFFE4CC), Color(0xFFF3BD95)))) {
                InfoRow(label = "Лицевой счёт:", value = accountNumber)
                HorizontalDivider(color = LineColor)
                InfoRow(label = "Ф.И.О.:", value = fullName)
                HorizontalDivider(color = LineColor)
                InfoRow(label = "Адрес подключения:", value = address)
                HorizontalDivider(color = LineColor)
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    InfoRow(label = "Актуальный номер телефона:", value = phone)
                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        OutlinedButton(onClick = { }, modifier = Modifier.size(40.dp), shape = RoundedCornerShape(20.dp), border = BorderStroke(1.dp, BrandColor1), contentPadding = PaddingValues(0.dp)) { Text("+", color = BrandColor1, fontSize = 20.sp) }
                        OutlinedButton(onClick = onActualizeClick, modifier = Modifier.height(40.dp), shape = RoundedCornerShape(20.dp), border = BorderStroke(1.dp, BrandColor1)) { Text(text = "Актуализировать", color = BrandColor1, fontSize = 15.sp) }
                    }
                }
            }
        }

        item {
            AccountCard(title = "Состояние услуг", gradient = Brush.linearGradient(listOf(Color(0xFFCCD1FF), Color(0xFF95AAF3)))) {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(text = "Состояние подключения к сети Интернет", color = SecondaryText, fontSize = 14.sp)
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        Text(text = internetStatus, color = Text2, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                        Icon(Icons.AutoMirrored.Filled.HelpOutline, contentDescription = null, tint = Color.LightGray, modifier = Modifier.size(25.dp))
                    }
                    OutlinedButton(onClick = onDisconnectInternetClick, shape = RoundedCornerShape(20.dp), border = BorderStroke(1.dp, BrandColor1)) { Text(text = "Разъединить", color = BrandColor1, fontSize = 15.sp) }
                }
                HorizontalDivider(color = LineColor)
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(text = "МАС адрес:", color = SecondaryText, fontSize = 14.sp)
                    Text(text = macAddress, color = Text2, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    OutlinedButton(onClick = onChangeMacClick, shape = RoundedCornerShape(20.dp), border = BorderStroke(1.dp, BrandColor1)) { Text(text = "Сменить", color = BrandColor1, fontSize = 15.sp) }
                }
                HorizontalDivider(color = LineColor)
                Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                    Text(text = "Состояние подключения к кабельному телевидению", color = SecondaryText, fontSize = 14.sp)
                    Text(text = tvStatus, color = Text2, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        item {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Ваш пакет услуг", color = Color(0xFF041E37), fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
                OutlinedButton(onClick = onAllServicesClick, shape = RoundedCornerShape(20.dp), border = BorderStroke(1.dp, BrandColor1)) { Text(text = "Все услуги", color = BrandColor1, fontSize = 15.sp) }
            }
            Spacer(Modifier.height(10.dp))
            ServicePackageCard(
                totalPrice = totalPrice,
                oldTotalPrice = oldTotalPrice
            ) {
                services.forEach { service ->
                    ServicePriceItem(
                        name = service.name,
                        price = service.price,
                        oldPrice = service.oldPrice,
                        hasOffer = service.hasOffer
                    )
                    HorizontalDivider(color = LineColor, modifier = Modifier.padding(vertical = 5.dp))
                }
            }
        }
    }
}

@Composable
fun AccountCard(modifier: Modifier = Modifier, title: String, gradient: Brush, horizontalPadding: androidx.compose.ui.unit.Dp = 30.dp, content: @Composable ColumnScope.() -> Unit) {
    Card(modifier = modifier.fillMaxWidth(), shape = RoundedCornerShape(20.dp), colors = CardDefaults.cardColors(containerColor = Color.White), elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)) {
        Column {
            Box(modifier = Modifier.fillMaxWidth().height(50.dp).background(gradient), contentAlignment = Alignment.Center) { Text(text = title, color = Color(0xFF041E37), fontSize = 18.sp, fontWeight = FontWeight.Bold) }
            Column(modifier = Modifier.padding(horizontal = horizontalPadding, vertical = 20.dp).fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(15.dp)) { content() }
        }
    }
}

@Composable
fun InfoRow(modifier: Modifier = Modifier, label: String, value: String, isBold: Boolean = true) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(5.dp)) {
        Text(text = label, color = SecondaryText, fontSize = 14.sp)
        Text(text = value, color = Text2, fontSize = 16.sp, fontWeight = if (isBold) FontWeight.Bold else FontWeight.Normal)
    }
}

@Composable
fun ServicePackageCard(modifier: Modifier = Modifier, totalPrice: String, oldTotalPrice: String? = null, servicesContent: @Composable ColumnScope.() -> Unit) {
    Card(modifier = modifier.fillMaxWidth(), shape = RoundedCornerShape(20.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
        Column(modifier = Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(15.dp)) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Оказываемая услуга", color = SecondaryText, fontSize = 14.sp, modifier = Modifier.weight(1f))
                Text(text = "Стоимость\nза 30 дней", color = SecondaryText, fontSize = 14.sp, textAlign = TextAlign.End)
            }
            HorizontalDivider(color = LineColor)
            servicesContent()
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Итого за 30 дней", color = Text2, fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
                if (oldTotalPrice != null) { Text(text = "$oldTotalPrice ₽", color = BrandColor2, fontSize = 15.sp, textDecoration = TextDecoration.LineThrough, modifier = Modifier.padding(end = 10.dp)) }
                Text(text = "$totalPrice ₽", color = Text2, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun ServicePriceItem(modifier: Modifier = Modifier, name: String, price: String, oldPrice: String? = null, hasOffer: Boolean = false) {
    Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = name, color = Text2, fontSize = 14.sp)
            if (hasOffer) {
                Surface(color = BrandColor2, shape = RoundedCornerShape(5.dp), modifier = Modifier.padding(top = 5.dp)) {
                    Text(text = "АКЦИЯ", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp))
                }
            }
        }
        Column(horizontalAlignment = Alignment.End) {
            Text(text = "$price ₽", color = Text2, fontSize = 14.sp)
            if (oldPrice != null) { Text(text = "$oldPrice ₽", color = BrandColor2, fontSize = 12.sp, textDecoration = TextDecoration.LineThrough) }
        }
    }
}

data class ServicePriceData(val name: String, val price: String, val oldPrice: String? = null, val hasOffer: Boolean = false)
