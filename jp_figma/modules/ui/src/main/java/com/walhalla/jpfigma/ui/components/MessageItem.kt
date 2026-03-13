package com.walhalla.jpfigma.ui.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun MessageItem(
    modifier: Modifier = Modifier,
    date: String,
    content: String,
    title: String? = null,
    hasIcon: Boolean = false,
    moreLinkText: String? = null
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(
                text = date,
                color = Text3,
                fontSize = 11.sp
            )
            if (hasIcon) {
//                Icon(
//                    painter = painterResource(id = R.drawable.ic_info),
//                    modifier = Modifier.size(14.dp),
//                    contentDescription = null,
//                    tint = OrangeIconColor
//                )
            }
        }
        
        if (title != null) {
            Text(
                text = title,
                color = Text1,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 5.dp)
            )
        }
        
        val contentText = buildAnnotatedString {
            append(content)
            if (moreLinkText != null) {
                append(" ")
                withStyle(style = SpanStyle(color = BrandColor1)) {
                    append(moreLinkText)
                }
            }
        }
        
        Text(
            text = contentText,
            color = Text2,
            fontSize = 14.sp,
            lineHeight = 18.sp,
            modifier = Modifier.padding(top = 5.dp)
        )
    }
}
