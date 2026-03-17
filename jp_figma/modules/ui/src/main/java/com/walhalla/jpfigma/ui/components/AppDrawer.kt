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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun AppDrawerContent(
    menuItems: List<DrawerMenuItemData>,
    onItemClick: (DrawerMenuItemData) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .width(300.dp)
            .background(FigmaCardWhite)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(20.dp))
        
        menuItems.forEach { item ->
            DrawerMenuItem(
                data = item,
                onClick = { onItemClick(item) }
            )
        }
    }
}

@Composable
fun DrawerMenuItem(
    data: DrawerMenuItemData,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .clickable { onClick() }
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        FigmaImage(
            model = data.iconRes,
            modifier = Modifier.size(20.dp),
            tint = if (data.isSelected) FigmaBrandBlue else FigmaTextSecondary
        )
        
        Text(
            text = data.title,
            color = if (data.isSelected) FigmaBrandBlue else FigmaTextPrimary,
            fontSize = 15.sp,
            modifier = Modifier.weight(1f)
        )
        
        if (data.counter != null) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(FigmaBrandOrange)
                    .padding(horizontal = 6.dp, vertical = 2.dp)
            ) {
                Text(
                    text = data.counter,
                    color = FigmaCardWhite,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        
        if (data.hasNotificationDot) {
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(FigmaBrandOrange)
            )
        }
    }
}

data class DrawerMenuItemData(
    val title: String,
    val iconRes: Int,
    val isSelected: Boolean = false,
    val counter: String? = null,
    val hasNotificationDot: Boolean = false
)
