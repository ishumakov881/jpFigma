package com.walhalla.jpfigma.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.Payment
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.components.*
import com.walhalla.jpfigma.ui.model.*
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun AccountScreen(
    modifier: Modifier = Modifier
) {
    val account = MockData.getAccountInfo()
    val servicePackage = MockData.getUserServicePackage()

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF4F7FB)),
        contentPadding = PaddingValues(20.dp),
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
                    Text(text = account.status, color = Green, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                    Icon(Icons.Default.HelpOutline, contentDescription = null, tint = Color.LightGray, modifier = Modifier.size(25.dp))
                }
            }
        }

        // Balance Card
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
                        Text(text = account.balance, color = Green, fontSize = 32.sp, fontWeight = FontWeight.Bold)
                        Text(text = "₽", color = Green, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    }
                    Text(text = account.balanceUntil, color = SecondaryText, fontSize = 13.sp)
                }

                Button(
                    onClick = { },
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
                        OutlinedButton(
                            onClick = { },
                            modifier = Modifier.weight(1f).height(40.dp),
                            shape = RoundedCornerShape(20.dp),
                            border = BorderStroke(1.dp, BrandColor1.copy(alpha = 0.5f))
                        ) {
                            Text(text = "на 24 часа", color = BrandColor1, fontSize = 15.sp)
                        }
                        OutlinedButton(
                            onClick = { },
                            modifier = Modifier.weight(1f).height(40.dp),
                            shape = RoundedCornerShape(20.dp),
                            border = BorderStroke(1.dp, BrandColor1.copy(alpha = 0.5f))
                        ) {
                            Text(text = "на 72 часа", color = BrandColor1, fontSize = 15.sp)
                        }
                    }
                }

                HorizontalDivider(color = LineColor)

                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = "Тарифный план:", color = SecondaryText, fontSize = 14.sp)
                        Text(text = account.tariffName, color = Text2, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }
                    OutlinedButton(
                        onClick = { },
                        shape = RoundedCornerShape(20.dp),
                        border = BorderStroke(1.dp, BrandColor1)
                    ) {
                        Text(text = "Сменить", color = BrandColor1, fontSize = 15.sp)
                    }
                }

                HorizontalDivider(color = LineColor)

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(Icons.Default.NotificationsActive, contentDescription = null, tint = BrandColor1, modifier = Modifier.size(24.dp))
                    Spacer(Modifier.width(5.dp))
                    Text(text = "Уведомления о состоянии баланса", color = Color(0xFF0880C5), fontSize = 14.sp)
                }
            }
        }

        // Information Card
        item {
            AccountCard(
                title = "Информация",
                gradient = Brush.linearGradient(listOf(Color(0xFFFFE4CC), Color(0xFFF3BD95)))
            ) {
                InfoRow(label = "Лицевой счёт:", value = account.accountNumber)
                HorizontalDivider(color = LineColor)
                InfoRow(label = "Ф.И.О.:", value = account.fullName)
                HorizontalDivider(color = LineColor)
                InfoRow(label = "Адрес подключения:", value = account.address)
                HorizontalDivider(color = LineColor)
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    InfoRow(label = "Актуальный номер телефона:", value = account.phone)
                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        OutlinedButton(
                            onClick = { },
                            modifier = Modifier.size(40.dp),
                            shape = RoundedCornerShape(20.dp),
                            border = BorderStroke(1.dp, BrandColor1),
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Icon(Icons.Default.Add, contentDescription = null, tint = BrandColor1)
                        }
                        OutlinedButton(
                            onClick = { },
                            modifier = Modifier.height(40.dp),
                            shape = RoundedCornerShape(20.dp),
                            border = BorderStroke(1.dp, BrandColor1)
                        ) {
                            Text(text = "Актуализировать", color = BrandColor1, fontSize = 15.sp)
                        }
                    }
                }
            }
        }

        // Service Status Card
        item {
            AccountCard(
                title = "Состояние услуг",
                gradient = Brush.linearGradient(listOf(Color(0xFFCCD1FF), Color(0xFF95AAF3)))
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(text = "Состояние подключения к сети Интернет", color = SecondaryText, fontSize = 14.sp)
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        Text(text = account.internetStatus, color = Text2, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                        Icon(Icons.Default.HelpOutline, contentDescription = null, tint = Color.LightGray, modifier = Modifier.size(25.dp))
                    }
                    OutlinedButton(
                        onClick = { },
                        shape = RoundedCornerShape(20.dp),
                        border = BorderStroke(1.dp, BrandColor1)
                    ) {
                        Text(text = "Разъединить", color = BrandColor1, fontSize = 15.sp)
                    }
                }
                
                HorizontalDivider(color = LineColor)

                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(text = "МАС адрес:", color = SecondaryText, fontSize = 14.sp)
                    Text(text = account.macAddress, color = Text2, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    OutlinedButton(
                        onClick = { },
                        shape = RoundedCornerShape(20.dp),
                        border = BorderStroke(1.dp, BrandColor1)
                    ) {
                        Text(text = "Сменить", color = BrandColor1, fontSize = 15.sp)
                    }
                }

                HorizontalDivider(color = LineColor)

                Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                    Text(text = "Состояние подключения к кабельному телевидению", color = SecondaryText, fontSize = 14.sp)
                    Text(text = account.tvStatus, color = Text2, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        // Package Card
        item {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Ваш пакет услуг", color = Color(0xFF041E37), fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
                OutlinedButton(
                    onClick = { },
                    shape = RoundedCornerShape(20.dp),
                    border = BorderStroke(1.dp, BrandColor1)
                ) {
                    Text(text = "Все услуги", color = BrandColor1, fontSize = 15.sp)
                }
            }
            Spacer(Modifier.height(10.dp))
            ServicePackageCard(servicePackage = servicePackage)
        }
    }
}
