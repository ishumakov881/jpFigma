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
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(FigmaBackgroundGray),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                text = title,
                color = FigmaTitleColor,
                fontSize = 22.sp,
                modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp)
            )
        }

        item {
            AccountCard(
                title = "Платные услуги",
                gradient = FigmaBlueGradient,
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
                            HorizontalDivider(color = FigmaLineColor)
                        }
                    }
                }
            }
        }

        item {
            AccountCard(
                title = "Бесплатные услуги",
                gradient = FigmaBlueGradient,
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
                            HorizontalDivider(color = FigmaLineColor)
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
            Text(text = name, color = FigmaTextPrimary, fontSize = 16.sp)
            if (statusText != null) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                    if (isActive) {
                        Icon(Icons.Default.Check, contentDescription = null, tint = FigmaSuccessGreen, modifier = Modifier.size(18.dp))
                        Text(text = statusText, color = FigmaSuccessGreen, fontSize = 14.sp)
                    } else if (isNotAvailable) {
                        Icon(Icons.Default.Close, contentDescription = null, tint = FigmaErrorRed, modifier = Modifier.size(18.dp))
                        Text(text = statusText, color = FigmaTextLight, fontSize = 14.sp)
                    } else if (isNotConnected) {
                        Text(text = statusText, color = FigmaTextLight, fontSize = 14.sp)
                    }
                }
            }
        }

        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            IconButton(
                onClick = onInfoClick,
                modifier = Modifier.size(40.dp),
                colors = IconButtonDefaults.iconButtonColors(containerColor = FigmaFilterUnselectedBg)
            ) {
                Icon(Icons.AutoMirrored.Outlined.HelpOutline, contentDescription = null, tint = FigmaTextHint)
            }

            OutlinedIconButton(
                onClick = onActionClick,
                modifier = Modifier.size(40.dp),
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(1.dp, if (canOpen) FigmaBrandBlue else FigmaBrandBlue.copy(alpha = 0.3f))
            ) {
                Icon(
                    imageVector = if (isFree) Icons.Outlined.Settings else Icons.AutoMirrored.Outlined.ArrowForward,
                    contentDescription = null,
                    tint = if (canOpen) FigmaBrandBlue else FigmaBrandBlue.copy(alpha = 0.3f)
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
