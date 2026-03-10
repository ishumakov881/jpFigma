package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun MessagesScreenBody(
    modifier: Modifier = Modifier,
    title: String,
    messages: List<MessageData>,
    onMoreClick: () -> Unit = {}
) {
    val backgroundColor = Color(0xFFF4F7FB)
    val cardPadding = 20.dp
    val spacingBetweenItems = 5.dp

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor),
        contentPadding = PaddingValues(cardPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                text = title,
                color = TitleColor,
                fontSize = 22.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp)
            )
        }

        item {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                color = Color.White
            ) {
                Column(
                    modifier = Modifier.padding(cardPadding),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    messages.forEachIndexed { index, message ->
                        MessageItem(
                            date = message.date,
                            content = message.content,
                            title = message.title,
                            hasIcon = message.hasIcon,
                            moreLinkText = message.moreLinkText
                        )
                        
                        if (index < messages.size - 1) {
                            HorizontalDivider(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = spacingBetweenItems),
                                thickness = 1.dp,
                                color = LineColor
                            )
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(20.dp))
                    
                    MoreButton(onClick = onMoreClick)
                }
            }
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
