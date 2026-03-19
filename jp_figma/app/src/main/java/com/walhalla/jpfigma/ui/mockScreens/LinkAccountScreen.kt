package com.walhalla.jpfigma.ui.mockScreens

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.walhalla.jpfigma.ui.components.LinkAccountScreenBody



///** Диалог добавления нового связанного акка *

@Composable
fun LinkAccountScreen() {
    var accountNumber by remember { mutableStateOf("") }
    var accountPassword by remember { mutableStateOf("") }
    var accountAlias by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var isFullAccess by remember { mutableStateOf(false) }
    var isPaidFromMain by remember { mutableStateOf(false) }

    LinkAccountScreenBody(
        accountNumber = accountNumber,
        accountPassword = accountPassword,
        accountAlias = accountAlias,
        confirmPassword = confirmPassword,
        isFullAccessRequested = isFullAccess,
        isPaidFromMainRequested = isPaidFromMain,
        onAccountNumberChange = { accountNumber = it },
        onAccountPasswordChange = { accountPassword = it },
        onAccountAliasChange = { accountAlias = it },
        onConfirmPasswordChange = { confirmPassword = it },
        onFullAccessToggle = { isFullAccess = it },
        onPaidFromMainToggle = { isPaidFromMain = it },
        onLinkClick = { /* Logic */ },
        onCloseClick = { /* Close logic */ }
    )
}

@Preview(showBackground = true)
@Composable
fun LinkAccountScreenPreview() {
    LinkAccountScreen()
}
