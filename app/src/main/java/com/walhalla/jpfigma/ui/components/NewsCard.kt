package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.Canvas
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage

import com.walhalla.jpfigma.ui.model.NewsItem
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun NewsCard(
    modifier: Modifier = Modifier,
    news: NewsItem
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            // Image section
            if (news.imageUrl != null) {
                AsyncImage(
                    model = news.imageUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop
                )
            } else {
                // Placeholder if no image
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .background(LineColor, RoundedCornerShape(20.dp))
                )
            }

            // Content section
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Text(
                        text = news.date,
                        color = Text3,
                        fontSize = 14.sp
                    )
                    if (news.hasDot) {
                        Canvas(modifier = Modifier.size(8.dp)) {
                            drawCircle(color = Color(0xFFF04E23))
                        }
                    }
                }
                
                Text(
                    text = news.title,
                    color = Text1,
                    fontSize = 15.sp,
                    lineHeight = 19.sp,
                    maxLines = 3
                )
            }
        }
    }
}
