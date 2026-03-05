package com.walhalla.jpfigma.ui.model

object MockData {
    fun getMessages() = listOf(
        Message(1, "03 фев. 2019", "Внимание", "23 августа 2025г. - санитарный день. Точки приёма платежей выходные. Оплатить можно будет онлайн или в терминалах. Техническая поддержка будет работать в штатном режиме.", true),
        Message(2, "03 фев. 2019", content = "Уважаемые абоненты компании ЛДС. Добавлен новый способ оплаты услуг - оплата услуг компании ЛДС в отделениях почты ЛНР.", hasIcon = true, moreLinkText = "Подробнее"),
        Message(3, "03 фев. 2019", content = "Уважаемые абоненты компании ЛДС."),
        Message(4, "03 фев. 2019", content = "Уважаемые абоненты компании ЛДС.")
    )

    fun getFeaturedNews() = listOf(
        NewsItem(
            1,
            "21 августа 2024",
            "Санитарный день 23/08/25",
            "https://www.figma.com/api/mcp/asset/3257da2c-e1ad-4381-b477-3a3f4d84437d",
            true
        ),
        NewsItem(
            2,
            "21 октября 2021",
            "Аккия! Получайте бонусы при подключении. До 1000 руб на Ваш счёт",
            "https://www.figma.com/api/mcp/asset/1c257877-cac0-476e-9b54-35b87b3dd0ad"
        )
    )

    fun getOtherNews() = listOf(
        NewsItem(3, "03 фев. 2019", "Профилактические работы.", hasDot = true),
        NewsItem(4, "03 фев. 2019", "Профилактические работы.", hasDot = true),
        NewsItem(5, "03 фев. 2019", "Профилактические работы.")
    )

    fun getPaymentMethods() = listOf(
        PaymentMethod(1, "Оплата через СБЕРБАНК", "Оплата услуг компнании ООО \"Луганские сети\" доступна через \"СберБанк\" с комиссией 1%"),
        PaymentMethod(2, "Оплата услуг ЛДС в отделениях почты ЛНР", "Вы можете пополнить счет в отделениях почты ЛНР.")
    )

    fun getPaymentPoints() = listOf(
        PaymentPoint(
            1, 
            "Пункт приёма платежей", 
            "кв. Жукова 4 Б/1, главный офис ЛДС", 
            listOf(
                ScheduleItem(listOf("ПН", "ВТ", "СР", "ЧТ", "ПТ", "СБ"), "с 9:00 до 18:00", "перерыв с 13:00 до 13:45"),
                ScheduleItem(listOf("ВС"), "выходной", isHoliday = true)
            ),
            imageUrl = "https://www.figma.com/api/mcp/asset/e76c7f92-d81b-48d1-81e5-2638909afa9c"
        ),
        PaymentPoint(
            2,
            "Информационный центр ЛДС",
            "ул. Королева, 78, ТЦ \"Каштан\", модуль возле с/м \"Лелека\"",
            listOf(
                ScheduleItem(listOf("ПН", "ВТ", "СР", "ЧТ", "ПТ", "СБ"), "с 9:00 до 18:00", "перерыв с 13:00 до 13:45"),
                ScheduleItem(listOf("ВС"), "выходной", isHoliday = true)
            ),
            imageUrl = "https://www.figma.com/api/mcp/asset/2072d5eb-44fc-404c-84a2-846ae59fad64"
        ),
        PaymentPoint(
            3,
            "Сервисный центр в пгт. Белореченский",
            "Луганская обл. Лутугинский р-н пгт.Белореченский ул.Ленина дом 13. Магазин Феникс-маркет",
            listOf(
                ScheduleItem(listOf("ПН", "ВТ", "СР", "ЧТ", "ПТ", "СБ"), "с 8:00 до 14:00", "без перерыва"),
                ScheduleItem(listOf("ВС"), "выходной", isHoliday = true)
            ),
            imageUrl = "https://www.figma.com/api/mcp/asset/8b222851-fb00-439e-b2fe-b70eeb060603"
        )
    )
}
