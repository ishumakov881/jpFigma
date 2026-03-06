package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.model.ServiceStatusType
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
                            statusType = service.statusType,
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
                            statusType = service.statusType,
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

data class ServiceItemData(
    val id: Int,
    val name: String,
    val statusText: String? = null,
    val statusType: ServiceStatusType = ServiceStatusType.NONE,
    val canOpen: Boolean = true,
    val isFree: Boolean = false
)
