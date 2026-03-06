package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun NewsScreenBody(
    modifier: Modifier = Modifier,
    title: String,
    featuredNews: List<NewsCardData>,
    otherNews: List<NewsListData>,
    onMoreClick: () -> Unit = {}
) {
    val backgroundColor = Color(0xFFF4F7FB)
    val cardPadding = 20.dp

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor),
        contentPadding = PaddingValues(cardPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        item {
            Text(
                text = title,
                color = TitleColor,
                fontSize = 22.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
            )
        }

        items(featuredNews) { news ->
            NewsCard(
                date = news.date,
                title = news.title,
                imageUrl = news.imageUrl,
                hasDot = news.hasDot
            )
        }

        item {
            Spacer(modifier = Modifier.height(10.dp))
            
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                color = Color.White
            ) {
                Column(
                    modifier = Modifier.padding(cardPadding),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    otherNews.forEachIndexed { index, news ->
                        NewsListItem(
                            date = news.date,
                            title = news.title,
                            hasDot = news.hasDot
                        )
                        
                        if (index < otherNews.size - 1) {
                            HorizontalDivider(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 5.dp),
                                thickness = 1.dp,
                                color = LineColor
                            )
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(20.dp))
                    
                    MoreButton(onClick = onMoreClick)
                }
            }
        }
    }
}

data class NewsCardData(
    val date: String,
    val title: String,
    val imageUrl: String? = null,
    val hasDot: Boolean = false
)

data class NewsListData(
    val date: String,
    val title: String,
    val hasDot: Boolean = false
)
