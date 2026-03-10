package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.walhalla.jpfigma.R
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun InfoDialog(
    title: String,
    description: String,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    closeIconRes: Int = R.drawable.ic_dialog_close
) {
    Dialog(onDismissRequest = onDismiss) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 30.dp, 
                    shape = RoundedCornerShape(30.dp), 
                    ambientColor = FigmaShadowColor,
                    spotColor = FigmaShadowColor
                )
                .clip(RoundedCornerShape(30.dp))
                .background(FigmaCardWhite)
                .padding(20.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = FigmaTitleColor,
                    lineHeight = 19.8.sp
                )
                
                Text(
                    text = description,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = FigmaTextPrimary,
                    lineHeight = 15.4.sp
                )
            }

            // Close button (X)
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(24.dp)
                    .clickable { onDismiss() },
                contentAlignment = Alignment.Center
            ) {
                FigmaImage(
                    model = closeIconRes,
                    modifier = Modifier.size(14.dp)
                )
            }
        }
    }
}
