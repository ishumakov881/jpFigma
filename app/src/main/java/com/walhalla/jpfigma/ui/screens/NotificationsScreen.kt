package com.walhalla.jpfigma.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.components.AccountCard

import com.walhalla.jpfigma.ui.model.MockData
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun NotificationsScreen(
    modifier: Modifier = Modifier
) {
    val settings = MockData.getNotificationSettings()
    
    // State for toggles
    var smsEnabled by remember { mutableStateOf(false) }
    var emailEnabled by remember { mutableStateOf(false) }
    var telegramEnabled by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF4F7FB)),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            Text(
                text = "Услуга Уведомления",
                color = TitleColor,
                fontSize = 22.sp,
                modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp)
            )
        }

        // Description Card
        item {
            AccountCard(
                title = "Описание услуги",
                gradient = Brush.linearGradient(listOf(Color(0xFFCCE6FF), Color(0xFF95C5F3)))
            ) {
                Text(
                    text = "Услуга «Уведомления» позволяет получать оперативную информацию о состоянии Вашего лицевого счёта, проводимых технических работах и акциях.",
                    color = Text2,
                    fontSize = 14.sp,
                    lineHeight = 20.sp
                )
            }
        }

        // Settings Card
        item {
            AccountCard(
                title = "Настройка уведомлений",
                gradient = Brush.linearGradient(listOf(Color(0xFFFFE4CC), Color(0xFFF3BD95)))
            ) {
                settings.forEachIndexed { index, setting ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(
                                text = setting.name,
                                color = Text2,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                            if (setting.price != "0") {
                                Text(
                                    text = "${setting.price} ₽ / мес.",
                                    color = SecondaryText,
                                    fontSize = 13.sp
                                )
                            } else {
                                Text(
                                    text = "Бесплатно",
                                    color = Green,
                                    fontSize = 13.sp
                                )
                            }
                        }
                        
                        Switch(
                            checked = when(index) {
                                0 -> smsEnabled
                                1 -> emailEnabled
                                else -> telegramEnabled
                            },
                            onCheckedChange = { isChecked ->
                                when(index) {
                                    0 -> smsEnabled = isChecked
                                    1 -> emailEnabled = isChecked
                                    else -> telegramEnabled = isChecked
                                }
                            },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Color.White,
                                checkedTrackColor = BrandColor1,
                                uncheckedThumbColor = Color.White,
                                uncheckedTrackColor = Color.LightGray
                            )
                        )
                    }
                    
                    if (index < settings.size - 1) {
                        HorizontalDivider(color = LineColor, modifier = Modifier.padding(vertical = 10.dp))
                    }
                }
            }
        }
        
        item {
            Button(
                onClick = { /* Save Settings */ },
                modifier = Modifier.fillMaxWidth().height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = BrandColor1),
                shape = RoundedCornerShape(25.dp)
            ) {
                Text(text = "Сохранить настройки", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Preview
@Composable
fun NotificationsScreenPreview() {
    JpFigmaTheme {
        NotificationsScreen()
    }
}
