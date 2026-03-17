package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.R
import com.walhalla.jpfigma.ui.model.*
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun ChangeTariffScreenBody(
    tariffs: List<TariffInfo>,
    importantInfo: List<String>,
    localNetworkItems: List<NetworkInfoItem>,
    localNetworkRules: List<String>,
    additionalChanges: List<NetworkInfoItem>,
    extraServices: List<String>,
    modifier: Modifier = Modifier,
    onTariffOrderClick: (TariffInfo) -> Unit = {},
    onTariffDetailsClick: (TariffInfo) -> Unit = {}
) {
    val scrollState = rememberScrollState()
    val filterOptions = listOf("Интернет", "Интернет и ТВ", "ТВ")
    var selectedFilter by remember { mutableStateOf(filterOptions[1]) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(FigmaBackgroundGray)
            .verticalScroll(scrollState)
            .padding(vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        ScreenHeader(title = "Сменить тариф")

        // Filters (Static categories)
        Row(
            modifier = Modifier.padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            filterOptions.forEach { option ->
                val isSelected = option == selectedFilter
                Box(
                    modifier = Modifier
                        .height(40.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(if (isSelected) FigmaFilterSelectedBg else FigmaFilterUnselectedBg)
                        .clickable { selectedFilter = option }
                        .padding(horizontal = 15.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = option,
                        color = if (isSelected) FigmaBrandBlue else FigmaTextPrimary,
                        fontSize = 15.sp
                    )
                }
            }
        }

        // Tariff Cards
        Column(
            modifier = Modifier.padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            tariffs.forEach { tariff ->
                TariffCard(
                    tariff = tariff,
                    onOrderClick = { onTariffOrderClick(tariff) },
                    onDetailsClick = { onTariffDetailsClick(tariff) }
                )
            }
        }

        // Important Info List
        Column(
            modifier = Modifier.padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            importantInfo.forEach { info ->
                BulletListItem(text = info)
            }
            Row(
                modifier = Modifier.padding(top = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.Top
            ) {
                FigmaImage(model = R.drawable.ic_warning, modifier = Modifier.size(24.dp))
                Text(
                    text = "Максимальная скорость может быть ограничена техническими параметрами и возможностями используемого клиентского оборудования",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = FigmaTextPrimary,
                    lineHeight = 18.2.sp
                )
            }
        }

        // Local Network Section
        Column(
            modifier = Modifier.padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(text = "Локальная сеть", fontSize = 18.sp, color = FigmaTitleColor)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(30.dp))
                    .background(Color(0xFFDFECF8))
            ) {
                FigmaCard(cornerRadius = 30.dp) {
                    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                        localNetworkItems.forEach { item ->
                            NetworkItemRow(item)
                        }
                    }
                }
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    localNetworkRules.forEach { rule ->
                        BulletListItem(text = rule)
                    }
                }
            }
        }

        // Additional Section
        Column(
            modifier = Modifier.padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(text = "Дополнительно", fontSize = 18.sp, color = FigmaTitleColor)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(30.dp))
                    .background(Color(0xFFDFECF8))
            ) {
                FigmaCard(cornerRadius = 30.dp) {
                    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                        additionalChanges.forEachIndexed { index, item ->
                            Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                                FigmaImage(
                                    model = if (index == 0) R.drawable.icons_1 else R.drawable.icons_2,
                                    modifier = Modifier.size(60.dp)
                                )
                                NetworkItemRow(item, modifier = Modifier.weight(1f))
                            }
                        }
                    }
                }
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    extraServices.forEach { service ->
                        BulletListItem(text = service)
                    }
                }
            }
        }
    }
}

@Composable
fun TariffCard(
    tariff: TariffInfo,
    onOrderClick: () -> Unit,
    onDetailsClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(FigmaCardWhite)
            .border(
                width = if (tariff.isCurrent) 0.dp else 1.dp,
                color = if (tariff.isCurrent) Color.Transparent else FigmaLineColor,
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 80.dp, bottom = 20.dp, start = 10.dp, end = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // Metrics
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                TariffMetricItem(
                    iconRes = 0, 
                    label = "Скорость Интернет",
                    value = tariff.internetSpeed,
                    unit = tariff.internetSpeedLabel,
                    modifier = Modifier.weight(1f)
                )
                TariffMetricItem(
                    iconRes = R.drawable.ic_tariff_tv,
                    label = "Кабельное ТВ",
                    value = tariff.tvChannels,
                    unit = tariff.tvChannelsLabel,
                    modifier = Modifier.weight(1f)
                )
                TariffMetricItem(
                    iconRes = R.drawable.ic_tariff_hyper,
                    label = "Услуга “Гипер”",
                    value = if (tariff.isHyperAvailable) "Доступна" else "Не доступна",
                    unit = "",
                    valueColor = if (tariff.isHyperAvailable) FigmaBrandBlue else Color(0xFFA7B9CC),
                    modifier = Modifier.weight(1f)
                )
            }

            HorizontalDivider(color = FigmaLineColor, thickness = 1.dp)

            // Price and Button
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Row(verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                    Text(text = tariff.price, fontSize = 24.sp, fontWeight = FontWeight.Medium, color = FigmaBrandBlue)
                    Text(text = tariff.pricePeriod, fontSize = 14.sp, color = FigmaTextSecondary, modifier = Modifier.padding(bottom = 4.dp))
                }
                
                if (!tariff.isCurrent) {
                    OutlinedButton(
                        onClick = onOrderClick,
                        modifier = Modifier.fillMaxWidth().height(40.dp),
                        border = BorderStroke(1.dp, FigmaBrandBlue),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Text(text = "Заказать", color = FigmaBrandBlue, fontSize = 15.sp)
                    }
                }

                Row(
                    modifier = Modifier.clickable { onDetailsClick() },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Text(
                        text = "Подробнее о тарифе",
                        color = FigmaBrandBlue,
                        fontSize = 14.sp,
                        textDecoration = TextDecoration.Underline
                    )
                    FigmaImage(model = R.drawable.ic_details_blue, modifier = Modifier.size(24.dp))
                }
            }
        }

        // Top Banner
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(66.dp)
                .clip(RoundedCornerShape(bottomEnd = 30.dp))
                .background(if (tariff.isCurrent) FigmaBrandBlue else FigmaCardWhite)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                if (tariff.isCurrent) {
                    Text(text = "Текущий тариф", color = White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }
                Text(
                    text = tariff.name,
                    color = if (tariff.isCurrent) White else FigmaBrandBlue,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            if (tariff.isCurrent) {
                Box(modifier = Modifier.align(Alignment.BottomStart).fillMaxWidth().height(4.dp).background(Color(0xFF179AFF)))
            } else {
                Box(modifier = Modifier.align(Alignment.BottomStart).fillMaxWidth().height(1.dp).background(FigmaBrandBlue))
            }
        }
    }
}

@Composable
fun TariffMetricItem(
    iconRes: Int,
    label: String,
    value: String,
    unit: String,
    valueColor: Color = FigmaBrandBlue,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Box(modifier = Modifier.size(44.dp).background(FigmaBackgroundGray, RoundedCornerShape(22.dp)), contentAlignment = Alignment.Center) {
            if (iconRes != 0) {
                FigmaImage(model = iconRes, modifier = Modifier.size(24.dp))
            }
        }
        
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(5.dp)) {
            Text(text = label, fontSize = 13.sp, color = FigmaTextSecondary, textAlign = TextAlign.Center)
            Row(verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.spacedBy(2.dp)) {
                Text(text = value, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = valueColor)
                if (unit.isNotEmpty()) {
                    Text(text = unit, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = valueColor)
                }
            }
        }
    }
}

@Composable
fun NetworkItemRow(item: NetworkInfoItem, modifier: Modifier = Modifier) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(5.dp)) {
        Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
            Text(text = item.title, fontSize = 16.sp, fontWeight = FontWeight.Medium, color = FigmaTitleColor)
            Text(text = item.description, fontSize = 14.sp, color = FigmaTextPrimary)
        }
        Text(
            text = item.priceLabel,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = if (item.isFree) FigmaBrandOrange else FigmaBrandBlue
        )
    }
}
