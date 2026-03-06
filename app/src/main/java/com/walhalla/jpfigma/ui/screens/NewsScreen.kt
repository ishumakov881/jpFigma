package com.walhalla.jpfigma.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.walhalla.jpfigma.ui.components.NewsCardData
import com.walhalla.jpfigma.ui.components.NewsListData
import com.walhalla.jpfigma.ui.components.NewsScreenBody
import com.walhalla.jpfigma.ui.model.MockData
import com.walhalla.jpfigma.ui.theme.JpFigmaTheme

@Composable
fun NewsScreen() {
    val title = MockData.NewsScreen.title
    val featured = MockData.NewsScreen.featured.map {
        NewsCardData(it.date, it.title, it.imageUrl, it.hasDot)
    }
    val other = MockData.NewsScreen.other.map {
        NewsListData(it.date, it.title, it.hasDot)
    }

    NewsScreenBody(
        title = title,
        featuredNews = featured,
        otherNews = other,
        onMoreClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun NewsScreenPreview() {
    JpFigmaTheme {
        NewsScreen()
    }
}
