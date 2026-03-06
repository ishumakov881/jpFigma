package com.walhalla.jpfigma.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.walhalla.jpfigma.ui.components.MessageData
import com.walhalla.jpfigma.ui.components.MessagesScreenBody
import com.walhalla.jpfigma.ui.model.MockData
import com.walhalla.jpfigma.ui.theme.JpFigmaTheme

@Composable
fun MessagesScreen() {
    val title = MockData.MessagesScreen.title
    val messages = MockData.MessagesScreen.items.map {
        MessageData(
            date = it.date,
            content = it.content,
            title = it.title,
            hasIcon = it.hasIcon,
            moreLinkText = it.moreLinkText
        )
    }

    MessagesScreenBody(
        title = title,
        messages = messages,
        onMoreClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun MessagesScreenPreview() {
    JpFigmaTheme {
        MessagesScreen()
    }
}
