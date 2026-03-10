package com.walhalla.jpfigma.ui.model

data class NewsItem(
    val id: Int,
    val date: String,
    val title: String,
    val imageUrl: String? = null,
    val hasDot: Boolean = false
)