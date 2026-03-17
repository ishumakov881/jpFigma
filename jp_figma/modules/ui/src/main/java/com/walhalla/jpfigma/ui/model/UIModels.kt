package com.walhalla.jpfigma.ui.model

// Tariff Models
data class TariffInfo(
    val id: Int,
    val name: String,
    val internetSpeed: String,
    val internetSpeedLabel: String,
    val tvChannels: String,
    val tvChannelsLabel: String,
    val isHyperAvailable: Boolean,
    val price: String,
    val pricePeriod: String,
    val isCurrent: Boolean = false,
    val speedIconType: String = "internet--9"
)

data class NetworkInfoItem(
    val title: String,
    val description: String,
    val priceLabel: String,
    val isFree: Boolean = true
)

// Hyper Models
data class HyperServiceInfo(
    val currentSpeed: Int,
    val targetSpeed: Int,
    val currentPrice: Int,
    val targetPrice: Int,
    val speedUnit: String = "Мбит/с",
    val currencyUnit: String = "₽/30 дней",
    val stepValue: Int = 50,
    val stepPrice: String = "+18 руб/мес",
    val userTariff: String = "Безлим 100+"
)

data class HyperParameter(
    val label: String,
    val value: String
)

// Support Models
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

// Payment Models
data class PaymentPoint(
    val id: Int,
    val title: String,
    val address: String,
    val schedule: List<ScheduleItem>,
    val imageUrl: String? = null
)

data class ScheduleItem(
    val days: List<String>,
    val time: String,
    val breakTime: String? = null,
    val isHoliday: Boolean = false
)

data class PaymentTransaction(
    val id: Int,
    val date: String,
    val description: String,
    val amount: String,
    val isPositive: Boolean,
    val balanceAfter: String? = null,
    val hasReceipt: Boolean = false
)

// Notifications Models
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

// Account Models
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

enum class BalanceColorType { GREEN, RED, ORANGE, GREY }

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

// App Module specific models moved to UI module
data class AccountInfo(
    val status: String,
    val balance: String,
    val balanceUntil: String,
    val tariffName: String,
    val accountNumber: String,
    val fullName: String,
    val address: String,
    val phone: String,
    val internetStatus: String,
    val macAddress: String,
    val tvStatus: String
)

data class UserServicePackage(
    val packageName: String,
    val services: List<ServiceDetail>,
    val totalPrice: String,
    val oldTotalPrice: String? = null
)

data class ServiceDetail(
    val name: String,
    val price: String,
    val oldPrice: String? = null,
    val hasOffer: Boolean = false
)

data class SubscriberProfile(
    val accountNumber: String,
    val fullName: String,
    val address: String,
    val phones: List<PhoneInfo>
)

data class PhoneInfo(
    val number: String,
    val isPrimary: Boolean = false,
    val isActualized: Boolean = false
)

data class ServiceInfo(
    val id: Int,
    val name: String,
    val statusText: String? = null,
    val statusType: ServiceStatusType = ServiceStatusType.NOT_CONNECTED,
    val canOpen: Boolean = true,
    val isFree: Boolean = false
)

enum class ServiceStatusType { ACTIVE, NOT_AVAILABLE, NOT_CONNECTED }

data class Message(
    val id: Int,
    val date: String,
    val title: String? = null,
    val content: String,
    val hasIcon: Boolean = false,
    val moreLinkText: String? = null
)

data class NewsItem(
    val id: Int,
    val date: String,
    val title: String,
    val imageUrl: String = "",
    val hasDot: Boolean = false
)
