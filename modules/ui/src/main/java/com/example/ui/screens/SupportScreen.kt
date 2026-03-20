package com.example.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app.mockScreens.SupportMockData
import com.example.app.mockScreens.SupportMockState
import com.example.ui.components.SocialIconButton
import com.example.ui.components.SupportHeader
import com.example.ui.theme.JpFigmaTheme

@Composable
fun SupportScreen() {
    val mockData = SupportMockData.defaultState
    SupportScreenBody(
        state = mockData,
        onFacebookClick = {},
        onTelegramClick = {},
        onVkClick = {},
        onPhoneClick = {}
    )
}

@Composable
fun SupportScreenBody(
    state: SupportMockState,
    onFacebookClick: () -> Unit,
    onTelegramClick: () -> Unit,
    onVkClick: () -> Unit,
    onPhoneClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        SupportHeader(title = state.title)
        
        Spacer(modifier = Modifier.height(24.dp))
        
        Text(text = "Связаться с нами", style = MaterialTheme.typography.titleMedium)
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SocialIconButton(
                imageUrl = state.facebookUrl,
                contentDescription = "Facebook",
                onClick = onFacebookClick
            )
            SocialIconButton(
                imageUrl = state.telegramUrl,
                contentDescription = "Telegram",
                onClick = onTelegramClick
            )
            SocialIconButton(
                imageUrl = state.vkUrl,
                contentDescription = "VK",
                onClick = onVkClick
            )
            SocialIconButton(
                imageUrl = state.phoneUrl,
                contentDescription = "Phone",
                onClick = onPhoneClick
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SupportScreenPreview() {
    JpFigmaTheme {
        SupportScreen()
    }
}
