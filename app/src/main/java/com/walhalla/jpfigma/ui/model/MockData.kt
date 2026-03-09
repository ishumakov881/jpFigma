package com.walhalla.jpfigma.ui.model

object MockData {

    object MessagesScreen {
        val title = "Сообщения"
        val items = listOf(
            Message(1, "03 фев. 2019", "Внимание", "23 августа 2025г. - санитарный день. Точки приёма платежей выходные. Оплатить можно будет онлайн или в терминалах. Техническая поддержка будет работать в штатном режиме.", true),
            Message(2, "03 фев. 2019", content = "Уважаемые абоненты компании ЛДС. Добавлен новый способ оплаты услуг - оплата услуг компании ЛДС в отделениях почты ЛНР.", hasIcon = true, moreLinkText = "Подробнее"),
            Message(3, "03 фев. 2019", content = "Уважаемые абоненты компании ЛДС."),
            Message(4, "03 фев. 2019", content = "Уважаемые абоненты компании ЛДС.")
        )
    }

    object NewsScreen {
        val title = "Новости"
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
        val title = "Платежи"

    }

    object NotificationsScreen {
        val screenTitle = "Услуга “Уведомления”"
        val description = "Если Вы не хотите остаться без интернета в самый неподходящий момент, Вам необходима услуга «Уведомления». Эта услуга поможет вовремя пополнять счет, чтобы баланс не оказался отрицательным неожиданно для Вас. Данная информация будет высылаться выбранным вами способом."
        val advantagesTitle = "Преимущества уведомлений"
        val advantages = listOf(
            "подписка на услугу доступна в Вашем личном кабинете;",
            "возможность выбора платного/бесплатного варианта услуги;",
            "Вы можете настроить параметры уведомлений так, как Вам удобно."
        )
        val warningTextPrefix = "Услуга не подключена. "
        val warningTextSuffix = "Если хотите воспользоваться услугой - выберите вариант уведомлений и нажмите кнопку “Активировать” в приведенной ниже таблице. Для подтверждения необходимо будет ввести пароль."
        val settingsTitle = "Настройка услуги “Уведомления”"
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
        // Image URLs from Figma context
        val imgCheck = "https://www.figma.com/api/mcp/asset/9e7fa575-6515-4435-a826-162927cfff50"
        val imgNotAvailable = "https://www.figma.com/api/mcp/asset/5710d6ac-7304-4f8e-a662-38764dda95ba"
        val imgQuestion = "https://www.figma.com/api/mcp/asset/e46002a3-1c5a-49f5-9813-142d68a890c1"
        val imgWarning = "https://www.figma.com/api/mcp/asset/ead46fb3-07b8-48ff-9805-a2aae6f663fe"
    }

    object LinkedAccountsScreen {
        val screenTitle = "Услуга “Связанные аккаунты”"
        val descriptionPart1 = "\"Связанные аккаунты\" - удобное решение для управления несколькими  лицевыми счетами. Все счета в одном профиле: контролируйте баланс и  оплачивайте быстро и просто. Более подробно с услугой можно ознакомиться "
        val descriptionLink = "здесь"
        val descriptionPart2 = "."
        val freeServiceTitle = "Услуга “Связанные аккаунты” предоставляется "
        val freeServiceStatus = "бесплатно"

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
            ),
            LinkedAccount(
                name = "Работа",
                type = AccountType.FULL_CONTROL,
                balance = "1561.04",
                paidUntil = "Оплачено до 14.08.2025г. включительно",
                accountNumber = "42345678",
                tariff = "Офис-90",
                actions = listOf(AccountAction.EDIT, AccountAction.REFILL, AccountAction.GO_TO, AccountAction.UNLINK)
            ),
            LinkedAccount(
                name = "Магазин",
                type = AccountType.FULL_CONTROL,
                balance = "11.65",
                paidUntil = "Оплачено до 14.05.2025г. включительно",
                accountNumber = "44345678",
                tariff = "IoT",
                actions = listOf(AccountAction.EDIT, AccountAction.REFILL, AccountAction.GO_TO, AccountAction.UNLINK),
                balanceColorType = BalanceColorType.ORANGE
            ),
            LinkedAccount(
                name = "Квартира 12",
                type = AccountType.FULL_CONTROL,
                balance = "122.15",
                paidUntil = "Аккаунт заблокирован пользователем",
                accountNumber = "44345678",
                tariff = "Безлим 90 + ТВ",
                actions = listOf(AccountAction.EDIT, AccountAction.REFILL, AccountAction.GO_TO, AccountAction.UNLINK),
                balanceColorType = BalanceColorType.GREY
            ),
            LinkedAccount(
                name = "Квартира 27",
                type = AccountType.FINANCIAL_LINK,
                balance = "0.00",
                paidUntil = "Оплачивается с основного",
                accountNumber = "44345678",
                tariff = "Безлим 100+",
                actions = listOf(AccountAction.EDIT, AccountAction.REFILL, AccountAction.GO_TO, AccountAction.UNLINK),
                balanceColorType = BalanceColorType.GREY,
                isPaidFromMain = true
            )
        )

        val btnLinkAccount = "Привязать аккаунт"

        // Icons
        val iconEdit = "https://www.figma.com/api/mcp/asset/516f3e0b-0b05-4af6-9574-5f587284b256"
        val iconRefill = "https://www.figma.com/api/mcp/asset/56ef7e82-a9ad-4065-95d4-fb1e585fa796"
        val iconUnlink = "https://www.figma.com/api/mcp/asset/811ec7d7-1b73-4260-a752-e1af316a741e"
        val iconGoTo = "https://www.figma.com/api/mcp/asset/cc715ad5-f74a-4ac3-b1b8-1a135c35b7cf"
        val iconLinked = "https://www.figma.com/api/mcp/asset/ed6fdbb0-84f0-4ef1-b192-aa75afb9ff3d"
        val iconPlus = "https://www.figma.com/api/mcp/asset/1d6f3d9a-7a8d-4e39-952b-f36115069ae4"
        val iconList = "https://www.figma.com/api/mcp/asset/99b56b27-68ab-48bc-bdcc-6f386300f5d5"
        val iconGrid = "https://www.figma.com/api/mcp/asset/b71fbe59-096f-48e0-9d46-21c489b25326"
    }

    object ReferFriendScreen {
        val screenTitle = "Подключи друга"
        
        val descriptionParagraphs = listOf(
            "Подключите своего друга к ЛДС и получите бонус в виде пополнения счета для себя и для друга. Суммарно бонус составляет 180 руб. Вы и только Вы решаете, какую часть бонуса взять себе, а какую подарить другу!",
            "Двигая бегунок по шкале в ту или иную сторону, Вы сможете выставить размеры бонусов для Вас и Вашего друга в пределах 180 руб.",
            "В акции принимают участие только заявки на подключение, заполненные в электронной форме."
        )

        val steps = listOf(
            "Выберите по шкале бонусов, сколько получите Вы и Ваш друг.",
            "Укажите Ваш логин.",
            "Заполните контакты Вашего друга."
        )

        val section1Title = "Баланс бонусов"
        val section1Subtitle = "Передвигайте бегунок, чтоб определить, кому сколько достанется"

        val section2Title = "Ваши данные"
        val section2Warning = "Внимание! Вы уже должны быть подключены к сети"
        val section2InputLabel = "Введите Ваш лицевой счёт или логин"
        val section2InputPlaceholder = "Введите Ваш лицевой счёт или логин"

        val section3Title = "Данные подключаемого друга"
        val section3Warning = "Внимание! Здесь должны быть указаны данные того человека, которого мы должны подключить!"
        
        val inputNameLabel = "Имя Вашего друга"
        val inputNamePlaceholder = "Введит имя друга"
        
        val inputPhoneLabel = "Мобильный телефон"
        val inputPhonePlaceholder = "Введите номер телефона"
        val inputPhoneHint = "В формате: +7 959 123 45 67"
        
        val inputCityLabel = "Населённый пункт"
        val inputCityPlaceholder = "Выберите населённый нункт"
        
        val inputStreetLabel = "Квартал / улица"
        val inputStreetPlaceholder = "Квартал / улица"
        val inputStreetHint = "(введите не менее 3-х символов из названия квартала или улицы)"
        
        val inputHouseLabel = "Дом"
        val inputHousePlaceholder = "Номер дома"
        
        val inputFlatLabel = "Квартира"
        val inputFlatPlaceholder = "Номер квартиры"
        
        val inputSourceLabel = "Откуда узнали"
        val inputSourcePlaceholder = "Выберите вариант"
        
        val inputInfoLabel = "Дополнительная информация"
        val inputInfoPlaceholder = "Дополнительная информация"
        
        val requiredFieldsHint = "* - поля обязательны для заполнения"
        val submitButtonText = "Оставить заявку"
        
        val imgEllipse = "https://www.figma.com/api/mcp/asset/31b10f8d-b850-4c74-ae00-178baa7f19b3"
        val imgShape = "https://www.figma.com/api/mcp/asset/18e1f3fd-b732-46af-8bba-4187ecc6f687"
    }
}

data class LinkedAccount(
    val name: String,
    val type: AccountType,
    val balance: String,
    val paidUntil: String,
    val accountNumber: String,
    val tariff: String,
    val linkedCount: Int? = null,
    val actions: List<AccountAction> = emptyList(),
    val isAlert: Boolean = false,
    val balanceColorType: BalanceColorType = BalanceColorType.GREEN,
    val isPaidFromMain: Boolean = false
)

enum class AccountType(val label: String) {
    MAIN("Основной"),
    VIEW_ONLY("Только просмотр"),
    FULL_CONTROL("Полное управление"),
    FINANCIAL_LINK("Финансовая привязка")
}

enum class AccountAction(val label: String) {
    EDIT("Редактировать"),
    REFILL("Пополнить"),
    UNLINK("Отвязать"),
    GO_TO("Перейти")
}

enum class BalanceColorType {
    GREEN, RED, ORANGE, GREY
}

data class SettingsGroup(
    val title: String,
    val items: List<SettingItem>,
    val actionText: String,
    val price: String
)

data class SettingItem(
    val text: String,
    val isAvailable: Boolean,
    val label: String? = null
)
