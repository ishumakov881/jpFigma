package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun NewsScreenBody(
    featuredNews: List<NewsCardData>,
    otherNews: List<NewsListData>,
    modifier: Modifier = Modifier,
    onNewsClick: (Any) -> Unit = {}
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(FigmaBackgroundGray)
            .verticalScroll(scrollState)
            .padding(vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = "Новости",
            color = FigmaTitleColor,
            fontSize = 22.sp,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        // Featured News
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            featuredNews.forEach { item ->
                NewsCard(
                    data = item,
                    onClick = { onNewsClick(item) },
                    modifier = Modifier.weight(1f)
                )
            }
        }

        // Other News
        FigmaCard(modifier = Modifier.padding(horizontal = 20.dp)) {
            otherNews.forEachIndexed { index, item ->
                NewsListItem(
                    data = item,
                    onClick = { onNewsClick(item) }
                )
                if (index < otherNews.size - 1) {
                    HorizontalDivider(
                        color = FigmaLineColor,
                        modifier = Modifier.padding(vertical = 15.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun NewsCard(
    data: NewsCardData,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(FigmaCardWhite)
            .clickable { onClick() }
    ) {
        FigmaImage(
            model = data.imageUrl,
            modifier = Modifier.fillMaxWidth().height(120.dp),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(text = data.date, color = FigmaTextSecondary, fontSize = 12.sp)
            Text(
                text = data.title,
                color = FigmaTextPrimary,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 3,
                lineHeight = 18.2.sp
            )
        }
    }
}

@Composable
fun NewsListItem(
    data: NewsListData,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        verticalAlignment = Alignment.Top
    ) {
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(5.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(text = data.date, color = FigmaTextSecondary, fontSize = 12.sp)
                if (data.hasDot) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(FigmaBrandOrange)
                    )
                }
            }
            Text(
                text = data.title,
                color = FigmaTextPrimary,
                fontSize = 14.sp,
                lineHeight = 18.2.sp
            )
        }
    }
}

data class NewsCardData(val date: String, val title: String, val imageUrl: String, val hasDot: Boolean = false)
data class NewsListData(val date: String, val title: String, val hasDot: Boolean = false)
