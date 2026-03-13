package com.walhalla.jpfigma.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.walhalla.jpfigma.ui.theme.JpFigmaTheme

@Composable
fun HyperScreen() {
    MockScreens.HyperScreen()
}

@Preview(showBackground = true)
@Composable
fun HyperScreenPreview() {
    JpFigmaTheme {
        HyperScreen()
    }
}
