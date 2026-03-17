package com.walhalla.jpfigma.ui.model

import com.walhalla.jpfigma.R

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

    object MessagesScreen {
        val items = listOf(
            Message(1, "03 фев. 2019", "Внимание", "23 августа 2025г. - санитарный день. Точки приёма платежей выходные. Оплатить можно будет онлайн или в терминалах. Техническая поддержка будет работать в штатном режиме.", true),
            Message(2, "03 фев. 2019", content = "Уважаемые абоненты компании ЛДС. Добавлен новый способ оплаты услуг - оплата услуг компании ЛДС в отделениях почты ЛНР.", hasIcon = true, moreLinkText = "Подробнее"),
            Message(3, "03 фев. 2019", content = "Уважаемые абоненты компании ЛДС."),
            Message(4, "03 фев. 2019", content = "Уважаемые абоненты компании ЛДС.")
        )
    }

    object NewsScreen {
        val featured = listOf(
            NewsItem(1, "21 августа 2024", "Санитарный день 23/08/25", "https://www.figma.com/api/mcp/asset/3257da2c-e1ad-4381-b477-3a3f4d84437d", true),
            NewsItem(2, "21 октября 2021", "Аккия! Получайте бонусы при подключении. До 1000 руб на Ваш счёт", "https://www.figma.com/api/mcp/asset/1c257877-cac0-476e-9b54-35b87b3dd0ad")
        )
        val other = listOf(
            NewsItem(3, "03 фев. 2019", "Профилактические работы.", hasDot = true),
            NewsItem(4, "03 фев. 2019", "Профилактические работы.", hasDot = true),
            NewsItem(5, "03 фев. 2019", "Профилактические работы.")
        )
    }

    object AccountScreen {
        val account = AccountInfo(
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
        val packages = UserServicePackage(
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
    }

    object ProfileScreen {
        val profile = SubscriberProfile(
            accountNumber = "12345678",
            fullName = "Иванов Александр Александрович",
            address = "г. Луганск, ул. 26 Бакинских коммисаров, 138",
            phones = listOf(
                PhoneInfo("+7 (959) 123 22 06", isPrimary = true, isActualized = true),
                PhoneInfo("+7 (959) 123 22 32", isActualized = true),
                PhoneInfo("+7 (959) 123 22 44", isActualized = false)
            )
        )
    }

    object ServicesScreen {
        val title = "Услуги"
        val paid = listOf(
            ServiceInfo(1, "Тарифный план", "Безлим 100 и ТВ", ServiceStatusType.ACTIVE),
            ServiceInfo(2, "Гипер", "Не доступно на Вашем тарифе", ServiceStatusType.NOT_AVAILABLE, canOpen = false),
            ServiceInfo(3, "Реальный IP-адрес", "Не подключено", ServiceStatusType.NOT_CONNECTED),
            ServiceInfo(4, "Блокировка аккаунта", "Не активирована", ServiceStatusType.NOT_CONNECTED),
            ServiceInfo(5, "Уведомления", "Не подключено", ServiceStatusType.NOT_CONNECTED)
        )
        val free = listOf(
            ServiceInfo(6, "Смена пароля", isFree = true),
            ServiceInfo(7, "Локальная сеть", statusType = ServiceStatusType.ACTIVE, isFree = true),
            ServiceInfo(8, "Почта", statusType = ServiceStatusType.ACTIVE, isFree = true),
            ServiceInfo(9, "Внутренняя телефонная сеть НАДОФОН", statusType = ServiceStatusType.ACTIVE, isFree = true),
            ServiceInfo(10, "FREE WI-FI", statusType = ServiceStatusType.ACTIVE, isFree = true)
        )
    }

    object PaymentsScreen {
        val dateFrom = "1.05.2025"
        val dateTo = "20.05.2025"
        val transactions = listOf(
            PaymentTransaction(1, "01 дек 2025", "Абонплата", "-35.30", false),
            PaymentTransaction(2, "02 мая 2025", "Пополнение баланса", "1500.00", true, hasReceipt = true),
            PaymentTransaction(3, "02 мая 2025", "Абонплата", "-35.30", false),
            PaymentTransaction(4, "03 мая 2025", "Абонплата", "-35.30", false),
            PaymentTransaction(5, "04 мая 2025", "Абонплата", "-35.30", false),
            PaymentTransaction(6, "05 мая 2025", "Абонплата", "-35.30", false),
            PaymentTransaction(7, "06 мая 2025", "Абонплата", "-35.30", false),
            PaymentTransaction(8, "07 мая 2025", "Абонплата", "-35.30", false)
        )
        val balanceValue = "515.33"
        val balanceUntil = "Оплачено до 26 июня 2025г. включительно"
    }

    object NotificationsScreen {
        val advantages = listOf(
            "подписка на услугу доступна в Вашем личном кабинете;",
            "возможность выбора платного/бесплатного варианта услуги;",
            "Вы можете настроить параметры уведомлений так, как Вам удобно."
        )
        val settingsGroups = listOf(
            SettingsGroup(
                title = "SMS",
                items = listOf(
                    SettingItem("Наступление отрицательного баланса", isAvailable = true),
                    SettingItem("Достижение определённой суммы на Вашем балансе", isAvailable = false),
                    SettingItem("Предупреждение за 1 день до отключения", isAvailable = false),
                    SettingItem("Пополнение счёта", isAvailable = false),
                    SettingItem("Рекомендуемый платёж", isAvailable = false),
                    SettingItem("Восстановление пароля", isAvailable = true, label = "3 раза/30 дней")
                ),
                actionText = "Активировать",
                price = "бесплатно"
            ),
            SettingsGroup(
                title = "SMS Премиум",
                items = listOf(
                    SettingItem("Наступление отрицательного баланса", isAvailable = true),
                    SettingItem("Достижение определённой суммы на Вашем балансе", isAvailable = true),
                    SettingItem("Предупреждение за 1 день до отключения", isAvailable = true),
                    SettingItem("Пополнение счёта", isAvailable = true),
                    SettingItem("Рекомендуемый платёж", isAvailable = true),
                    SettingItem("Восстановление пароля", isAvailable = true, label = "3 раза/30 дней")
                ),
                actionText = "Активировать",
                price = "4,50 руб/30 дней"
            ),
            SettingsGroup(
                title = "Приложение ЛДС онлайн",
                items = listOf(
                    SettingItem("Наступление отрицательного баланса", isAvailable = true),
                    SettingItem("Достижение определённой суммы на Вашем балансе", isAvailable = true),
                    SettingItem("Предупреждение за 1 день до отключения", isAvailable = true),
                    SettingItem("Пополнение счёта", isAvailable = true),
                    SettingItem("Рекомендуемый платёж", isAvailable = true),
                    SettingItem("Восстановление пароля", isAvailable = false)
                ),
                actionText = "Активировать",
                price = "бесплатно"
            )
        )
    }

    object LinkedAccountsScreen {
        val mainAccount = LinkedAccount(
            name = "Ваш аккаунт",
            type = AccountType.MAIN,
            balance = "515.33",
            paidUntil = "Оплачено до 26.05.2025г. включительно",
            accountNumber = "12345678",
            tariff = "Безлим 300 + ТВ",
            linkedCount = 6
        )

        val linkedAccounts = listOf(
            LinkedAccount(
                name = "Мама",
                type = AccountType.VIEW_ONLY,
                balance = "50.62",
                paidUntil = "Оплачено до 30.05.2025г. включительно",
                accountNumber = "22345678",
                tariff = "Домашнее ТВ",
                actions = listOf(AccountAction.EDIT, AccountAction.REFILL, AccountAction.UNLINK)
            ),
            LinkedAccount(
                name = "Тёща",
                type = AccountType.VIEW_ONLY,
                balance = "-15.21",
                paidUntil = "Услуги не предоставляются",
                accountNumber = "32345678",
                tariff = "Безлим 90 + ТВ",
                actions = listOf(AccountAction.EDIT, AccountAction.REFILL, AccountAction.UNLINK),
                isAlert = true
            )
        )
    }

    object PaymentMethodsScreen {
        val paymentPoints = listOf(
            PaymentPoint(1, "Пункт приёма платежей", "кв. Жукова 4Б/1, главный офис ЛДС", listOf(ScheduleItem(listOf("ПН", "ВТ", "СР", "ЧТ", "ПТ", "СБ"), "9:00 - 18:00", "перерыв с 13:00 до 13:45"), ScheduleItem(listOf("ВС"), "выходной", isHoliday = true))),
            PaymentPoint(2, "Информационный центр ЛДС", "ул. Королева, 78, ТЦ \"Каштан\", модуль возле с/м \"Лелека\"", listOf(ScheduleItem(listOf("ПН", "ВТ", "СР", "ЧТ", "ПТ", "СБ"), "9:00 - 18:00", "перерыв с 13:00 до 13:45"), ScheduleItem(listOf("ВС"), "выходной", isHoliday = true))),
            PaymentPoint(3, "Сервисный центр в пгт. Белореченский", "Луганская обл. Лутугинский р-н пгт.Белореченский ул.Ленина дом 13. Магазин Феникс-маркет", listOf(ScheduleItem(listOf("ПН", "ВТ", "СР", "ЧТ", "ПТ", "СБ"), "8:00 - 14:00", "без перерыва"), ScheduleItem(listOf("ВС"), "выходной", isHoliday = true)))
        )
    }

    object HyperScreen {
        val serviceInfo = HyperServiceInfo(250, 250, 834, 834)
        val maxTariffParams = listOf(HyperParameter("Скорость", "до 1 Гбит/с"), HyperParameter("Шаг", "+50 Мбит/с"), HyperParameter("Повышение", "в любое время"), HyperParameter("Понижение", "через 30 дней"))
        val aboutItems = listOf("Получите доступ к сети интернет со скоростью до 1 Гбит/с!", "Закажите столько скорости, сколько нужно именно Вам.", "Добавьте самостоятельно к Вашему тарифу 50 Мбит/с и более.", "Увеличить скорость доступа можно в любой момент.", "Услуга доступна для абонентов с тарифами: \"Безлим 300\", \"Jump 200\", \"ЛДС-250\".", "Активировать услугу можно из личного кабинета.", "Снижение скорости доступно через 30 дней с момента последнего заказа.")
    }

    object ChangeTariffScreen {
        val tariffs = listOf(
            TariffInfo(1, "Безлим 300 и ТВ", "130", "Мбит/с", "210", "каналов", true, "933", "₽/30 дней"),
            TariffInfo(2, "Безлим 100+ и ТВ", "130", "Мбит/с", "210", "каналов", true, "834", "₽/30 дней", isCurrent = true, speedIconType = "internet--8"),
            TariffInfo(3, "Безлим 90 и ТВ", "130", "Мбит/с", "210", "каналов", false, "753", "₽/30 дней", speedIconType = "internet--7")
        )
        val importantInfo = listOf("Минимальный авансовый платеж 250 руб", "Смена акционного тарифа без потери акционного предложения возможна в течение первых 10 дней", "Смена тарифного плана в меньшую сторону возможна через 90 дней с момента подключения для тарифов: Безлим 15, Безлим 50, Безлим 90, Безлим 100+, Безлим 300")
        val localNetworkItems = listOf(NetworkInfoItem("Внутрисетевой трафик", "постоянно для активного пользователя", "БЕСПЛАТНО"), NetworkInfoItem("Доступ к локальным ресурсам", "постоянно для активного пользователя", "БЕСПЛАТНО"))
        val localNetworkRules = listOf("Активный пользователь - пользователь с неотрицательным балансом", "При отрицательном балансе доступ к локальным ресурсам, почте и т.п. блокируется")
        val additionalChanges = listOf(NetworkInfoItem("Смена тарифного плана на более высокий", "постоянно для активного пользователя", "БЕСПЛАТНО"), NetworkInfoItem("Смена тарифного плана на более низкий или равнозначный", "(при уменьшении или сохранении абонентской платы)", "110 ₽ + абонплата нового тарифного плана", isFree = false))
        val extraServices = listOf("Восстановление пароля доступа к личному счету и Интернет (требуется предоставление паспорта) - 15 ₽")
    }

    object SupportScreen {
        val phones = listOf(SupportPhone(listOf("mks", "plus7"), "410"), SupportPhone(listOf("mks"), "(072) 410-0-410"))
        val messengers = listOf(MessengerLink("vk", "Написать ВКонтакте"), MessengerLink("telegramm", "Написать в Telegram"))
        val chatMessages = listOf(SupportChatMessage("Оператор", "29 янв 2025 12:15:09", "Не понятно", isOperator = true, status = "read"), SupportChatMessage("Вы", "29 янв 2025 12:15:09", "Тест", isOperator = false))
    }
}
