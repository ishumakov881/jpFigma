package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.R
import com.walhalla.jpfigma.ui.model.*
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun NotificationsScreenBody(
    advantages: List<String>,
    settingsGroups: List<SettingsGroup>,
    modifier: Modifier = Modifier,
    onActivateClick: (SettingsGroup) -> Unit = {}
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
        // Screen Title
        Text(
            text = "Услуга “Уведомления”",
            color = FigmaTitleColor,
            fontSize = 22.sp,
            lineHeight = 24.2.sp,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        // Info Card Section
        FigmaCard(
            modifier = Modifier.padding(horizontal = 20.dp),
            cornerRadius = 30.dp,
            padding = 20.dp
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                Text(
                    text = "Если Вы не хотите остаться без интернета в самый неподходящий момент, Вам необходима услуга «Уведомления». Эта услуга поможет вовремя пополнять счет, чтобы баланс не оказался отрицательным неожиданно для Вас. Данная информация будет высылаться выбранным вами способом.",
                    color = FigmaTextPrimary,
                    fontSize = 14.sp,
                    lineHeight = 18.2.sp
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "Преимущества уведомлений",
                        color = FigmaDarkTitle,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        lineHeight = 20.sp
                    )
                    advantages.forEach { advantage ->
                        BulletListItem(text = advantage, iconRes = R.drawable.ic_check, iconSize = 24.dp)
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = FigmaBrandOrange,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(15.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    FigmaImage(
                        model = R.drawable.ic_warning,
                        modifier = Modifier.size(48.dp)
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(SpanStyle(color = FigmaBrandOrange, fontWeight = FontWeight.SemiBold)) {
                                append("Услуга не подключена. ")
                            }
                            withStyle(SpanStyle(color = FigmaTextPrimary)) {
                                append("Если хотите воспользоваться услугой - выберите вариант уведомлений и нажмите кнопку “Активировать” в приведенной ниже таблице. Для подтверждения необходимо будет ввести пароль.")
                            }
                        },
                        fontSize = 14.sp,
                        lineHeight = 18.2.sp,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }

        // Settings Section
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(FigmaCardWhite)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(FigmaBlueGradient)
                    .padding(horizontal = 20.dp, vertical = 15.dp)
            ) {
                Text(
                    text = "Настройка услуги “Уведомления”",
                    color = FigmaDarkTitle,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 22.5.sp
                )
            }
            
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                settingsGroups.forEachIndexed { index, group ->
                    SettingsGroupBlock(
                        group = group,
                        onActivateClick = { onActivateClick(group) }
                    )
                    if (index < settingsGroups.size - 1) {
                        HorizontalDivider(
                            modifier = Modifier.fillMaxWidth(),
                            thickness = 1.dp,
                            color = FigmaLineColor
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SettingsGroupBlock(
    group: SettingsGroup,
    onActivateClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth().padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = group.title,
            color = FigmaTitleColor,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            group.items.forEach { item ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    FigmaImage(
                        model = if (item.isAvailable) R.drawable.ic_check else R.drawable.ic_not_available,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = item.text,
                        color = FigmaTitleColor,
                        fontSize = 14.sp,
                        modifier = Modifier.weight(1f)
                    )
                    if (item.label != null) {
                        Text(
                            text = item.label,
                            color = FigmaSuccessGreen,
                            fontSize = 14.sp
                        )
                    }
                    FigmaImage(
                        model = R.drawable.ic_question,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Button(
                onClick = onActivateClick,
                modifier = Modifier
                    .width(200.dp)
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(containerColor = FigmaBrandBlue),
                shape = RoundedCornerShape(20.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "Активировать",
                    color = FigmaCardWhite,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(
                text = group.price,
                color = FigmaTitleColor,
                fontSize = 16.sp
            )
        }
    }
}
