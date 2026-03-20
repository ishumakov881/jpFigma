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
import com.walhalla.jpfigma.ui.components.AppDrawerContent
import com.walhalla.jpfigma.ui.components.DrawerMenuItemData
import com.walhalla.jpfigma.ui.components.MainTopAppBar
import com.walhalla.jpfigma.ui.mockScreens.*
import com.walhalla.jpfigma.ui.model.AppScreen
import com.walhalla.jpfigma.ui.model.MockData
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
                
                val menuItems = remember(currentScreen) {
                    AppScreen.entries.map { screen ->
                        DrawerMenuItemData(
                            title = screen.title,
                            iconRes = screen.iconRes,
                            isSelected = screen == currentScreen,
                            counter = if (screen == AppScreen.MESSAGES) "52" else null
                        )
                    }
                }

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        AppDrawerContent(
                            menuItems = menuItems,
                            onItemClick = { item ->
                                AppScreen.entries.find { it.title == item.title }?.let {
                                    currentScreen = it
                                }
                                scope.launch { drawerState.close() }
                            }
                        )
                    }
                ) {
                    Scaffold(
                        topBar = {
                            MainTopAppBar(
                                onMenuClick = { scope.launch { drawerState.open() } },
                                messageCount = "52"
                            )
                        }
                    ) { innerPadding ->
                        Box(modifier = Modifier.padding(innerPadding)) {
                            when (currentScreen) {
                                AppScreen.PROMOTIONS -> {
                                    OffersScreen()
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

                                AppScreen.USEFUL_INFO,
                                AppScreen.LOCAL_RESOURCES -> {
                                    Box(
                                        modifier = Modifier.fillMaxSize(),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text("Экран '${currentScreen.title}' в разработке")
                                    }
                                }
                                else -> {}
                            }
                        }
                    }
                }
            }
        }
    }
}
