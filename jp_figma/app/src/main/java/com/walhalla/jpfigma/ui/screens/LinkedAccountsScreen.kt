package com.walhalla.jpfigma.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.walhalla.jpfigma.ui.theme.JpFigmaTheme

@Composable
fun LinkedAccountsScreen() {
    MockScreens.LinkedAccountsScreen()
}

@Preview(showBackground = true)
@Composable
fun LinkedAccountsScreenPreview() {
    JpFigmaTheme {
        LinkedAccountsScreen()
    }
}
