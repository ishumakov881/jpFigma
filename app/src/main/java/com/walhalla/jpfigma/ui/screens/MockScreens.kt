package com.walhalla.jpfigma.ui.screens

import androidx.compose.runtime.*
import com.walhalla.jpfigma.ui.components.*
import com.walhalla.jpfigma.ui.model.MockData
import com.walhalla.jpfigma.ui.model.ServiceStatusType

object MockScreens {

    @Composable
    fun AccountScreen() {
        val account = MockData.AccountScreen.account
        val pkg = MockData.AccountScreen.packages
        val services = pkg.services.map { 
            ServicePriceData(it.name, it.price, it.oldPrice, it.hasOffer)
        }

        AccountScreenBody(
            status = account.status,
            balance = account.balance,
            balanceUntil = account.balanceUntil,
            tariffName = account.tariffName,
            accountNumber = account.accountNumber,
            fullName = account.fullName,
            address = account.address,
            phone = account.phone,
            internetStatus = account.internetStatus,
            macAddress = account.macAddress,
            tvStatus = account.tvStatus,
            totalPrice = pkg.totalPrice,
            oldTotalPrice = pkg.oldTotalPrice,
            services = services
        )
    }

    @Composable
    fun ProfileScreen() {
        val profile = MockData.ProfileScreen.profile
        val phones = profile.phones.map {
            PhoneData(it.number, it.isPrimary, it.isActualized)
        }

        var oldPassword by remember { mutableStateOf("") }
        var newPassword by remember { mutableStateOf("") }
        var confirmPassword by remember { mutableStateOf("") }

        ProfileScreenBody(
            accountNumber = profile.accountNumber,
            fullName = profile.fullName,
            address = profile.address,
            phones = phones,
            oldPassword = oldPassword,
            newPassword = newPassword,
            confirmPassword = confirmPassword,
            onOldPasswordChange = { oldPassword = it },
            onNewPasswordChange = { newPassword = it },
            onConfirmPasswordChange = { confirmPassword = it }
        )
    }

    @Composable
    fun ServicesScreen() {
        val title = MockData.ServicesScreen.title
        val paid = MockData.ServicesScreen.paid.map {
            ServiceItemData(
                id = it.id,
                name = it.name,
                statusText = it.statusText,
                isActive = it.statusType == ServiceStatusType.ACTIVE,
                isNotAvailable = it.statusType == ServiceStatusType.NOT_AVAILABLE,
                isNotConnected = it.statusType == ServiceStatusType.NOT_CONNECTED,
                canOpen = it.canOpen,
                isFree = it.isFree
            )
        }
        val free = MockData.ServicesScreen.free.map {
            ServiceItemData(
                id = it.id,
                name = it.name,
                statusText = it.statusText,
                isActive = it.statusType == ServiceStatusType.ACTIVE,
                isNotAvailable = it.statusType == ServiceStatusType.NOT_AVAILABLE,
                isNotConnected = it.statusType == ServiceStatusType.NOT_CONNECTED,
                canOpen = it.canOpen,
                isFree = it.isFree
            )
        }

        ServicesScreenBody(
            title = title,
            paidServices = paid,
            freeServices = free
        )
    }

    @Composable
    fun PaymentScreen(){

    }
    @Composable
    fun NotificationsScreen() {

    }

    @Composable
    fun MessagesScreen() {
        val title = MockData.MessagesScreen.title
        val messages = MockData.MessagesScreen.items.map {
            MessageData(it.date, it.content, it.title, it.hasIcon, it.moreLinkText)
        }

        MessagesScreenBody(
            title = title,
            messages = messages
        )
    }

    @Composable
    fun NewsScreen() {
        val title = MockData.NewsScreen.title
        val featured = MockData.NewsScreen.featured.map {
            NewsCardData(it.date, it.title, it.imageUrl, it.hasDot)
        }
        val other = MockData.NewsScreen.other.map {
            NewsListData(it.date, it.title, it.hasDot)
        }

        NewsScreenBody(
            title = title,
            featuredNews = featured,
            otherNews = other
        )
    }

    @Composable
    fun PaymentsScreen() {
        val title = MockData.PaymentsScreen.title


        PaymentsScreenBody(
            title = title
        )
    }
}
