package com.walhalla.jpfigma.ui.model

import androidx.annotation.DrawableRes
import com.walhalla.jpfigma.R

enum class AppScreen(val title: String, @DrawableRes val iconRes: Int) {
    MY_ACCOUNT("Мой аккаунт", R.drawable.ic_00),
    PROFILE("Профиль абонента", R.drawable.icons_1),
    SERVICES("Услуги", R.drawable.icons_2),
    NOTIFICATIONS("Уведомления", R.drawable.icons_3),
    LINKED_ACCOUNTS("Связанные аккаунты", R.drawable.icons_4),
    PAYMENT_METHODS("Способы оплаты", R.drawable.icons_5),
    PAYMENTS("Платежи", R.drawable.icons_6),
    SUPPORT("Техподдержка", R.drawable.icons_7),
    MESSAGES("Сообщения", R.drawable.icons_8),
    DOCUMENTS("Документы", R.drawable.icons_9),
    NEWS("Новости", R.drawable.icons_10),
    PROMOTIONS("Доступные акции", R.drawable.ic_00),
    USEFUL_INFO("Полезное для абонентов", R.drawable.ic_00),
    LOCAL_RESOURCES("Локальные ресурсы", R.drawable.ic_00),
    REFER_FRIEND("Подключи друга", R.drawable.ic_00),
    EXIT("Выход", R.drawable.ic_00)
}
