package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun AppDrawer(
    modifier: Modifier = Modifier,
    menuItems: List<String>,
    selectedItem: String,
    onItemClick: (String) -> Unit
) {
    val drawerWidth = 300.dp
    val cornerRadius = 25.dp

    ModalDrawerSheet(
        modifier = modifier.width(drawerWidth),
        drawerShape = RoundedCornerShape(topEnd = cornerRadius, bottomEnd = cornerRadius),
        drawerContainerColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 10.dp)
                .verticalScroll(rememberScrollState())
        ) {
            menuItems.forEach { title ->
                NavigationItem(
                    title = title,
                    isSelected = title == selectedItem,
                    counter = when(title) {
                        "Техподдержка" -> 2
                        "Сообщения" -> 16
                        else -> null
                    },
                    hasDot = title == "Новости",
                    onClick = { onItemClick(title) }
                )
            }
        }
    }
}

@Composable
private fun NavigationItem(
    modifier: Modifier = Modifier,
    title: String,
    isSelected: Boolean,
    counter: Int? = null,
    hasDot: Boolean = false,
    onClick: () -> Unit
) {
    val itemHeight = 50.dp
    val horizontalPadding = 20.dp
    val iconSize = 20.dp
    val dotSize = 8.dp

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(itemHeight)
            .clickable(onClick = onClick)
            .padding(horizontal = horizontalPadding),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Surface(
            modifier = Modifier.size(iconSize),
            color = if (isSelected) BrandColor1.copy(alpha = 0.2f) else Color.LightGray.copy(alpha = 0.3f)
        ) {}

        Text(
            text = title,
            modifier = Modifier.weight(1f),
            color = if (isSelected) BrandColor1 else MenuText,
            fontSize = 15.sp
        )

        if (counter != null) {
            Surface(
                color = BrandColor2,
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = counter.toString(),
                    color = Color.White,
                    fontSize = 10.sp,
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 4.dp)
                )
            }
        }

        if (hasDot) {
            Canvas(modifier = Modifier.size(dotSize)) {
                drawCircle(color = BrandColor2)
            }
        }
    }
}
