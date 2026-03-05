package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.HelpOutline
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.model.ServiceInfo
import com.walhalla.jpfigma.ui.model.ServiceStatusType
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun ServiceListItem(
    modifier: Modifier = Modifier,
    service: ServiceInfo,
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
            Text(text = service.name, color = Text1, fontSize = 16.sp)
            if (service.statusText != null) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                    when (service.statusType) {
                        ServiceStatusType.ACTIVE -> {
                            Icon(Icons.Default.Check, contentDescription = null, tint = Green, modifier = Modifier.size(18.dp))
                            Text(text = service.statusText, color = Green, fontSize = 14.sp)
                        }
                        ServiceStatusType.NOT_AVAILABLE -> {
                            Icon(Icons.Default.Close, contentDescription = null, tint = Color.Red, modifier = Modifier.size(18.dp))
                            Text(text = service.statusText, color = SecondaryText, fontSize = 14.sp)
                        }
                        ServiceStatusType.NOT_CONNECTED -> {
                            Text(text = service.statusText, color = SecondaryText, fontSize = 14.sp)
                        }
                        else -> {}
                    }
                }
            }
        }

        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            // Help/Info button
            IconButton(
                onClick = onInfoClick,
                modifier = Modifier.size(40.dp),
                colors = IconButtonDefaults.iconButtonColors(containerColor = Color(0xFFE8F0F8))
            ) {
                Icon(Icons.Outlined.HelpOutline, contentDescription = null, tint = Color(0xFF8A9CAF))
            }

            // Action button (Arrow or Settings)
            OutlinedIconButton(
                onClick = onActionClick,
                modifier = Modifier.size(40.dp),
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(1.dp, if (service.canOpen) BrandColor1 else BrandColor1.copy(alpha = 0.3f))
            ) {
                Icon(
                    imageVector = if (service.isFree) Icons.Outlined.Settings else Icons.Outlined.ArrowForward,
                    contentDescription = null,
                    tint = if (service.canOpen) BrandColor1 else BrandColor1.copy(alpha = 0.3f)
                )
            }
        }
    }
}
