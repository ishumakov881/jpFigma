//package com.walhalla.jpfigma.ui.screens
//
//import androidx.compose.runtime.*
//import com.walhalla.jpfigma.ui.components.*
//import com.walhalla.jpfigma.ui.model.MockData
//import com.walhalla.jpfigma.ui.model.ServiceStatusType
//
//object MockScreens {
//
//    @Composable
//    fun AccountScreen() {
//        val account = MockData.AccountScreen.account
//        val pkg = MockData.AccountScreen.packages
//        val services = pkg.services.map {
//            ServicePriceData(
//                it.name,
//                it.price,
//                it.oldPrice,
//                it.hasOffer
//            )
//        }
//
//        AccountScreenBody(
//            status = account.status,
//            balance = account.balance,
//            balanceUntil = account.balanceUntil,
//            tariffName = account.tariffName,
//            accountNumber = account.accountNumber,
//            fullName = account.fullName,
//            address = account.address,
//            phone = account.phone,
//            internetStatus = account.internetStatus,
//            macAddress = account.macAddress,
//            tvStatus = account.tvStatus,
//            totalPrice = pkg.totalPrice,
//            oldTotalPrice = pkg.oldTotalPrice,
//            services = services
//        )
//    }
//
//    @Composable
//    fun ProfileScreen() {
//        val profile = MockData.ProfileScreen.profile
//        val phones = profile.phones.map {
//            PhoneData(
//                it.number,
//                it.isPrimary,
//                it.isActualized
//            )
//        }
//
//        var oldPassword by remember { mutableStateOf("") }
//        var newPassword by remember { mutableStateOf("") }
//        var confirmPassword by remember { mutableStateOf("") }
//
//        ProfileScreenBody(
//            accountNumber = profile.accountNumber,
//            fullName = profile.fullName,
//            address = profile.address,
//            phones = phones,
//            oldPassword = oldPassword,
//            newPassword = newPassword,
//            confirmPassword = confirmPassword,
//            onOldPasswordChange = { oldPassword = it },
//            onNewPasswordChange = { newPassword = it },
//            onConfirmPasswordChange = { confirmPassword = it }
//        )
//    }
//
//    @Composable
//    fun ServicesScreen() {
//        val title = MockData.ServicesScreen.title
//        val paid = MockData.ServicesScreen.paid.map {
//            ServiceItemData(
//                id = it.id,
//                name = it.name,
//                statusText = it.statusText,
//                isActive = it.statusType == ServiceStatusType.ACTIVE,
//                isNotAvailable = it.statusType == ServiceStatusType.NOT_AVAILABLE,
//                isNotConnected = it.statusType == ServiceStatusType.NOT_CONNECTED,
//                canOpen = it.canOpen,
//                isFree = it.isFree
//            )
//        }
//        val free = MockData.ServicesScreen.free.map {
//            ServiceItemData(
//                id = it.id,
//                name = it.name,
//                statusText = it.statusText,
//                isActive = it.statusType == ServiceStatusType.ACTIVE,
//                isNotAvailable = it.statusType == ServiceStatusType.NOT_AVAILABLE,
//                isNotConnected = it.statusType == ServiceStatusType.NOT_CONNECTED,
//                canOpen = it.canOpen,
//                isFree = it.isFree
//            )
//        }
//
//        ServicesScreenBody(
//            title = title,
//            paidServices = paid,
//            freeServices = free
//        )
//    }
//
//    @Composable
//    fun PaymentScreen() {
//        val data = MockData.PaymentMethodsScreen
//        PaymentScreenBody(
//            title = data.title,
//            description = data.description,
//            onlinePaymentTitle = data.onlinePaymentTitle,
//            onlinePaymentSubtitle = data.onlinePaymentSubtitle,
//            labelAccountNumber = data.labelAccountNumber,
//            labelAmount = data.labelAmount,
//            labelEmail = data.labelEmail,
//            btnPay = data.btnPay,
//            consentText = data.consentText,
//            sberTitle = data.sberTitle,
//            sberDescription = data.sberDescription,
//            sberLogo = data.sberLogo,
//            btnDetails = data.btnDetails,
//            iconArrowRight = data.iconArrowRight,
//            postTitle = data.postTitle,
//            postDescription = data.postDescription,
//            terminalTitle = data.terminalTitle,
//            terminalDescription = data.terminalDescription,
//            paymentPoints = data.paymentPoints
//        )
//    }
//
//    @Composable
//    fun SupportScreen() {
//        val data = MockData.SupportScreen
//        SupportScreenBody(
//            title = data.title,
//            phonesTitle = data.phonesTitle,
//            phonesDescription = data.phonesDescription,
//            phones = data.phones,
//            btnInternetCall = data.btnInternetCall,
//            btnInternetCallHint = data.btnInternetCallHint,
//            btnCallback = data.btnCallback,
//            messengersTitle = data.messengersTitle,
//            messengersDescription = data.messengersDescription,
//            messengers = data.messengers,
//            socialChannelsTitle = data.socialChannelsTitle,
//            socialChannels = data.socialChannels,
//            warningText = data.warningText,
//            writeSupportTitle = data.writeSupportTitle,
//            messageLabel = data.messageLabel,
//            messagePlaceholder = data.messagePlaceholder,
//            btnSend = data.btnSend,
//            archiveTitle = data.archiveTitle,
//            chatMessages = data.chatMessages,
//            btnShowMore = data.btnShowMore
//        )
//    }
//
//    @Composable
//    fun NotificationsScreen() {
//        val data = MockData.NotificationsScreen
//        NotificationsScreenBody(
//            screenTitle = data.screenTitle,
//            description = data.description,
//            advantagesTitle = data.advantagesTitle,
//            advantages = data.advantages,
//            warningTextPrefix = data.warningTextPrefix,
//            warningTextSuffix = data.warningTextSuffix,
//            settingsTitle = data.settingsTitle,
//            settingsGroups = data.settingsGroups,
//            imgCheck = data.imgCheck,
//            imgWarning = data.imgWarning,
//            imgQuestion = data.imgQuestion
//        )
//    }
//
//    @Composable
//    fun LinkedAccountsScreen() {
//        val data = MockData.LinkedAccountsScreen
//        LinkedAccountsScreenBody(
//            screenTitle = data.screenTitle,
//            descriptionPart1 = data.descriptionPart1,
//            descriptionLink = data.descriptionLink,
//            descriptionPart2 = data.descriptionPart2,
//            freeServiceTitle = data.freeServiceTitle,
//            freeServiceStatus = data.freeServiceStatus,
//            mainAccount = data.mainAccount,
//            linkedAccounts = data.linkedAccounts,
//            btnLinkAccount = data.btnLinkAccount
//        )
//    }
//
//    @Composable
//    fun MessagesScreen() {
//        val title = MockData.MessagesScreen.title
//        val messages = MockData.MessagesScreen.items.map {
//            MessageData(
//                it.date,
//                it.content,
//                it.title,
//                it.hasIcon,
//                it.moreLinkText
//            )
//        }
//
//        MessagesScreenBody(
//            title = title,
//            messages = messages
//        )
//    }
//
//    @Composable
//    fun NewsScreen() {
//        val title = MockData.NewsScreen.title
//        val featured = MockData.NewsScreen.featured.map {
//            NewsCardData(
//                it.date,
//                it.title,
//                it.imageUrl,
//                it.hasDot
//            )
//        }
//        val other = MockData.NewsScreen.other.map {
//            NewsListData(
//                it.date,
//                it.title,
//                it.hasDot
//            )
//        }
//
//        NewsScreenBody(
//            title = title,
//            featuredNews = featured,
//            otherNews = other
//        )
//    }
//
//    @Composable
//    fun HyperScreen() {
//        val data = MockData.HyperScreen
//        HyperScreenBody(
//            title = data.title,
//            serviceInfo = data.serviceInfo,
//            maxTariffParams = data.maxTariffParams,
//            aboutItems = data.aboutItems,
//            warningText = data.warningText,
//            btnChangeSpeed = data.btnChangeSpeed
//        )
//    }
//
//    @Composable
//    fun ChangeTariffScreen() {
//        val data = MockData.ChangeTariffScreen
//        ChangeTariffScreenBody(
//            title = data.title,
//            filterOptions = data.filterOptions,
//            tariffs = data.tariffs,
//            importantInfo = data.importantInfo,
//            warningSpeedLimit = data.warningSpeedLimit,
//            localNetworkTitle = data.localNetworkTitle,
//            localNetworkItems = data.localNetworkItems,
//            localNetworkRules = data.localNetworkRules,
//            additionalTitle = data.additionalTitle,
//            additionalChanges = data.additionalChanges,
//            extraServices = data.extraServices
//        )
//    }
//
//    @Composable
//    fun PaymentsScreen() {
//        val data = MockData.PaymentsScreen
//
//        PaymentsScreenBody(
//            title = data.title,
//            dateFrom = data.dateFrom,
//            dateTo = data.dateTo,
//            btnShow = data.btnShow,
//            btnHistory = data.btnHistory,
//            headerDate = data.headerDate,
//            headerDescription = data.headerDescription,
//            transactions = data.transactions,
//            balanceLabel = data.balanceLabel,
//            balanceValue = data.balanceValue,
//            balanceUntil = data.balanceUntil,
//            btnTopUp = data.btnTopUp,
//            iconCalendar = data.iconCalendar,
//            iconWallet = data.iconWallet
//        )
//    }
//}
