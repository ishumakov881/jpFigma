package com.walhalla.jpfigma.ui.screens

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.walhalla.jpfigma.ui.components.NotificationItemData
import com.walhalla.jpfigma.ui.components.NotificationsScreenBody
import com.walhalla.jpfigma.ui.model.MockData
import com.walhalla.jpfigma.ui.theme.JpFigmaTheme

@Composable
fun NotificationsScreen() {
    val title = MockData.NotificationsScreen.title
    val description = MockData.NotificationsScreen.description
    val initialItems = MockData.NotificationsScreen.items
    
    // Using local state for toggles in demo screen
    val itemsState = remember {
        mutableStateListOf(*initialItems.mapIndexed { index, it ->
            NotificationItemData(index, it.name, it.price, index == 0) // Default some enabled
        }.toTypedArray())
    }

    NotificationsScreenBody(
        title = title,
        description = description,
        items = itemsState,
        onToggleItem = { id, enabled ->
            val index = itemsState.indexOfFirst { it.id == id }
            if (index != -1) {
                itemsState[index] = itemsState[index].copy(isEnabled = enabled)
            }
        },
        onSaveClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun NotificationsScreenPreview() {
    JpFigmaTheme {
        NotificationsScreen()
    }
}
