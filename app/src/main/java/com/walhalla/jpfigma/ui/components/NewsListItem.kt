package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.model.NewsItem
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun NewsListItem(
    modifier: Modifier = Modifier,
    news: NewsItem
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(
                text = news.date,
                color = Text3,
                fontSize = 11.sp
            )
            if (news.hasDot) {
                Canvas(modifier = Modifier.size(8.dp)) {
                    drawCircle(color = Color(0xFFF04E23))
                }
            }
        }
        
        Text(
            text = news.title,
            color = Text2,
            fontSize = 14.sp,
            lineHeight = 18.sp,
            modifier = Modifier.padding(top = 5.dp)
        )
    }
}
