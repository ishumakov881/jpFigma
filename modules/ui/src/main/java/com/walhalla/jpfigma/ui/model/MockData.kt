package com.walhalla.jpfigma.ui.model

import com.walhalla.ui0.R
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
        val dateFrom = "1.05.2025"
        val dateTo = "20.05.2025"
        val btnShow = "Показать"
        val btnHistory = "История баланса"
        val headerDate = "Дата"
        val headerDescription = "Сумма и вид платежа"
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
        val balanceLabel = "Ваш баланс:"
        val balanceValue = "515.33"
        val balanceUntil = "Оплачено до 26 июня 2025г. включительно"
        val btnTopUp = "Пополнить счёт"
        
        // Local Resources
        val iconCalendar = R.drawable.ic_calendar
        val iconWallet = R.drawable.ic_wallet
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
        // Local Resources
        val imgCheck = R.drawable.ic_check
        val imgQuestion = R.drawable.ic_question
        val imgWarning = R.drawable.ic_warning
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

    }

    object PaymentMethodsScreen {
        val title = "Способы оплаты"
        val description = "Оплатить услуги компании Луганские Домашние Сети можно следующими способами:"
        val onlinePaymentTitle = "Оплата онлайн"
        val onlinePaymentSubtitle = "Введите номер Вашего лицевого счета и сумму платежа"
        val labelAccountNumber = "Лицевой счёт"
        val labelAmount = "Сумма"
        val labelEmail = "E-mail (необязательно)"
        val btnPay = "Оплатить"
        val consentText = "Нажимая на кнопку \"Оплатить\", Вы соглашаетесь с условиями на обработку персональных данных"
        val sberTitle = "Оплата через"
        val sberDescription = "Оплата услуг компнании ООО \"Луганские сети\" доступна через \"СберБанк\" с комиссией 1%"
        val btnDetails = "Детальнее"
        val postTitle = "Оплата услуг ЛДС в отделениях почты ЛНР"
        val postDescription = "Вы можете пополнить счет в отделениях почты ЛНР."
        val terminalTitle = "Оплата услуг ЛДС с помощью платежных терминалов"
        val terminalDescription = "Абоненты ЛДС могут произвести оплату в сети платежных терминалов, которые расположены в магазинах и супермаркетах Вашего населенного пункта. Для оплаты услуг Вам потребуется лицевой счет, который был присвоен Вам при подключении. Номер лицевого счета указан в памятке пользователя. Для восстановления номера лицевого счета в случае его утери обратитесь в техническую поддержку компании ЛДС."

        val paymentPoints = listOf(
            PaymentPoint(1, "Пункт приёма платежей", "кв. Жукова 4Б/1, главный офис ЛДС", listOf(ScheduleItem(listOf("ПН", "ВТ", "СР", "ЧТ", "ПТ", "СБ"), "9:00 - 18:00", "перерыв с 13:00 до 13:45"), ScheduleItem(listOf("ВС"), "выходной", isHoliday = true))),
            PaymentPoint(2, "Информационный центр ЛДС", "ул. Королева, 78, ТЦ \"Каштан\", модуль возле с/м \"Лелека\"", listOf(ScheduleItem(listOf("ПН", "ВТ", "СР", "ЧТ", "ПТ", "СБ"), "9:00 - 18:00", "перерыв с 13:00 до 13:45"), ScheduleItem(listOf("ВС"), "выходной", isHoliday = true))),
            PaymentPoint(3, "Сервисный центр в пгт. Белореченский", "Луганская обл. Лутугинский р-н пгт.Белореченский ул.Ленина дом 13. Магазин Феникс-маркет", listOf(ScheduleItem(listOf("ПН", "ВТ", "СР", "ЧТ", "ПТ", "СБ"), "8:00 - 14:00", "без перерыва"), ScheduleItem(listOf("ВС"), "выходной", isHoliday = true)))
        )
        // Local Resources
        val sberLogo = R.drawable.ic_sber_logo
        val iconArrowRight = R.drawable.ic_arrow_right_blue
    }

    object HyperScreen {
        val title = "Услуга “Гипер”"
        val serviceInfo = HyperServiceInfo(250, 250, 834, 834)
        val maxTariffParams = listOf(HyperParameter("Скорость", "до 1 Гбит/с"), HyperParameter("Шаг", "+50 Мбит/с"), HyperParameter("Повышение", "в любое время"), HyperParameter("Понижение", "через 30 дней"))
        val aboutItems = listOf("Получите доступ к сети интернет со скоростью до 1 Гбит/с!", "Закажите столько скорости, сколько нужно именно Вам.", "Добавьте самостоятельно к Вашему тарифу 50 Мбит/с и более.", "Увеличить скорость доступа можно в любой момент.", "Услуга доступна для абонентов с тарифами: \"Безлим 300\", \"Jump 200\", \"ЛДС-250\".", "Активировать услугу можно из личного кабинета.", "Снижение скорости доступно через 30 дней с момента последнего заказа.")
        val warningText = "Максимальная скорость может быть ограничена техническими параметрами и возможностями используемого клиентского оборудования"
        val btnChangeSpeed = "Изменить скорость"
        
        // Local Resources
        val iconMinus = R.drawable.ic_minus_circle
        val iconPlus = R.drawable.ic_plus_circle
        val iconDot = R.drawable.ic_bullet_dot
        val iconWarning = R.drawable.ic_warning
    }

    object AccountInfoDialog {
        val title = "Лицевой счёт"
        val description = "Лицевой счет, он же номер договора, нужен для оплаты услуг Интернет и кабельного телевидения от ЛДС в терминалах самообслуживания."
        val iconClose = R.drawable.ic_dialog_close
    }

    object ChangeTariffScreen {
        val title = "Сменить тариф"
        val filterOptions = listOf("Интернет", "Интернет и ТВ", "ТВ")
        val tariffs = listOf(
            TariffInfo(1, "Безлим 300 и ТВ", "130", "Мбит/с", "210", "каналов", true, "933", "₽/30 дней"),
            TariffInfo(2, "Безлим 100+ и ТВ", "130", "Мбит/с", "210", "каналов", true, "834", "₽/30 дней", isCurrent = true, speedIconType = "internet--8"),
            TariffInfo(3, "Безлим 90 и ТВ", "130", "Мбит/с", "210", "каналов", false, "753", "₽/30 дней", speedIconType = "internet--7"),
            TariffInfo(4, "Безлим 50 и ТВ", "130", "Мбит/с", "210", "каналов", false, "753", "₽/30 дней", speedIconType = "internet--5"),
            TariffInfo(5, "Безлим 25 и ТВ", "130", "Мбит/с", "210", "каналов", false, "732", "₽/30 дней", speedIconType = "internet--3")
        )
        val importantInfo = listOf("Минимальный авансовый платеж 250 руб", "Смена акционного тарифа без потери акционного предложения возможна в течение первых 10 дней", "Смена тарифного плана в меньшую сторону возможна через 90 дней с момента подключения для тарифов: Безлим 15, Безлим 50, Безлим 90, Безлим 100+, Безлим 300", "По истечении указанных акционных дней скорость устанавливается равной скорости одноименного тарифа", "Предоставление услуги \"Блокировка аккаунта\" возможно через 6 месяцев с момента подключения", "Срок подключения: до 3-х рабочих дней в зависимости от погодных условий и прочих форс-мажорных обстоятельств", "При подключении выделяется 1 (один) динамический локальный IP адрес", "В стоимость подключения не входит обучение Клиента работе с программным обеспечением", "Бонус зачисляется на лицевой счет абонента единоразово после новой активации")
        val warningSpeedLimit = "Максимальная скорость может быть ограничена техническими параметрами и возможностями используемого клиентского оборудования"
        val localNetworkTitle = "Локальная сеть"
        val localNetworkItems = listOf(NetworkInfoItem("Внутрисетевой трафик", "постоянно для активного пользователя", "БЕСПЛАТНО"), NetworkInfoItem("Доступ к локальным ресурсам", "постоянно для активного пользователя", "БЕСПЛАТНО"))
        val localNetworkRules = listOf("Активный пользователь - пользователь с неотрицательным балансом", "При отрицательном балансе доступ к локальным ресурсам, почте и т.п. блокируется", "При отрицательном балансе доступ открыт только на основной сайт (http://lds.ua), сайт статистики (https://stat.lds.net.ua)")
        val additionalTitle = "Дополнительно"
        val additionalChanges = listOf(NetworkInfoItem("Смена тарифного плана на более высокий", "постоянно для активного пользователя", "БЕСПЛАТНО"), NetworkInfoItem("Смена тарифного плана на более низкий или равнозначный", "(при уменьшении или сохранении абонентской платы)", "110 ₽ + абонплата нового тарифного плана", isFree = false))
        val extraServices = listOf("Восстановление пароля доступа к личному счету и Интернет (требуется предоставление паспорта) - 15 ₽", "Смена параметров основной учетной записи (логин, паспортные данные - требуется предоставление паспорта с пропиской) - 150 ₽", "Блокировка аккаунта при неотрицательном балансе на срок до 6 месяцев (физическое отключение) - 60 ₽", "Включение заблокированного аккаунта (физическое включение) - бесплатно")
        
        // Local Resources
        val iconBack = R.drawable.ic_back_arrow
        val iconDetails = R.drawable.ic_details_blue
        val iconDot = R.drawable.ic_bullet_dot
        val iconWarning = R.drawable.ic_warning
        val imgPriceUp = R.drawable.icons_1
        val imgPriceDown = R.drawable.icons_2
        val iconTv = R.drawable.ic_tariff_tv
        val iconHyper = R.drawable.ic_tariff_hyper
    }

    object SupportScreen {
        val title = "Техподдержка"
        val phonesTitle = "Наши телефоны 24/7"
        val phonesDescription = "Для улучшения качества обслуживания клиентов и повышения эффективности работы call-центра ваш разговор с оператором может быть записан"
        val phones = listOf(SupportPhone(listOf("mks", "plus7"), "410"), SupportPhone(listOf("mks"), "(072) 410-0-410"), SupportPhone(listOf("cityphone"), "(0642) 503-503"), SupportPhone(listOf("nadofon"), "(Надофон) 503-503"))
        val btnInternetCall = "Интернет звонок"
        val btnInternetCallHint = "(бесплатно)"
        val btnCallback = "Заказать обратный звонок"
        val messengersTitle = "Мессенджеры"
        val messengersDescription = "Для быстрого и удобного доступа к техподдержке online Вы можете воспользоваться виджетом, размещённым в нижнем правом углу сайта."
        val messengers = listOf(MessengerLink("vk", "Написать ВКонтакте"), MessengerLink("telegramm", "Написать в Telegram"))
        val socialChannelsTitle = "Официальные каналы"
        val socialChannels = listOf("vk", "telegramm")
        val warningText = "Для улучшения качества обслуживания клиентов и повышения эффективности работы call-центра Ваш разговор с оператором может быть записан."
        val writeSupportTitle = "Написать в техподдержку"
        val messageLabel = "Сообщение"
        val messagePlaceholder = "Введите сообщение..."
        val btnSend = "Отправить"
        val archiveTitle = "Архив сообщений"
        val chatMessages = listOf(SupportChatMessage("Оператор", "29 янв 2025 12:15:09", "Не понятно", isOperator = true, status = "read"), SupportChatMessage("Вы", "29 янв 2025 12:15:09", "Тест", isOperator = false), SupportChatMessage("Вы", "29 янв 2025 12:15:09", "Тест", isOperator = false), SupportChatMessage("Вы", "29 янв 2025 12:15:09", "Тест", isOperator = false), SupportChatMessage("Вы", "29 янв 2025 12:15:09", "Тест", isOperator = false), SupportChatMessage("Вы", "29 янв 2025 12:15:09", "Он то был то пропадал", isOperator = false), SupportChatMessage("Оператор", "29 янв 2025 12:15:09", "Здравствуйте, опишите пожалуйста подробнее Вашу проблему.", isOperator = true), SupportChatMessage("Вы", "29 янв 2025 12:15:09", "Здравствуйте, хочу сообщить о проблеме, возникшей у меня вчера с интернетом.", isOperator = false))
        val btnShowMore = "Показать ещё"
        
        // Local Resources
        val iconPhone = R.drawable.ic_support_phone
        val iconWarning = R.drawable.ic_support_warning
        val iconSend = R.drawable.ic_support_send
        val iconOperator = R.drawable.ic_support_operator
        val iconStatusRead = R.drawable.ic_status_read
        val iconVk = R.drawable.ic_vk
        val iconTelegram = R.drawable.ic_telegram
    }

    object ReferFriendScreen {
        val screenTitle = "Подключи друга"
        val descriptionParagraphs = listOf("Подключите своего друга к ЛДС и получите бонус в виде пополнения счета для себя и для друга. Суммарно бонус составляет 180 руб. Вы и только Вы решаете, какую часть бонуса взять себе, а какую подарить другу!", "Двигая бегунок по шкале в ту или иную сторону, Вы сможете выставить размеры бонусов для Вас и Вашего друга в пределах 180 руб.", "В акции принимают участие только заявки на подключение, заполненные в электронной форме.")
        val steps = listOf("Выберите по шкале бонусов, сколько получите Вы и Ваш друг.", "Укажите Ваш логин.", "Заполните контакты Вашего друга.")
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
        
        // Local Resources
        val imgEllipse = R.drawable.ic_ellipse
        val imgShape = R.drawable.ic_arrow_down
    }
}

data class LinkedAccount(val name: String, val type: AccountType, val balance: String, val paidUntil: String, val accountNumber: String, val tariff: String, val linkedCount: Int? = null, val actions: List<AccountAction> = emptyList(), val isAlert: Boolean = false, val balanceColorType: BalanceColorType = BalanceColorType.GREEN, val isPaidFromMain: Boolean = false)
enum class AccountType(val label: String) { MAIN("Основной"), VIEW_ONLY("Только просмотр"), FULL_CONTROL("Полное управление"), FINANCIAL_LINK("Финансовая привязка") }
enum class AccountAction(val label: String) { EDIT("Редактировать"), REFILL("Пополнить"), UNLINK("Отвязать"), GO_TO("Перейти") }
enum class BalanceColorType { GREEN, RED, ORANGE, GREY }
data class SettingsGroup(val title: String, val items: List<SettingItem>, val actionText: String, val price: String)
data class SettingItem(val text: String, val isAvailable: Boolean, val label: String? = null)
