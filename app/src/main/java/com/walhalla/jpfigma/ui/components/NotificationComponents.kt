package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun NotificationsScreenBody(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    items: List<NotificationItemData>,
    onToggleItem: (Int, Boolean) -> Unit = { _, _ -> },
    onSaveClick: () -> Unit = {}
) {
    val backgroundColor = Color(0xFFF4F7FB)
    val cardPadding = 20.dp

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor),
        contentPadding = PaddingValues(cardPadding),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            Text(
                text = title,
                color = TitleColor,
                fontSize = 22.sp,
                modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp)
            )
        }

        item {
            AccountCard(
                title = "Описание услуги",
                gradient = Brush.linearGradient(listOf(Color(0xFFCCE6FF), Color(0xFF95C5F3)))
            ) {
                Text(
                    text = description,
                    color = Text2,
                    fontSize = 14.sp,
                    lineHeight = 20.sp
                )
            }
        }

        item {
            AccountCard(
                title = "Настройка уведомлений",
                gradient = Brush.linearGradient(listOf(Color(0xFFFFE4CC), Color(0xFFF3BD95))),
                horizontalPadding = 20.dp
            ) {
                items.forEachIndexed { index, item ->
                    NotificationSettingItem(
                        name = item.name,
                        price = item.price,
                        isEnabled = item.isEnabled,
                        onEnabledChange = { onToggleItem(item.id, it) }
                    )
                    
                    if (index < items.size - 1) {
                        HorizontalDivider(color = LineColor)
                    }
                }
            }
        }
        
        item {
            Button(
                onClick = onSaveClick,
                modifier = Modifier.fillMaxWidth().height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = BrandColor1),
                shape = RoundedCornerShape(25.dp)
            ) {
                Text(text = "Сохранить настройки", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

data class NotificationItemData(
    val id: Int,
    val name: String,
    val price: String,
    val isEnabled: Boolean
)
