package com.walhalla.jpfigma.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.components.*
import com.walhalla.jpfigma.ui.model.MockData
import com.walhalla.jpfigma.ui.theme.LineColor
import com.walhalla.jpfigma.ui.theme.TitleColor

@Composable
fun NotificationsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)) // Background for the whole screen
            .verticalScroll(rememberScrollState())
            .padding(vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // Screen Title
        Text(
            text = MockData.NotificationsScreen.screenTitle,
            color = TitleColor,
            fontSize = 22.sp,
            lineHeight = 24.2.sp,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        // Info Card Section
        InfoCard(
            description = MockData.NotificationsScreen.description,
            advantagesTitle = MockData.NotificationsScreen.advantagesTitle,
            advantages = MockData.NotificationsScreen.advantages,
            warningTextPrefix = MockData.NotificationsScreen.warningTextPrefix,
            warningTextSuffix = MockData.NotificationsScreen.warningTextSuffix,
            imgCheck = MockData.NotificationsScreen.imgCheck,
            imgWarning = MockData.NotificationsScreen.imgWarning,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        // Settings Section
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(Color.White)
        ) {
            SettingsHeader(title = MockData.NotificationsScreen.settingsTitle)
            
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                MockData.NotificationsScreen.settingsGroups.forEachIndexed { index, group ->
                    SettingsGroupBlock(
                        group = group,
                        imgCheck = MockData.NotificationsScreen.imgCheck,
                        imgNotAvailable = MockData.NotificationsScreen.imgNotAvailable,
                        imgQuestion = MockData.NotificationsScreen.imgQuestion
                    )
                    if (index < MockData.NotificationsScreen.settingsGroups.size - 1) {
                        HorizontalDivider(
                            modifier = Modifier.fillMaxWidth(),
                            thickness = 1.dp,
                            color = LineColor
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationsScreenPreview() {
    NotificationsScreen()
}
