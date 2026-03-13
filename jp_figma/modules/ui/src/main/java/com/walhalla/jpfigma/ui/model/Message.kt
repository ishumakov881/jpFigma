package com.walhalla.jpfigma.ui.model

data class Message(
    val id: Int,
    val date: String,
    val title: String? = null,
    val content: String,
    val hasIcon: Boolean = false,
    val moreLinkText: String? = null
)