package com.walhalla.jpfigma.ui.mockScreens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.walhalla.jpfigma.ui.components.NewsCardData
import com.walhalla.jpfigma.ui.components.NewsListData
import com.walhalla.jpfigma.ui.components.NewsScreenBody
import com.walhalla.jpfigma.ui.model.MockData

@Composable
fun NewsScreen() {
    val data = MockData.NewsScreen
    val featured = data.featured.map {
        NewsCardData(it.date, it.title, it.imageUrl, it.hasDot)
    }
    val other = data.other.map {
        NewsListData(it.date, it.title, it.hasDot)
    }

    NewsScreenBody(
        featuredNews = featured,
        otherNews = other,
        onNewsClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun NewsScreenPreview() {
    NewsScreen()
}
