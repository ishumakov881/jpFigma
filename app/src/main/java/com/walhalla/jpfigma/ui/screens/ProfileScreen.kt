package com.walhalla.jpfigma.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.components.*
import com.walhalla.jpfigma.ui.model.*
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    onSavePasswordClick: () -> Unit = {}
) {
    val profile = MockData.getSubscriberProfile()
    
    var oldPassword by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF4F7FB)),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            Text(text = "Профиль абонента", color = TitleColor, fontSize = 22.sp, modifier = Modifier.padding(bottom = 10.dp))
        }

        // Basic Info Card
        item {
            AccountCard(
                title = "Основные данные",
                gradient = Brush.linearGradient(listOf(Color(0xFFCCE6FF), Color(0xFF95C5F3)))
            ) {
                InfoRow(label = "Лицевой счёт:", value = profile.accountNumber)
                HorizontalDivider(color = LineColor)
                InfoRow(label = "Ф.И.О.:", value = profile.fullName)
                HorizontalDivider(color = LineColor)
                InfoRow(label = "Адрес подключения:", value = profile.address)
                HorizontalDivider(color = LineColor)
                
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(text = "Контактные телефоны:", color = SecondaryText, fontSize = 16.sp)
                    Text(
                        text = "Указанные номера телефонов не передаются третьим лицам и используются исключительно для обратной связи с Вами, с целью улучшения и контроля качества предоставляемых услуг.",
                        color = Text2,
                        fontSize = 13.sp,
                        lineHeight = 17.sp
                    )
                    
                    profile.phones.forEachIndexed { index, phone ->
                        PhoneItem(phone = phone)
                        if (index < profile.phones.size - 1) {
                            HorizontalDivider(color = LineColor, modifier = Modifier.padding(vertical = 10.dp))
                        }
                    }

                    Spacer(Modifier.height(10.dp))

                    OutlinedButton(
                        onClick = { },
                        modifier = Modifier.fillMaxWidth().height(40.dp),
                        shape = RoundedCornerShape(20.dp),
                        border = BorderStroke(1.dp, BrandColor1)
                    ) {
                        Icon(Icons.Default.Add, contentDescription = null, tint = BrandColor1)
                        Spacer(Modifier.width(10.dp))
                        Text(text = "Добавить номер", color = BrandColor1, fontSize = 15.sp)
                    }
                }
            }
        }

        // Password Change Card
        item {
            AccountCard(
                title = "Смена пароля",
                gradient = Brush.linearGradient(listOf(Color(0xFFCCE6FF), Color(0xFF95C5F3)))
            ) {
                ProfileInputField(
                    label = "Старый пароль",
                    value = oldPassword,
                    onValueChange = { oldPassword = it },
                    placeholder = "Введите старый пароль"
                )
                ProfileInputField(
                    label = "Новый пароль",
                    value = newPassword,
                    onValueChange = { newPassword = it },
                    placeholder = "Введите новый пароль"
                )
                ProfileInputField(
                    label = "Новый пароль ещё раз",
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    placeholder = "Повторите новый пароль"
                )

                Spacer(Modifier.height(10.dp))

                OutlinedButton(
                    onClick = onSavePasswordClick,
                    modifier = Modifier.fillMaxWidth().height(40.dp),
                    shape = RoundedCornerShape(20.dp),
                    border = BorderStroke(1.dp, BrandColor1)
                ) {
                    Icon(Icons.Default.Check, contentDescription = null, tint = BrandColor1)
                    Spacer(Modifier.width(10.dp))
                    Text(text = "Сохранить", color = BrandColor1, fontSize = 15.sp)
                }
            }
        }
    }
}
