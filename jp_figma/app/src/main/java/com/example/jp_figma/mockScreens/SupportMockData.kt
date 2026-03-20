package com.example.app.mockScreens

data class SupportMockState(
    val title: String,
    val facebookUrl: String,
    val telegramUrl: String,
    val vkUrl: String,
    val phoneUrl: String
)

object SupportMockData {
    val defaultState = SupportMockState(
        title = "Поддержка",
        facebookUrl = "https://www.figma.com/api/mcp/asset/40ad61ce-8223-401a-970f-d89e859937fc",
        telegramUrl = "https://www.figma.com/api/mcp/asset/79b8ab17-729e-4042-aa2b-30492d9d6c48",
        vkUrl = "https://www.figma.com/api/mcp/asset/102e1ddf-32d7-42ad-a9f1-3221c55d841d",
        phoneUrl = "https://www.figma.com/api/mcp/asset/6b0f9bf6-fd56-4be4-aaf1-2dfce2e0bc85"
    )
}
