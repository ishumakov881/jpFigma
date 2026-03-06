package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun ProfileScreenBody(
    modifier: Modifier = Modifier,
    accountNumber: String,
    fullName: String,
    address: String,
    phones: List<PhoneData>,
    oldPassword: String,
    newPassword: String,
    confirmPassword: String,
    onOldPasswordChange: (String) -> Unit = {},
    onNewPasswordChange: (String) -> Unit = {},
    onConfirmPasswordChange: (String) -> Unit = {},
    onSavePasswordClick: () -> Unit = {},
    onAddPhoneClick: () -> Unit = {},
    onDeletePhoneClick: (String) -> Unit = {},
    onMakePrimaryClick: (String) -> Unit = {},
    onActualizePhoneClick: (String) -> Unit = {}
) {
    val backgroundColor = Color(0xFFF4F7FB)
    val cardPadding = 20.dp

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor),
        contentPadding = PaddingValues(cardPadding),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            Text(text = "Профиль абонента", color = TitleColor, fontSize = 22.sp, modifier = Modifier.padding(bottom = 10.dp))
        }

        item {
            AccountCard(
                title = "Основные данные",
                gradient = Brush.linearGradient(listOf(Color(0xFFCCE6FF), Color(0xFF95C5F3)))
            ) {
                InfoRow(label = "Лицевой счёт:", value = accountNumber)
                HorizontalDivider(color = LineColor)
                InfoRow(label = "Ф.И.О.:", value = fullName)
                HorizontalDivider(color = LineColor)
                InfoRow(label = "Адрес подключения:", value = address)
                HorizontalDivider(color = LineColor)
                
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(text = "Контактные телефоны:", color = SecondaryText, fontSize = 16.sp)
                    Text(
                        text = "Указанные номера телефонов не передаются третьим лицам и используются исключительно для обратной связи с Вами, с целью улучшения и контроля качества предоставляемых услуг.",
                        color = Text2,
                        fontSize = 13.sp,
                        lineHeight = 17.sp
                    )
                    
                    phones.forEachIndexed { index, phone ->
                        PhoneItem(
                            number = phone.number,
                            isPrimary = phone.isPrimary,
                            isActualized = phone.isActualized,
                            onDeleteClick = { onDeletePhoneClick(phone.number) },
                            onMakePrimaryClick = { onMakePrimaryClick(phone.number) },
                            onActualizeClick = { onActualizePhoneClick(phone.number) }
                        )
                        if (index < phones.size - 1) {
                            HorizontalDivider(color = LineColor, modifier = Modifier.padding(vertical = 10.dp))
                        }
                    }

                    Spacer(Modifier.height(10.dp))

                    OutlinedButton(
                        onClick = onAddPhoneClick,
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

        item {
            AccountCard(
                title = "Смена пароля",
                gradient = Brush.linearGradient(listOf(Color(0xFFCCE6FF), Color(0xFF95C5F3)))
            ) {
                ProfileInputField(
                    label = "Старый пароль",
                    value = oldPassword,
                    onValueChange = onOldPasswordChange,
                    placeholder = "Введите старый пароль"
                )
                ProfileInputField(
                    label = "Новый пароль",
                    value = newPassword,
                    onValueChange = onNewPasswordChange,
                    placeholder = "Введите новый пароль"
                )
                ProfileInputField(
                    label = "Новый пароль ещё раз",
                    value = confirmPassword,
                    onValueChange = onConfirmPasswordChange,
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

data class PhoneData(
    val number: String,
    val isPrimary: Boolean = false,
    val isActualized: Boolean = false
)
