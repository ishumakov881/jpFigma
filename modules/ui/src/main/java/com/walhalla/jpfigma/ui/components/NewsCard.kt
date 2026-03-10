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
import coil3.compose.SubcomposeAsyncImage
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun NewsCard(
    modifier: Modifier = Modifier,
    date: String,
    title: String,
    imageUrl: String? = null,
    hasDot: Boolean = false
) {
    val cardHeight = 120.dp
    val imageSize = 120.dp
    val borderRadius = 20.dp
    val dotSize = 8.dp

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(cardHeight),
        shape = RoundedCornerShape(borderRadius),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            if (imageUrl != null) {
                SubcomposeAsyncImage(
                    model = imageUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .size(imageSize)
                        .clip(RoundedCornerShape(borderRadius)),
                    contentScale = ContentScale.Crop,
                    loading = {
                        Box(
                            modifier = Modifier.fillMaxSize().background(LineColor),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(modifier = Modifier.size(24.dp))
                        }
                    },
                    error = {
                        Box(
                            modifier = Modifier.fillMaxSize().background(LineColor),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("!", color = Text3)
                        }
                    }
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(imageSize)
                        .background(LineColor, RoundedCornerShape(borderRadius))
                )
            }

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
                        text = date,
                        color = Text3,
                        fontSize = 14.sp
                    )
                    if (hasDot) {
                        Canvas(modifier = Modifier.size(dotSize)) {
                            drawCircle(color = Color(0xFFF04E23))
                        }
                    }
                }
                
                Text(
                    text = title,
                    color = Text1,
                    fontSize = 15.sp,
                    lineHeight = 19.sp,
                    maxLines = 3
                )
            }
        }
    }
}
