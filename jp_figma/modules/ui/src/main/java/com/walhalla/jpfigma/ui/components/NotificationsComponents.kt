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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.ui0.R as uiR

import com.walhalla.jpfigma.ui.theme.*

@Composable
fun NotificationsScreenBody(
    screenTitle: String,
    description: String,
    advantagesTitle: String,
    advantages: List<String>,
    warningTextPrefix: String,
    warningTextSuffix: String,
    settingsTitle: String,
    settingsGroups: List<SettingsGroup>,
    imgCheck: Int,
    imgWarning: Int,
    imgQuestion: Int,
    modifier: Modifier = Modifier
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
            text = screenTitle,
            color = FigmaTitleColor,
            fontSize = 22.sp,
            lineHeight = 24.2.sp,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        // Info Card Section
        InfoCard(
            description = description,
            advantagesTitle = advantagesTitle,
            advantages = advantages,
            warningTextPrefix = warningTextPrefix,
            warningTextSuffix = warningTextSuffix,
            imgCheck = imgCheck,
            imgWarning = imgWarning,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        // Settings Section
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(FigmaCardWhite)
        ) {
            SettingsHeader(title = settingsTitle)
            
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                settingsGroups.forEachIndexed { index, group ->
                    SettingsGroupBlock(
                        group = group,
                        imgCheck = imgCheck,
                        imgQuestion = imgQuestion,
                        imgNotAvailable = uiR.drawable.ic_not_available
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
fun InfoCard(
    description: String,
    advantagesTitle: String,
    advantages: List<String>,
    warningTextPrefix: String,
    warningTextSuffix: String,
    imgCheck: Int,
    imgWarning: Int,
    modifier: Modifier = Modifier
) {
    FigmaCard(
        modifier = modifier,
        cornerRadius = 30.dp,
        padding = 20.dp
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
            Text(
                text = description,
                color = FigmaTextPrimary,
                fontSize = 14.sp,
                lineHeight = 18.2.sp
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = advantagesTitle,
                    color = FigmaDarkTitle,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 20.sp
                )
                advantages.forEach { advantage ->
                    BulletListItem(text = advantage, iconRes = imgCheck, iconSize = 24.dp)
                }
            }

            WarningCard(
                prefix = warningTextPrefix,
                suffix = warningTextSuffix,
                imgWarning = imgWarning
            )
        }
    }
}

@Composable
fun WarningCard(
    prefix: String,
    suffix: String,
    imgWarning: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
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
            model = imgWarning,
            modifier = Modifier.size(48.dp)
        )
        Text(
            text = buildAnnotatedString {
                withStyle(SpanStyle(color = FigmaBrandOrange, fontWeight = FontWeight.SemiBold)) {
                    append(prefix)
                }
                withStyle(SpanStyle(color = FigmaTextPrimary)) {
                    append(suffix)
                }
            },
            fontSize = 14.sp,
            lineHeight = 18.2.sp,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun SettingsHeader(
    title: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(FigmaBlueGradient)
            .padding(horizontal = 20.dp, vertical = 15.dp)
    ) {
        Text(
            text = title,
            color = FigmaDarkTitle,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 22.5.sp
        )
    }
}

@Composable
fun SettingsGroupBlock(
    group: SettingsGroup,
    imgCheck: Int,
    imgQuestion: Int,
    imgNotAvailable: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
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
                SettingRow(
                    item = item,
                    imgCheck = imgCheck,
                    imgNotAvailable = imgNotAvailable,
                    imgQuestion = imgQuestion
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Button(
                onClick = { },
                modifier = Modifier
                    .width(200.dp)
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(containerColor = FigmaBrandBlue),
                shape = RoundedCornerShape(20.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = group.actionText,
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

@Composable
fun SettingRow(
    item: SettingItem,
    imgCheck: Int,
    imgNotAvailable: Int,
    imgQuestion: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        FigmaImage(
            model = if (item.isAvailable) imgCheck else imgNotAvailable,
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
            model = imgQuestion,
            modifier = Modifier.size(20.dp)
        )
    }
}
data class SettingsGroup(val title: String, val items: List<SettingItem>, val actionText: String, val price: String)
data class SettingItem(val text: String, val isAvailable: Boolean, val label: String? = null)
