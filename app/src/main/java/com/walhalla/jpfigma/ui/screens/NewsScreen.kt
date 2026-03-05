package com.walhalla.jpfigma.ui.screens

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.components.MoreButton
import com.walhalla.jpfigma.ui.components.NewsCard
import com.walhalla.jpfigma.ui.components.NewsListItem
import com.walhalla.jpfigma.ui.model.NewsItem
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun NewsScreen(
    modifier: Modifier = Modifier,
    title: String = "Новости",
    featuredNews: List<NewsItem>,
    otherNews: List<NewsItem>,
    onMoreClick: () -> Unit = {}
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF4F7FB)),
        contentPadding = PaddingValues(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        item {
            // Title
            Text(
                text = title,
                color = TitleColor,
                fontSize = 22.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
            )
        }

        // Featured news cards
        items(featuredNews) { news ->
            NewsCard(news = news)
        }

        item {
            Spacer(modifier = Modifier.height(10.dp))
            
            // Other news card container
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                color = Color.White
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    otherNews.forEachIndexed { index, news ->
                        NewsListItem(news = news)
                        
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

@Preview(showBackground = true)
@Composable
fun NewsScreenPreview() {
    val demoFeatured = listOf(
        NewsItem(1, "21 августа 2024", "Санитарный день 23/08/25", "https://www.figma.com/api/mcp/asset/3257da2c-e1ad-4381-b477-3a3f4d84437d", true),
        NewsItem(2, "21 октября 2021", "Аккия! Получайте бонусы при подключении. До 1000 руб на Ваш счёт", "https://www.figma.com/api/mcp/asset/1c257877-cac0-476e-9b54-35b87b3dd0ad")
    )
    val demoOther = listOf(
        NewsItem(3, "03 фев. 2019", "Профилактические работы.", hasDot = true),
        NewsItem(4, "03 фев. 2019", "Профилактические работы.", hasDot = true),
        NewsItem(5, "03 фев. 2019", "Профилактические работы.")
    )
    
    JpFigmaTheme {
        NewsScreen(featuredNews = demoFeatured, otherNews = demoOther)
    }
}
