package com.walhalla.jpfigma.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.walhalla.jpfigma.ui.components.AppDrawer
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
                var currentScreen by remember { mutableStateOf(AppScreen.MESSAGES) }
                
                // Payment Screen State
                var accountNumber by remember { mutableStateOf("12345678") }
                var amount by remember { mutableStateOf("200") }
                var email by remember { mutableStateOf("") }

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
                        }
                    ) { innerPadding ->
                        Box(modifier = Modifier.padding(innerPadding)) {
                            when (currentScreen) {
                                AppScreen.MESSAGES -> {
                                    MessagesScreen(messages = MockData.getMessages())
                                }
                                AppScreen.NEWS -> {
                                    NewsScreen(
                                        featuredNews = MockData.getFeaturedNews(),
                                        otherNews = MockData.getOtherNews()
                                    )
                                }
                                AppScreen.PAYMENT_METHODS -> {
                                    PaymentScreen(
                                        accountNumber = accountNumber,
                                        onAccountChange = { accountNumber = it },
                                        amount = amount,
                                        onAmountChange = { amount = it },
                                        email = email,
                                        onEmailChange = { email = it },
                                        onPayClick = { /* Handle Pay */ },
                                        paymentMethods = MockData.getPaymentMethods(),
                                        paymentPoints = MockData.getPaymentPoints()
                                    )
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
