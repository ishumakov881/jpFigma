package com.walhalla.jpfigma.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.components.MessageItem
import com.walhalla.jpfigma.ui.components.MoreButton
import com.walhalla.jpfigma.ui.model.Message
import com.walhalla.jpfigma.ui.model.MockData
import com.walhalla.jpfigma.ui.theme.*

/**
 * Screen displaying a list of messages within a card.
 *
 * @param modifier The modifier to be applied to the layout.
 * @param title The title of the screen.
 * @param messages The list of messages to display.
 * @param onMoreClick Callback when the "More" button is clicked.
 */
@Composable
fun MessagesScreen(
    modifier: Modifier = Modifier,
    title: String = "Сообщения",
    onMoreClick: () -> Unit = {}
) {
    val messages = MockData.getMessages()
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF4F7FB)),
        contentPadding = PaddingValues(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            // Title section
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
            // Main content card
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                color = Color.White
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    messages.forEachIndexed { index, message ->
                        MessageItem(message = message)
                        
                        // Divider between items
                        if (index < messages.size - 1) {
                            HorizontalDivider(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 5.dp),
                                thickness = 1.dp,
                                color = LineColor
                            )
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(20.dp))
                    
                    // Footer button
                    MoreButton(onClick = onMoreClick)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MessagesScreenPreview() {
    JpFigmaTheme {
        MessagesScreen(

        )
    }
}
