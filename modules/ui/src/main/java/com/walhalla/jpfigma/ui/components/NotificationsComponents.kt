package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.SubcomposeAsyncImage
import com.walhalla.jpfigma.ui.model.SettingItem
import com.walhalla.jpfigma.ui.model.SettingsGroup
import com.walhalla.jpfigma.ui.theme.*
import com.walhalla.ui0.R

@Composable
fun AsyncImageWithPlaceholder0(
    imageUrl: String,
    modifier: Modifier = Modifier,
    contentDescription: String? = null
) {
    SubcomposeAsyncImage(
        model = imageUrl,
        loading = {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(modifier = Modifier.size(12.dp), strokeWidth = 1.dp)
            }
        },
        error = {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                // Placeholder for error
                Box(Modifier.size(8.dp).background(Color.LightGray))
            }
        },
        contentDescription = contentDescription,
        contentScale = ContentScale.Fit,
        modifier = modifier
    )
}

@Composable
fun InfoCard(
    description: String,
    advantagesTitle: String,
    advantages: List<String>,
    warningTextPrefix: String,
    warningTextSuffix: String,
    imgCheck: Int,
    imgWarning: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(30.dp))
            .background(White)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = description,
            color = Text2,
            fontSize = 14.sp,
            lineHeight = 18.2.sp
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = advantagesTitle,
                color = Color(0xFF041E37),
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 20.sp
            )
            advantages.forEach { advantage ->
                AdvantageItem(text = advantage, imgCheck = imgCheck)
            }
        }

        WarningCard(
            prefix = warningTextPrefix,
            suffix = warningTextSuffix,
            imgWarning = imgWarning
        )
    }
}

@Composable
fun AdvantageItem(
    text: String,
    imgCheck: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        AsyncImageWithPlaceholder(
            imageUrl = imgCheck,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = text,
            color = Text2,
            fontSize = 14.sp,
            lineHeight = 18.2.sp,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun WarningCard(
    prefix: String,
    suffix: String,
    imgWarning: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = BrandColor2,
                shape = RoundedCornerShape(20.dp)
                // Note: Compose doesn't support dashed borders natively easily without custom DrawScope
                // For simplicity and adhering to rules, using standard border.
            )
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        AsyncImageWithPlaceholder(
            imageUrl = imgWarning,
            modifier = Modifier.size(48.dp)
        )
        Text(
            text = buildAnnotatedString {
                withStyle(SpanStyle(color = BrandColor2, fontWeight = FontWeight.SemiBold)) {
                    append(prefix)
                }
                withStyle(SpanStyle(color = Text2)) {
                    append(suffix)
                }
            },
            fontSize = 14.sp,
            lineHeight = 18.2.sp,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun SettingsHeader(
    title: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(Color(0xFFCCE6FF), Color(0xFF95C5F3))
                )
            )
            .padding(horizontal = 20.dp, vertical = 15.dp)
    ) {
        Text(
            text = title,
            color = Color(0xFF041E37),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 22.5.sp
        )
    }
}

@Composable
fun SettingsGroupBlock(
    group: SettingsGroup,
    imgCheck: Int,

    imgQuestion: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = group.title,
            color = TitleColor,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            group.items.forEach { item ->
                SettingRow(
                    item = item,
                    imgCheck = imgCheck,
                    imgNotAvailable = R.drawable.ic_not_available,
                    imgQuestion = imgQuestion
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Button(
                onClick = { },
                modifier = Modifier
                    .width(200.dp)
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(containerColor = BrandColor1),
                shape = RoundedCornerShape(20.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = group.actionText,
                    color = White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(
                text = group.price,
                color = TitleColor,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun SettingRow(
    item: SettingItem,
    imgCheck: Int,
    imgNotAvailable: Int,
    imgQuestion: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        AsyncImageWithPlaceholder(
            imageUrl = if (item.isAvailable) imgCheck else imgNotAvailable,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = item.text,
            color = TitleColor,
            fontSize = 14.sp,
            modifier = Modifier.weight(1f)
        )
        if (item.label != null) {
            Text(
                text = item.label,
                color = Green,
                fontSize = 14.sp
            )
        }
        AsyncImageWithPlaceholder(
            imageUrl = imgQuestion,
            modifier = Modifier.size(20.dp)
        )
    }
}
