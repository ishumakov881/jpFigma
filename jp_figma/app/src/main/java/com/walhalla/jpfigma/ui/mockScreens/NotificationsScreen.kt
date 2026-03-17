package com.walhalla.jpfigma.ui.mockScreens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.walhalla.jpfigma.ui.components.NotificationsScreenBody
import com.walhalla.jpfigma.ui.model.MockData

@Composable
fun NotificationsScreen() {
    val data = MockData.NotificationsScreen
    NotificationsScreenBody(
        advantages = data.advantages,
        settingsGroups = data.settingsGroups,
        onActivateClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun NotificationsScreenPreview() {
    NotificationsScreen()
}
