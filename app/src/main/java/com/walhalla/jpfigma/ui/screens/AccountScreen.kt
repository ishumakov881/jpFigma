package com.walhalla.jpfigma.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.walhalla.jpfigma.ui.components.AccountScreenBody
import com.walhalla.jpfigma.ui.components.ServicePriceData
import com.walhalla.jpfigma.ui.model.MockData
import com.walhalla.jpfigma.ui.theme.JpFigmaTheme

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
        services = services,
        onTopUpClick = {},
        onChangeTariffClick = {},
        onActualizeClick = {},
        onDisconnectInternetClick = {},
        onChangeMacClick = {},
        onAllServicesClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun AccountScreenPreview() {
    JpFigmaTheme {
        AccountScreen()
    }
}
