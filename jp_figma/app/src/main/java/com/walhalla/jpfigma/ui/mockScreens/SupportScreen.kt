package com.walhalla.jpfigma.ui.mockScreens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.walhalla.jpfigma.ui.components.SupportScreenBody
import com.walhalla.jpfigma.ui.model.MockData

@Composable
fun SupportScreen() {
    val data = MockData.SupportScreen
    SupportScreenBody(
        phones = data.phones,
        messengers = data.messengers,
        chatMessages = data.chatMessages,
        onInternetCallClick = {},
        onCallbackClick = {},
        onSendMessageClick = {},
        onShowMoreMessagesClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun SupportScreenPreview() {
    SupportScreen()
}
