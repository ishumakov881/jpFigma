package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.R
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun LinkAccountScreenBody(
    accountNumber: String,
    accountPassword: String,
    accountAlias: String,
    confirmPassword: String,
    isFullAccessRequested: Boolean,
    isPaidFromMainRequested: Boolean,
    modifier: Modifier = Modifier,
    onAccountNumberChange: (String) -> Unit = {},
    onAccountPasswordChange: (String) -> Unit = {},
    onAccountAliasChange: (String) -> Unit = {},
    onConfirmPasswordChange: (String) -> Unit = {},
    onFullAccessToggle: (Boolean) -> Unit = {},
    onPaidFromMainToggle: (Boolean) -> Unit = {},
    onLinkClick: () -> Unit = {},
    onCloseClick: () -> Unit = {}
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(FigmaCardWhite)
            .padding(20.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // Header with Close Icon
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Привязать аккаунт",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = FigmaTitleColor
            )
            IconButton(onClick = onCloseClick) {
                FigmaImage(model = R.drawable.ic_dialog_close, modifier = Modifier.size(24.dp))
            }
        }

        // Info Section
        Column(verticalArrangement = Arrangement.spacedBy(15.dp)) {
            Text(
                text = "\"Связанные аккаунты\" - удобное решение для управления несколькими лицевыми счетами.",
                fontSize = 14.sp, color = FigmaTextPrimary, lineHeight = 15.4.sp
            )
            Text(
                text = "Все счета в одном профиле: контролируйте баланс и оплачивайте быстро и просто.",
                fontSize = 14.sp, color = FigmaTextPrimary, lineHeight = 15.4.sp
            )
            Text(
                text = buildAnnotatedString {
                    append("Услуга “Связанные аккаунты” предоставляется ")
                    withStyle(SpanStyle(color = FigmaSuccessGreen, fontWeight = FontWeight.Bold)) {
                        append("бесплатно")
                    }
                },
                fontSize = 16.sp, color = FigmaTextPrimary
            )
        }

        // Form Section
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xFFF1F5F9))
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(
                    text = "Лицевой счет и пароль аккаунта, которым буду управлять:",
                    fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = FigmaTitleColor
                )
                LinkTextField(value = accountNumber, onValueChange = onAccountNumberChange, placeholder = "Лицевой счёт")
                LinkTextField(value = accountPassword, onValueChange = onAccountPasswordChange, placeholder = "Пароль", isPassword = true)
            }

            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(
                    text = buildAnnotatedString {
                        append("Придумайте название аккаунту ")
                        withStyle(SpanStyle(fontWeight = FontWeight.Normal)) {
                            append("(например: мама, бабушка или работа)")
                        }
                    },
                    fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = FigmaTitleColor
                )
                LinkTextField(value = accountAlias, onValueChange = onAccountAliasChange, placeholder = "Название аккаунта")
            }

            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                LinkCheckboxRow(
                    text = "Хочу получить полный доступ к аккаунту",
                    checked = isFullAccessRequested,
                    onCheckedChange = onFullAccessToggle
                )
                LinkCheckboxRow(
                    text = "Хочу оплачивать со своего лицевого счёта",
                    checked = isPaidFromMainRequested,
                    onCheckedChange = onPaidFromMainToggle
                )
            }
        }

        // Confirmation Section
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(
                text = "Для подтверждения введите Ваш пароль:",
                fontSize = 14.sp, color = FigmaTextPrimary
            )
            LinkTextField(value = confirmPassword, onValueChange = onConfirmPasswordChange, placeholder = "Введите пароль", isPassword = true)
        }

        Button(
            onClick = onLinkClick,
            modifier = Modifier.fillMaxWidth().height(40.dp),
            colors = ButtonDefaults.buttonColors(containerColor = FigmaBrandBlue),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(text = "Привязать", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun LinkTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    isPassword: Boolean = false
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth().height(48.dp),
        placeholder = { Text(text = placeholder, color = FigmaTextHint, fontSize = 15.sp) },
        shape = RoundedCornerShape(5.dp),
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = FigmaCardWhite,
            focusedContainerColor = FigmaCardWhite,
            unfocusedBorderColor = FigmaTextSecondary,
            focusedBorderColor = FigmaBrandBlue
        ),
        trailingIcon = if (isPassword) {
            { FigmaImage(model = R.drawable.ic_toolbar_messages, modifier = Modifier.size(24.dp)) } // Using placeholder for eye icon
        } else null
    )
}

@Composable
fun LinkCheckboxRow(
    text: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(checkedColor = FigmaBrandBlue)
        )
        Text(text = text, fontSize = 14.sp, color = FigmaTextPrimary, lineHeight = 15.4.sp)
    }
}
