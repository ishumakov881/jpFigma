package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage

import com.walhalla.jpfigma.ui.model.PaymentMethod
import com.walhalla.jpfigma.ui.model.PaymentPoint
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun PaymentMethodCard(
    modifier: Modifier = Modifier,
    method: PaymentMethod,
    onDetailClick: () -> Unit = {}
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        color = Color.White
    ) {
        Column(modifier = Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(15.dp)) {
            Text(text = method.title, color = TitleColor, fontSize = 20.sp)
            Row(horizontalArrangement = Arrangement.spacedBy(20.dp), verticalAlignment = Alignment.Top) {
                Text(
                    text = method.description,
                    modifier = Modifier.weight(1f),
                    color = Text2,
                    fontSize = 14.sp,
                    lineHeight = 18.sp
                )
                if (method.hasDetailButton) {
                    Button(
                        onClick = onDetailClick,
                        colors = ButtonDefaults.buttonColors(containerColor = SecondaryBtn),
                        shape = RoundedCornerShape(20.dp),
                        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp)
                    ) {
                        Text(text = "Детальнее", color = BrandColor1, fontSize = 15.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun PaymentPointCard(
    modifier: Modifier = Modifier,
    point: PaymentPoint
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        color = Color.White
    ) {
        Column(modifier = Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(15.dp)) {
            Text(text = point.title, color = TitleColor, fontSize = 20.sp)
            
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(text = "Адрес:", color = Text2, fontSize = 15.sp, fontWeight = FontWeight.Medium)
                Text(text = point.address, color = Text2, fontSize = 14.sp, lineHeight = 18.sp)
            }

            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(text = "График работы:", color = Text2, fontSize = 15.sp, fontWeight = FontWeight.Medium)
                point.schedule.forEach { item ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        // Days section
                        Column(
                            modifier = Modifier.width(intrinsicSize = IntrinsicSize.Min),
                            verticalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                                item.days.forEach { day ->
                                    Surface(
                                        modifier = Modifier.size(width = 36.dp, height = 20.dp),
                                        shape = RoundedCornerShape(5.dp),
                                        color = if (item.isHoliday) BrandColor2 else Color(0xFFF1F1F1)
                                    ) {
                                        Box(contentAlignment = Alignment.Center) {
                                            Text(
                                                text = day,
                                                color = if (item.isHoliday) Color.White else BrandColor1,
                                                fontSize = 13.sp
                                            )
                                        }
                                    }
                                }
                            }
                            // The blue line under days (only for working days)
                            if (!item.isHoliday) {
                                HorizontalDivider(
                                    thickness = 2.dp,
                                    color = BrandColor1,
                                    modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(1.dp))
                                )
                            }
                        }
                        
                        // Time section
                        Column {
                            Text(
                                text = item.time,
                                color = if (item.isHoliday) BrandColor2 else BrandColor1,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            if (item.breakTime != null) {
                                Text(text = item.breakTime, color = Text2, fontSize = 14.sp)
                            }
                        }
                    }
                }
            }

            if (point.imageUrl != null) {
                AsyncImage(
                    model = point.imageUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}
