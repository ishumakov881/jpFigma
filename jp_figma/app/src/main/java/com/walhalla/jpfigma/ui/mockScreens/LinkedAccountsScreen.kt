package com.walhalla.jpfigma.ui.mockScreens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.walhalla.jpfigma.ui.components.LinkedAccountsScreenBody
import com.walhalla.jpfigma.ui.model.MockData

@Composable
fun LinkedAccountsScreen() {
    val data = MockData.LinkedAccountsScreen
    LinkedAccountsScreenBody(
        mainAccount = data.mainAccount,
        linkedAccounts = data.linkedAccounts,
        onLinkAccountClick = {},
        onActionClick = { _, _ -> }
    )
}

@Preview(showBackground = true)
@Composable
fun LinkedAccountsScreenPreview() {
    LinkedAccountsScreen()
}
