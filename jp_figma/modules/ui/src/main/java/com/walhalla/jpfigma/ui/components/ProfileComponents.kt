package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.theme.*
import com.walhalla.ui0.R

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

@Composable
fun PhoneItem(
    modifier: Modifier = Modifier,
    number: String,
    isPrimary: Boolean = false,
    isActualized: Boolean = false,
    onDeleteClick: () -> Unit = {},
    onMakePrimaryClick: () -> Unit = {},
    onActualizeClick: () -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = number,
                color = Text2,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            if (isPrimary) {
                Surface(
                    color = Green,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "ОСНОВНОЙ",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            if (isActualized) {
                Surface(
                    modifier = Modifier.weight(1f).height(40.dp),
                    color = GreenBg2,
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Default.Check, contentDescription = null, tint = Green, modifier = Modifier.size(20.dp))
                        Spacer(Modifier.width(8.dp))
                        Text(text = "Актуализирован", color = Green, fontSize = 15.sp)
                    }
                }
            } else {
                OutlinedButton(
                    onClick = onActualizeClick,
                    modifier = Modifier.weight(1f).height(40.dp),
                    shape = RoundedCornerShape(20.dp),
                    border = BorderStroke(1.dp, BrandColor1)
                ) {
                    Icon(Icons.Default.Check, contentDescription = null, tint = BrandColor1, modifier = Modifier.size(20.dp))
                    Spacer(Modifier.width(8.dp))
                    Text(text = "Актуализировать", color = BrandColor1, fontSize = 15.sp)
                }
            }

            if (!isPrimary) {
                OutlinedButton(
                    onClick = onMakePrimaryClick,
                    modifier = Modifier.weight(1f).height(40.dp),
                    shape = RoundedCornerShape(20.dp),
                    border = BorderStroke(1.dp, BrandColor1)
                ) {
                    Text(text = "Сделать основным", color = BrandColor1, fontSize = 15.sp)
                }
            }

            OutlinedButton(
                onClick = onDeleteClick,
                modifier = Modifier.size(40.dp),
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(1.dp, BrandColor1),
                contentPadding = PaddingValues(0.dp)
            ) {
                Icon(Icons.Default.DeleteOutline, contentDescription = null, tint = BrandColor1)
            }
        }
    }
}

@Composable
fun ProfileInputField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text(text = label, color = Text2, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(Color(0xFFFBFDFF), RoundedCornerShape(8.dp))
                .border(1.dp, Color(0xFF839AB1), RoundedCornerShape(8.dp))
                .padding(horizontal = 20.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            if (value.isEmpty()) {
                Text(text = placeholder, color = Color(0xFF8A9CAF), fontSize = 15.sp)
            }
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                textStyle = LocalTextStyle.current.copy(color = Text2, fontSize = 15.sp),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

data class PhoneData(
    val number: String,
    val isPrimary: Boolean = false,
    val isActualized: Boolean = false
)
