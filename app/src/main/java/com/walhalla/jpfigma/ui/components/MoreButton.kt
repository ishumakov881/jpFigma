package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun MoreButton(
    modifier: Modifier = Modifier,
    text: String = "Ещё",
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier
            .width(200.dp)
            .height(40.dp),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(1.dp, BrandColor1),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.White,
            contentColor = BrandColor1
        )
    ) {
        Text(
            text = text,
            fontSize = 15.sp
        )
    }
}
