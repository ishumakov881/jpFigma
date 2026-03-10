package com.walhalla.jpfigma.ui.model

data class SupportPhone(
    val operators: List<String>,
    val number: String
)

data class MessengerLink(
    val type: String,
    val label: String
)

data class SupportChatMessage(
    val author: String,
    val timestamp: String,
    val content: String,
    val isOperator: Boolean,
    val status: String? = null
)
