package com.walhalla.jpfigma.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.walhalla.jpfigma.ui.theme.JpFigmaTheme

@Composable
fun AccountScreen() {
    MockScreens.AccountScreen()
}

@Preview(showBackground = true)
@Composable
fun AccountScreenPreview() {
    JpFigmaTheme {
        AccountScreen()
    }
}
