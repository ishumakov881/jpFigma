package com.walhalla.jpfigma.ui.mockScreens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.walhalla.jpfigma.ui.components.MessageData
import com.walhalla.jpfigma.ui.components.MessagesScreenBody
import com.walhalla.jpfigma.ui.model.MockData

@Composable
fun MessagesScreen() {
    val data = MockData.MessagesScreen
    val messages = data.items.map {
        MessageData(
            date = it.date,
            content = it.content,
            title = it.title,
            hasIcon = it.hasIcon,
            moreLinkText = it.moreLinkText
        )
    }
    MessagesScreenBody(
        messages = messages,
        onMessageClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun MessagesScreenPreview() {
    MessagesScreen()
}
