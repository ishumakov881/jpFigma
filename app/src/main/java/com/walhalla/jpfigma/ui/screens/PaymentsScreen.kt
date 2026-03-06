package com.walhalla.jpfigma.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.walhalla.jpfigma.ui.theme.JpFigmaTheme

@Composable
fun PaymentsScreen() {
    MockScreens.PaymentsScreen()
}

@Preview(showBackground = true)
@Composable
fun PaymentsScreenPreview() {
    JpFigmaTheme {
        PaymentsScreen()
    }
}
