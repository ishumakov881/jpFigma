package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Payment
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.model.AccountInfo
import com.walhalla.jpfigma.ui.model.UserServicePackage
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun AccountCard(
    modifier: Modifier = Modifier,
    title: String,
    gradient: Brush,
    horizontalPadding: androidx.compose.ui.unit.Dp = 30.dp,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(gradient),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = title,
                    color = Color(0xFF041E37),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = horizontalPadding, vertical = 20.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                content()
            }
        }
    }
}

@Composable
fun InfoRow(
    label: String,
    value: String,
    isBold: Boolean = true
) {
    Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
        Text(text = label, color = SecondaryText, fontSize = 14.sp)
        Text(
            text = value,
            color = Text2,
            fontSize = 16.sp,
            fontWeight = if (isBold) FontWeight.Bold else FontWeight.Normal
        )
    }
}

@Composable
fun ServicePackageCard(
    modifier: Modifier = Modifier,
    servicePackage: UserServicePackage
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(15.dp)) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Оказываемая услуга", color = SecondaryText, fontSize = 14.sp, modifier = Modifier.weight(1f))
                Text(text = "Стоимость\nза 30 дней", color = SecondaryText, fontSize = 14.sp, textAlign = TextAlign.End)
            }
            
            HorizontalDivider(color = LineColor)

            servicePackage.services.forEach { service ->
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = service.name, color = Text2, fontSize = 14.sp)
                        if (service.hasOffer) {
                            Surface(
                                color = BrandColor2,
                                shape = RoundedCornerShape(5.dp),
                                modifier = Modifier.padding(top = 5.dp)
                            ) {
                                Text(
                                    text = "АКЦИЯ",
                                    color = Color.White,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                                )
                            }
                        }
                    }
                    Column(horizontalAlignment = Alignment.End) {
                        Text(text = "${service.price} ₽", color = Text2, fontSize = 14.sp)
                        if (service.oldPrice != null) {
                            Text(
                                text = "${service.oldPrice} ₽",
                                color = BrandColor2,
                                fontSize = 12.sp,
                                textDecoration = TextDecoration.LineThrough
                            )
                        }
                    }
                }
                HorizontalDivider(color = LineColor, modifier = Modifier.padding(vertical = 5.dp))
            }

            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Итого за 30 дней", color = Text2, fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
                if (servicePackage.oldTotalPrice != null) {
                    Text(
                        text = "${servicePackage.oldTotalPrice} ₽",
                        color = BrandColor2,
                        fontSize = 15.sp,
                        textDecoration = TextDecoration.LineThrough,
                        modifier = Modifier.padding(end = 10.dp)
                    )
                }
                Text(text = "${servicePackage.totalPrice} ₽", color = Text2, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}
