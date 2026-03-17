package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.model.*
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun ProfileScreenBody(
    accountNumber: String,
    fullName: String,
    address: String,
    phones: List<PhoneData>,
    oldPassword: String,
    newPassword: String,
    confirmPassword: String,
    modifier: Modifier = Modifier,
    onOldPasswordChange: (String) -> Unit = {},
    onNewPasswordChange: (String) -> Unit = {},
    onConfirmPasswordChange: (String) -> Unit = {},
    onUpdatePasswordClick: () -> Unit = {}
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(FigmaBackgroundGray)
            .verticalScroll(scrollState)
            .padding(vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = "Профиль абонента",
            color = FigmaTitleColor,
            fontSize = 22.sp,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        FigmaCard(modifier = Modifier.padding(horizontal = 20.dp)) {
            Column(verticalArrangement = Arrangement.spacedBy(15.dp)) {
                ProfileInfoRow(label = "Лицевой счет:", value = accountNumber)
                HorizontalDivider(color = FigmaLineColor)
                ProfileInfoRow(label = "Ф.И.О.:", value = fullName)
                HorizontalDivider(color = FigmaLineColor)
                ProfileInfoRow(label = "Адрес подключения:", value = address)
            }
        }

        Text(
            text = "Ваши номера телефонов",
            color = FigmaDarkTitle,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        FigmaCard(modifier = Modifier.padding(horizontal = 20.dp)) {
            phones.forEachIndexed { index, phone ->
                PhoneItemRow(phone)
                if (index < phones.size - 1) {
                    HorizontalDivider(color = FigmaLineColor, modifier = Modifier.padding(vertical = 10.dp))
                }
            }
        }

        Text(
            text = "Смена пароля",
            color = FigmaDarkTitle,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        FigmaCard(modifier = Modifier.padding(horizontal = 20.dp)) {
            Column(verticalArrangement = Arrangement.spacedBy(15.dp)) {
                ProfileTextField(
                    label = "Старый пароль",
                    value = oldPassword,
                    onValueChange = onOldPasswordChange
                )
                ProfileTextField(
                    label = "Новый пароль",
                    value = newPassword,
                    onValueChange = onNewPasswordChange
                )
                ProfileTextField(
                    label = "Подтверждение пароля",
                    value = confirmPassword,
                    onValueChange = onConfirmPasswordChange
                )
                Button(
                    onClick = onUpdatePasswordClick,
                    modifier = Modifier.fillMaxWidth().height(40.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = FigmaBrandBlue),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(text = "Обновить пароль", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun ProfileInfoRow(label: String, value: String) {
    Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
        Text(text = label, color = FigmaTextLight, fontSize = 14.sp)
        Text(text = value, color = FigmaTextPrimary, fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun PhoneItemRow(data: PhoneData) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = data.number, color = FigmaTextPrimary, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            if (data.isPrimary) {
                Text(text = "Основной", color = FigmaSuccessGreen, fontSize = 12.sp)
            }
        }
        if (data.isActualized) {
            Surface(color = FigmaSuccessGreen.copy(alpha = 0.1f), shape = RoundedCornerShape(5.dp)) {
                Text(text = "АКТУАЛИЗИРОВАН", color = FigmaSuccessGreen, fontSize = 10.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp))
            }
        }
    }
}

@Composable
fun ProfileTextField(label: String, value: String, onValueChange: (String) -> Unit) {
    Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
        Text(text = label, color = FigmaTextLight, fontSize = 14.sp)
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = FigmaBrandBlue,
                unfocusedBorderColor = FigmaLineColor
            )
        )
    }
}

data class PhoneData(val number: String, val isPrimary: Boolean, val isActualized: Boolean)
