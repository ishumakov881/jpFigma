package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.model.AppScreen
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun AppDrawer(
    modifier: Modifier = Modifier,
    currentScreen: AppScreen,
    onScreenSelected: (AppScreen) -> Unit
) {
    ModalDrawerSheet(
        modifier = modifier.width(300.dp),
        drawerShape = RoundedCornerShape(topEnd = 25.dp, bottomEnd = 25.dp),
        drawerContainerColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 10.dp)
                .verticalScroll(rememberScrollState())
        ) {
            AppScreen.values().forEach { screen ->
                NavigationItem(
                    screen = screen,
                    isSelected = screen == currentScreen,
                    counter = when(screen) {
                        AppScreen.SUPPORT -> 2
                        AppScreen.MESSAGES -> 16
                        else -> null
                    },
                    hasDot = screen == AppScreen.NEWS,
                    onClick = { onScreenSelected(screen) }
                )
            }
        }
    }
}

@Composable
private fun NavigationItem(
    screen: AppScreen,
    isSelected: Boolean,
    counter: Int? = null,
    hasDot: Boolean = false,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clickable(onClick = onClick)
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        // Placeholder for Icon
        Surface(
            modifier = Modifier.size(20.dp),
            color = if (isSelected) BrandColor1.copy(alpha = 0.2f) else Color.LightGray.copy(alpha = 0.3f)
        ) {}

        Text(
            text = screen.title,
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
            Canvas(modifier = Modifier.size(8.dp)) {
                drawCircle(color = BrandColor2)
            }
        }
    }
}
