package com.walhalla.jpfigma.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.WifiCalling3
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.walhalla.jpfigma.ui.components.AppDrawer
import com.walhalla.jpfigma.ui.model.AppScreen
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
                var currentScreen by remember { mutableStateOf(AppScreen.MESSAGES) }

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        AppDrawer(
                            currentScreen = currentScreen,
                            onScreenSelected = { screen ->
                                currentScreen = screen
                                scope.launch { drawerState.close() }
                            }
                        )
                    }
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = { Text(currentScreen.title) },
                                navigationIcon = {
                                    IconButton(onClick = { scope.launch { drawerState.open() } }) {
                                        Icon(Icons.Default.Menu, contentDescription = "Меню")
                                    }
                                }
                            )
                        },
                        floatingActionButton = {
                            FloatingActionButton(
                                shape = CircleShape,
                                onClick = {},
                                containerColor = Color(0xFF4CAF50)
                            ) {
                                Icon(Icons.Default.WifiCalling3, contentDescription = null)
                            }
                        }
                    ) { innerPadding ->
                        Box(modifier = Modifier.padding(innerPadding)) {
                            when (currentScreen) {
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
                                AppScreen.MESSAGES -> {
                                    MessagesScreen()
                                }
                                AppScreen.NEWS -> {
                                    NewsScreen()
                                }
                                AppScreen.PAYMENT_METHODS -> {
                                    PaymentScreen()
                                }
                                else -> {
                                    Box(
                                        modifier = Modifier.fillMaxSize(),
                                        contentAlignment = androidx.compose.ui.Alignment.Center
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
