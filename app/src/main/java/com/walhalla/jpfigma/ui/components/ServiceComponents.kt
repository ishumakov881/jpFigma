package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material.icons.automirrored.outlined.HelpOutline
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun ServicesScreenBody(
    modifier: Modifier = Modifier,
    title: String,
    paidServices: List<ServiceItemData>,
    freeServices: List<ServiceItemData>,
    onInfoClick: (Int) -> Unit = {},
    onActionClick: (Int) -> Unit = {}
) {
    val backgroundColor = Color(0xFFF4F7FB)
    val cardPadding = 20.dp

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor),
        contentPadding = PaddingValues(cardPadding),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
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
                title = "Платные услуги",
                gradient = Brush.linearGradient(listOf(Color(0xFFCCE6FF), Color(0xFF95C5F3))),
                horizontalPadding = 0.dp
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    paidServices.forEachIndexed { index, service ->
                        ServiceListItem(
                            name = service.name,
                            statusText = service.statusText,
                            isActive = service.isActive,
                            isNotAvailable = service.isNotAvailable,
                            isNotConnected = service.isNotConnected,
                            canOpen = service.canOpen,
                            isFree = service.isFree,
                            onInfoClick = { onInfoClick(service.id) },
                            onActionClick = { onActionClick(service.id) }
                        )
                        if (index < paidServices.size - 1) {
                            HorizontalDivider(color = LineColor)
                        }
                    }
                }
            }
        }

        item {
            AccountCard(
                title = "Бесплатные услуги",
                gradient = Brush.linearGradient(listOf(Color(0xFFCCE6FF), Color(0xFF95C5F3))),
                horizontalPadding = 0.dp
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    freeServices.forEachIndexed { index, service ->
                        ServiceListItem(
                            name = service.name,
                            statusText = service.statusText,
                            isActive = service.isActive,
                            isNotAvailable = service.isNotAvailable,
                            isNotConnected = service.isNotConnected,
                            canOpen = service.canOpen,
                            isFree = service.isFree,
                            onInfoClick = { onInfoClick(service.id) },
                            onActionClick = { onActionClick(service.id) }
                        )
                        if (index < freeServices.size - 1) {
                            HorizontalDivider(color = LineColor)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ServiceListItem(
    modifier: Modifier = Modifier,
    name: String,
    statusText: String? = null,
    isActive: Boolean = false,
    isNotAvailable: Boolean = false,
    isNotConnected: Boolean = false,
    canOpen: Boolean = true,
    isFree: Boolean = false,
    onInfoClick: () -> Unit = {},
    onActionClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(5.dp)) {
            Text(text = name, color = Text1, fontSize = 16.sp)
            if (statusText != null) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                    if (isActive) {
                        Icon(Icons.Default.Check, contentDescription = null, tint = Green, modifier = Modifier.size(18.dp))
                        Text(text = statusText, color = Green, fontSize = 14.sp)
                    } else if (isNotAvailable) {
                        Icon(Icons.Default.Close, contentDescription = null, tint = Color.Red, modifier = Modifier.size(18.dp))
                        Text(text = statusText, color = SecondaryText, fontSize = 14.sp)
                    } else if (isNotConnected) {
                        Text(text = statusText, color = SecondaryText, fontSize = 14.sp)
                    }
                }
            }
        }

        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            IconButton(
                onClick = onInfoClick,
                modifier = Modifier.size(40.dp),
                colors = IconButtonDefaults.iconButtonColors(containerColor = Color(0xFFE8F0F8))
            ) {
                Icon(Icons.AutoMirrored.Outlined.HelpOutline, contentDescription = null, tint = Color(0xFF8A9CAF))
            }

            OutlinedIconButton(
                onClick = onActionClick,
                modifier = Modifier.size(40.dp),
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(1.dp, if (canOpen) BrandColor1 else BrandColor1.copy(alpha = 0.3f))
            ) {
                Icon(
                    imageVector = if (isFree) Icons.Outlined.Settings else Icons.AutoMirrored.Outlined.ArrowForward,
                    contentDescription = null,
                    tint = if (canOpen) BrandColor1 else BrandColor1.copy(alpha = 0.3f)
                )
            }
        }
    }
}

data class ServiceItemData(
    val id: Int,
    val name: String,
    val statusText: String? = null,
    val isActive: Boolean = false,
    val isNotAvailable: Boolean = false,
    val isNotConnected: Boolean = false,
    val canOpen: Boolean = true,
    val isFree: Boolean = false
)
