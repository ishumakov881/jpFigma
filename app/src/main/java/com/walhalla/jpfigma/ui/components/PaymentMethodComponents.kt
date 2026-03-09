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
import coil3.compose.SubcomposeAsyncImage
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun PaymentScreenBody(modifier: Modifier = Modifier) {

}

@Composable
fun PaymentMethodCard(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    hasDetailButton: Boolean = true,
    onDetailClick: () -> Unit = {}
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        color = Color.White
    ) {
        Column(modifier = Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(15.dp)) {
            Text(text = title, color = TitleColor, fontSize = 20.sp)
            Row(horizontalArrangement = Arrangement.spacedBy(20.dp), verticalAlignment = Alignment.Top) {
                Text(
                    text = description,
                    modifier = Modifier.weight(1f),
                    color = Text2,
                    fontSize = 14.sp,
                    lineHeight = 18.sp
                )
                if (hasDetailButton) {
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
    title: String,
    address: String,
    imageUrl: String? = null,
    scheduleContent: @Composable ColumnScope.() -> Unit
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        color = Color.White
    ) {
        Column(modifier = Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(15.dp)) {
            Text(text = title, color = TitleColor, fontSize = 20.sp)
            
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(text = "Адрес:", color = Text2, fontSize = 15.sp, fontWeight = FontWeight.Medium)
                Text(text = address, color = Text2, fontSize = 14.sp, lineHeight = 18.sp)
            }

            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text(text = "График работы:", color = Text2, fontSize = 15.sp, fontWeight = FontWeight.Medium)
                scheduleContent()
            }

            if (imageUrl != null) {
                SubcomposeAsyncImage(
                    model = imageUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop,
                    loading = {
                        Box(modifier = Modifier.fillMaxSize().background(LineColor), contentAlignment = Alignment.Center) {
                            CircularProgressIndicator(modifier = Modifier.size(24.dp))
                        }
                    },
                    error = {
                        Box(modifier = Modifier.fillMaxSize().background(LineColor), contentAlignment = Alignment.Center) {
                            Text("Map Error", color = Text3)
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun ScheduleItemRow(
    modifier: Modifier = Modifier,
    days: List<String>,
    time: String,
    breakTime: String? = null,
    isHoliday: Boolean = false
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Column(
            modifier = Modifier.width(IntrinsicSize.Min),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
                days.forEach { day ->
                    Surface(
                        modifier = Modifier.size(width = 36.dp, height = 20.dp),
                        shape = RoundedCornerShape(5.dp),
                        color = if (isHoliday) BrandColor2 else Color(0xFFF1F1F1)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text(
                                text = day,
                                color = if (isHoliday) Color.White else BrandColor1,
                                fontSize = 13.sp
                            )
                        }
                    }
                }
            }
            if (!isHoliday) {
                HorizontalDivider(
                    thickness = 2.dp,
                    color = BrandColor1,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        
        Column(modifier = Modifier.padding(start = 2.dp)) {
            Text(
                text = time,
                color = if (isHoliday) BrandColor2 else BrandColor1,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            if (breakTime != null) {
                Text(
                    text = breakTime,
                    color = Text2,
                    fontSize = 14.sp
                )
            }
        }
    }
}
