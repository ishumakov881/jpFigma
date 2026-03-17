package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.model.*
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun MessagesScreenBody(
    messages: List<MessageData>,
    modifier: Modifier = Modifier,
    onMessageClick: (MessageData) -> Unit = {}
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
        Text(
            text = "Сообщения",
            color = FigmaTitleColor,
            fontSize = 22.sp,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        FigmaCard(modifier = Modifier.padding(horizontal = 20.dp)) {
            messages.forEachIndexed { index, message ->
                MessageItem(
                    data = message,
                    onClick = { onMessageClick(message) }
                )
                if (index < messages.size - 1) {
                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 15.dp),
                        thickness = 1.dp,
                        color = FigmaLineColor
                    )
                }
            }
        }
    }
}

@Composable
fun MessageItem(
    data: MessageData,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(text = data.date, color = FigmaTextSecondary, fontSize = 12.sp)
            if (data.hasIcon) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(FigmaBrandOrange)
                )
            }
        }
        
        if (data.title != null) {
            Text(
                text = data.title,
                color = FigmaTitleColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
        
        Text(
            text = data.content,
            color = FigmaTextPrimary,
            fontSize = 14.sp,
            lineHeight = 18.2.sp
        )
        
        if (data.moreLinkText != null) {
            Text(
                text = data.moreLinkText,
                color = FigmaBrandBlue,
                fontSize = 14.sp,
                textDecoration = TextDecoration.Underline
            )
        }
    }
}

data class MessageData(
    val date: String,
    val content: String,
    val title: String? = null,
    val hasIcon: Boolean = false,
    val moreLinkText: String? = null
)
