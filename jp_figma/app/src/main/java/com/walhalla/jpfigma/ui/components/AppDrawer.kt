package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.model.AppScreen

import com.walhalla.ui0.R

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
fun NavigationItem(
    modifier: Modifier = Modifier,
    title: String,
    isSelected: Boolean,
    counter: Int? = null,
    hasDot: Boolean = false,
    onClick: () -> Unit
) {
    val itemHeight = 50.dp
    val horizontalPadding = 20.dp
    val iconSize = 24.dp
    val dotSize = 8.dp

    val iconRes = when (title) {
        AppScreen.MY_ACCOUNT.title -> R.drawable.ic_00
        AppScreen.PROFILE.title -> R.drawable.icons_1
        AppScreen.SERVICES.title -> R.drawable.icons_2
        AppScreen.NOTIFICATIONS.title -> R.drawable.icons_3
        AppScreen.LINKED_ACCOUNTS.title -> R.drawable.icons_4
        AppScreen.PAYMENT_METHODS.title -> R.drawable.icons_5
        AppScreen.PAYMENTS.title -> R.drawable.icons_6
        AppScreen.SUPPORT.title -> R.drawable.icons_7
        AppScreen.MESSAGES.title -> R.drawable.icons_8
        AppScreen.DOCUMENTS.title -> R.drawable.icons_9
        AppScreen.NEWS.title -> R.drawable.icons_10
        else -> R.drawable.ic_00
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(itemHeight)
            .clickable(onClick = onClick)
            .padding(horizontal = horizontalPadding),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(iconSize),
            tint = if (isSelected) BrandColor1 else Color(0xFF8A9CAF)
        )

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
