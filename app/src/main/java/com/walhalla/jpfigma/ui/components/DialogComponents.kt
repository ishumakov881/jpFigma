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
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun InfoDialog(
    title: String,
    description: String,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    Dialog(onDismissRequest = onDismiss) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .shadow(elevation = 30.dp, shape = RoundedCornerShape(30.dp), ambientColor = Color.Black.copy(alpha = 0.25f))
                .clip(RoundedCornerShape(30.dp))
                .background(White)
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
                    color = TitleColor,
                    lineHeight = 19.8.sp
                )
                
                Text(
                    text = description,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Text2,
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
                AsyncImageWithPlaceholder(
                    imageUrl = "https://www.figma.com/api/mcp/asset/46784929-ce6d-4ad8-9a25-eb7756423cc9",
                    modifier = Modifier.size(14.dp) // Actual SVG vector size inside the 24dp box
                )
            }
        }
    }
}
