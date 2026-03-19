package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.theme.ColorFigma

@Composable
fun FigmaInput(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    isBold: Boolean = true
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .shadow(elevation = 6.dp, shape = RoundedCornerShape(5.dp), clip = false)
            .clip(RoundedCornerShape(5.dp))
            .background(ColorFigma.White)
            .height(56.dp)
            .padding(horizontal = 15.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = label,
                color = ColorFigma.Text3,
                fontSize = 14.sp
            )
            if (value.isNotEmpty()) {
                Text(
                    text = value,
                    color = ColorFigma.Text2,
                    fontSize = 18.sp,
                    fontWeight = if (isBold) FontWeight.Bold else FontWeight.Normal
                )
            }
        }
    }
}
