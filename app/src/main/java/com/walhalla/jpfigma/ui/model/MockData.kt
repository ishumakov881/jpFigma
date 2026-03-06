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

    fun getAccountInfo() = AccountInfo(
        status = "Активен",
        balance = "515.33",
        balanceUntil = "до 26 авг 2024г. включительно",
        tariffName = "Безлим 100+ и ТВ",
        accountNumber = "12345678",
        fullName = "Иванов А.А.",
        address = "г. Луганск, ул. 26 Бакинских коммисаров, 138",
        phone = "+7 (959) *** 22 06",
        internetStatus = "PPPOE подключено",
        macAddress = "F1:D3:34:45:A1:43",
        tvStatus = "Подключено"
    )

    fun getUserServicePackage() = UserServicePackage(
        packageName = "Безлим 100+ и ТВ",
        services = listOf(
            ServiceDetail("Доступ в сеть Интернет", "359"),
            ServiceDetail("Кабельное телевидение", "120", oldPrice = "150", hasOffer = true),
            ServiceDetail("Реальный IP", "120"),
            ServiceDetail("SMS оповещения", "30"),
            ServiceDetail("Локальная сеть", "0"),
            ServiceDetail("ЛДС почта", "0"),
            ServiceDetail("ЛДС Free Wi-Fi", "0")
        ),
        totalPrice = "619",
        oldTotalPrice = "649"
    )

    fun getSubscriberProfile() = SubscriberProfile(
        accountNumber = "12345678",
        fullName = "Иванов Александр Александрович",
        address = "г. Луганск, ул. 26 Бакинских коммисаров, 138",
        phones = listOf(
            PhoneInfo("+7 (959) 123 22 06", isPrimary = true, isActualized = true),
            PhoneInfo("+7 (959) 123 22 32", isActualized = true),
            PhoneInfo("+7 (959) 123 22 44", isActualized = false)
        )
    )

    fun getPaidServices() = listOf(
        ServiceInfo(1, "Тарифный план", "Безлим 100 и ТВ", ServiceStatusType.ACTIVE),
        ServiceInfo(2, "Гипер", "Не доступно на Вашем тарифе", ServiceStatusType.NOT_AVAILABLE, canOpen = false),
        ServiceInfo(3, "Реальный IP-адрес", "Не подключено", ServiceStatusType.NOT_CONNECTED),
        ServiceInfo(4, "Блокировка аккаунта", "Не активирована", ServiceStatusType.NOT_CONNECTED),
        ServiceInfo(5, "Уведомления", "Не подключено", ServiceStatusType.NOT_CONNECTED)
    )

    fun getFreeServices() = listOf(
        ServiceInfo(6, "Смена пароля", isFree = true),
        ServiceInfo(7, "Локальная сеть", statusType = ServiceStatusType.ACTIVE, isFree = true),
        ServiceInfo(8, "Почта", statusType = ServiceStatusType.ACTIVE, isFree = true),
        ServiceInfo(9, "Внутренняя телефонная сеть НАДОФОН", statusType = ServiceStatusType.ACTIVE, isFree = true),
        ServiceInfo(10, "FREE WI-FI", statusType = ServiceStatusType.ACTIVE, isFree = true)
    )



    fun getPaymentTransactions() = listOf(
        PaymentTransaction(1, "21 авг. 2024 14:20", "Пополнение через СБЕРБАНК", "1000", true, "1515.33"),
        PaymentTransaction(2, "01 авг. 2024 00:01", "Списание по тарифу \"Безлим 100+ и ТВ\"", "619", false, "515.33"),
        PaymentTransaction(3, "20 июл. 2024 10:15", "Пополнение (терминал)", "500", true, "1134.33"),
        PaymentTransaction(4, "01 июл. 2024 00:01", "Списание по тарифу \"Безлим 100+ и ТВ\"", "619", false, "634.33")
    )
}
