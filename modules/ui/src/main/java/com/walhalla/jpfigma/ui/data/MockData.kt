package com.walhalla.jpfigma.ui.data

import com.walhalla.jpfigma.ui.offers.Offer

object MockData {
    object OffersScreen {
        val offers = listOf(
            Offer(
                imageUrl = "https://www.figma.com/api/mcp/asset/9e09e961-35c8-4638-9017-77dafff0c3a6",
                tag = "Бессрочно",
                title = "Подключи 2 услуги",
                description = "Получи скидку на интернет и бесплатное кабельное ТВ до 8ми месяцев"
            ),
            Offer(
                imageUrl = "https://www.figma.com/api/mcp/asset/28343cd5-42fa-41eb-9b52-7d2fa8b97e6a",
                tag = "Бессрочно",
                title = "Бери гигабит",
                description = "Получи скидку на интернет и бесплатное кабельное ТВ до 8ми месяцев"
            ),
            Offer(
                imageUrl = "https://www.figma.com/api/mcp/asset/61d88109-dc18-4ece-8f12-58b41aedf0d7",
                tag = "Бессрочно",
                title = "Приведи друга",
                description = "Получи скидку на интернет и бесплатное кабельное ТВ до 8ми месяцев"
            ),
            Offer(
                imageUrl = "https://www.figma.com/api/mcp/asset/987b56e3-c9b5-4305-a5e0-c26687d8d0a3",
                tag = "Бессрочно",
                title = "Бонус за друга",
                description = "Получи скидку на интернет и бесплатное кабельное ТВ до 8ми месяцев"
            )
        )
    }
}
