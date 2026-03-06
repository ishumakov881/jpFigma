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

}

data class NotificationItemData(
    val id: Int,
    val name: String,
    val price: String,
    val isEnabled: Boolean
)
