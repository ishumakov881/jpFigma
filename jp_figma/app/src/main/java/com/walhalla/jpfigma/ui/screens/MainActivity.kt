package com.walhalla.jpfigma.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.walhalla.jpfigma.ui.components.AppDrawer
import com.walhalla.jpfigma.ui.components.MainTopAppBar
import com.walhalla.jpfigma.ui.model.AppScreen
import com.walhalla.jpfigma.ui.model.MockData
import com.walhalla.jpfigma.ui.offers.OffersScreen
import com.walhalla.jpfigma.ui.screens.MockScreens.PaymentsScreen
import com.walhalla.jpfigma.ui.theme.JpFigmaTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JpFigmaTheme {
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()
                var currentScreen by remember { mutableStateOf(AppScreen.PROMOTIONS) }
                val screens = remember { AppScreen.entries.map { it.title } }

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        AppDrawer(
                            menuItems = screens,
                            selectedItem = currentScreen.title,
                            onItemClick = { title ->
                                AppScreen.entries.find { it.title == title }?.let {
                                    currentScreen = it
                                }
                                scope.launch { drawerState.close() }
                            }
                        )
                    }
                ) {
                    Scaffold(
                        topBar = {
                            MainTopAppBar(onMenuClick = { scope.launch { drawerState.open() } })
                        }
                    ) { innerPadding ->
                        Box(modifier = Modifier.padding(innerPadding)) {
                            when (currentScreen) {
                                AppScreen.PROMOTIONS -> {
                                    OffersScreen(
                                        offers = MockData.OffersScreen.offers,
                                        onOfferClick = {}
                                    )
                                }
                                AppScreen.MY_ACCOUNT -> {
                                    AccountScreen()
                                }

                                AppScreen.PROFILE -> {
                                    ProfileScreen()
                                }

                                AppScreen.SERVICES -> {
                                    ServicesScreen()
                                }

                                AppScreen.NOTIFICATIONS -> {
                                    NotificationsScreen()
                                }

                                AppScreen.LINKED_ACCOUNTS -> {
                                    LinkedAccountsScreen()
                                }

                                AppScreen.MESSAGES -> {
                                    MessagesScreen()
                                }

                                AppScreen.NEWS -> {
                                    NewsScreen()
                                }

                                AppScreen.PAYMENT_METHODS -> {
                                    PaymentScreen()
                                }

                                AppScreen.PAYMENTS -> {
                                    PaymentsScreen()
                                }

                                AppScreen.SUPPORT -> {
                                    SupportScreen()
                                }

                                AppScreen.REFER_FRIEND -> {
                                    ReferFriendScreen()
                                }

                                else -> {
                                    Box(
                                        modifier = Modifier.fillMaxSize(),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text("Экран '${currentScreen.title}' в разработке")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}