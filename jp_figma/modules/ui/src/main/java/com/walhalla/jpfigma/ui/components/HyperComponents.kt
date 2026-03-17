package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.R
import com.walhalla.jpfigma.ui.model.*
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun HyperScreenBody(
    serviceInfo: HyperServiceInfo,
    maxTariffParams: List<HyperParameter>,
    aboutItems: List<String>,
    modifier: Modifier = Modifier,
    onChangeSpeedClick: (Int) -> Unit = {}
) {
    val scrollState = rememberScrollState()
    var targetSpeed by remember { mutableStateOf(serviceInfo.targetSpeed) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(FigmaBackgroundGray)
            .verticalScroll(scrollState)
            .padding(vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        ScreenHeader(title = "Услуга “Гипер”")

        // Speedometer Control Card
        FigmaCard(modifier = Modifier.padding(horizontal = 20.dp), cornerRadius = 30.dp) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Box(modifier = Modifier.size(260.dp, 200.dp)) {
                    // Placeholder for Speedometer asset
                    FigmaImage(
                        model = "https://www.figma.com/api/mcp/asset/speedometer-full",
                        modifier = Modifier.fillMaxSize()
                    )
                }

                // Speed Controls
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SpeedControlAction(
                        label = "- 50",
                        unit = "Мбит/с",
                        iconRes = R.drawable.ic_minus_circle,
                        onClick = { targetSpeed = (targetSpeed - 50).coerceAtLeast(0) }
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    SpeedControlAction(
                        label = "+ 50",
                        unit = "Мбит/с",
                        iconRes = R.drawable.ic_plus_circle,
                        onClick = { targetSpeed += 50 },
                        isPositive = true
                    )
                }

                // Info Counters
                Row(
                    modifier = Modifier.width(200.dp),
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    InfoCounterItem(
                        label = "Скорость",
                        value = targetSpeed.toString(),
                        unit = "Мбит/с",
                        modifier = Modifier.weight(1f)
                    )
                    InfoCounterItem(
                        label = "Будет стоить",
                        value = serviceInfo.targetPrice.toString(),
                        unit = "₽/30 дней",
                        modifier = Modifier.weight(1f)
                    )
                }

                Button(
                    onClick = { onChangeSpeedClick(targetSpeed) },
                    modifier = Modifier.height(40.dp).padding(horizontal = 10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = FigmaBrandBlue),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(text = "Изменить скорость", color = FigmaCardWhite, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        // Parameters Card
        FigmaCard(modifier = Modifier.padding(horizontal = 20.dp), cornerRadius = 30.dp) {
            Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                Text(text = "Услуга доступна на максимальных тарифах", fontSize = 18.sp, color = FigmaTitleColor)
                
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    maxTariffParams.forEach { param ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = param.label, color = FigmaTextPrimary, fontSize = 14.sp)
                            DashedDivider(
                                modifier = Modifier.weight(1f).padding(horizontal = 5.dp),
                                color = FigmaLineColor
                            )
                            Text(text = param.value, color = FigmaBrandBlue, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }

                Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                    Text(text = "Стоимость за 1 шаг повышения", fontSize = 18.sp, color = FigmaTitleColor)
                    Text(text = "зависит от тарифа (\"Безлим 300\", \"Jump 200\", \"ЛДС-250\")", fontSize = 12.sp, color = FigmaTextSecondary)
                    
                    Row(modifier = Modifier.padding(top = 10.dp), verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "Ваш тариф ", color = FigmaTextPrimary, fontSize = 14.sp)
                        Text(text = serviceInfo.userTariff, color = FigmaTextPrimary, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        DashedDivider(
                            modifier = Modifier.weight(1f).padding(horizontal = 5.dp),
                            color = FigmaLineColor
                        )
                        Text(text = serviceInfo.stepPrice, color = FigmaBrandBlue, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }

        // About Card
        FigmaCard(modifier = Modifier.padding(horizontal = 20.dp), cornerRadius = 30.dp) {
            Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                Text(text = "Об услуге “Гипер”:", fontSize = 18.sp, color = FigmaTitleColor)
                
                Column(verticalArrangement = Arrangement.spacedBy(15.dp)) {
                    aboutItems.forEach { item ->
                        BulletListItem(text = item)
                    }
                    
                    WarningBox(
                        text = "Максимальная скорость может быть ограничена техническими параметрами и возможностями используемого клиентского оборудования",
                        iconRes = R.drawable.ic_warning
                    )
                }
            }
        }
    }
}

@Composable
fun SpeedControlAction(label: String, unit: String, iconRes: Int, onClick: () -> Unit, isPositive: Boolean = false) {
    Row(
        modifier = Modifier.clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        if (!isPositive) {
            Column(horizontalAlignment = Alignment.End) {
                Text(text = label, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = FigmaTextPrimary)
                Text(text = unit, fontSize = 14.sp, color = FigmaTextPrimary)
            }
            FigmaImage(model = iconRes, modifier = Modifier.size(40.dp))
        } else {
            FigmaImage(model = iconRes, modifier = Modifier.size(40.dp))
            Column(horizontalAlignment = Alignment.Start) {
                Text(text = label, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = FigmaTextPrimary)
                Text(text = unit, fontSize = 14.sp, color = FigmaTextPrimary)
            }
        }
    }
}

@Composable
fun InfoCounterItem(label: String, value: String, unit: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(5.dp)) {
        Text(text = label, fontSize = 13.sp, color = FigmaTextSecondary, textAlign = TextAlign.Center)
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = value, fontSize = 26.sp, fontWeight = FontWeight.Bold, color = FigmaBrandBlue)
            Text(text = unit, fontSize = 13.sp, fontWeight = FontWeight.Medium, color = FigmaTextPrimary)
        }
    }
}
