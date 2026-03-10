package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.SubcomposeAsyncImage
import com.walhalla.jpfigma.ui.theme.*

/**
 * Базовый компонент для загрузки изображений с плейсхолдерами.
 */
@Composable
fun AsyncImageWithPlaceholder(
    imageUrl: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit
) {
    SubcomposeAsyncImage(
        model = imageUrl,
        contentDescription = null,
        modifier = modifier,
        contentScale = contentScale,
        loading = {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(modifier = Modifier.size(24.dp), strokeWidth = 2.dp, color = FigmaBrandBlue)
            }
        },
        error = {
            Box(modifier = Modifier.fillMaxSize().background(Color.LightGray.copy(alpha = 0.3f)), contentAlignment = Alignment.Center) {
                Text("Error", fontSize = 10.sp, color = FigmaTextSecondary)
            }
        }
    )
}

/**
 * Стандартный заголовок экрана с кнопкой назад.
 */
@Composable
fun ScreenHeader(
    title: String,
    onBackClick: () -> Unit = {},
    backIconUrl: String = "https://www.figma.com/api/mcp/asset/de9ce478-b1d8-40f4-ac89-35f4f306b693", // Default back arrow
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        AsyncImageWithPlaceholder(
            imageUrl = backIconUrl,
            modifier = Modifier
                .size(24.dp)
                .clickable { onBackClick() }
        )
        Text(
            text = title,
            fontSize = 22.sp,
            color = FigmaTitleColor,
            fontWeight = FontWeight.Normal
        )
    }
}

/**
 * Универсальная карточка в стиле Figma.
 */
@Composable
fun FigmaCard(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 20.dp,
    backgroundColor: Color = FigmaCardWhite,
    padding: Dp = 20.dp,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(cornerRadius))
            .background(backgroundColor)
            .padding(padding),
        content = content
    )
}

/**
 * Элемент списка с буллитом (точкой или иконкой).
 */
@Composable
fun BulletListItem(
    text: String,
    modifier: Modifier = Modifier,
    iconUrl: String = "https://www.figma.com/api/mcp/asset/cd9112fc-eaf5-4fa8-a564-de1d8f1725b4", // Default dot
    iconSize: Dp = 20.dp
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.Top
    ) {
        AsyncImageWithPlaceholder(
            imageUrl = iconUrl,
            modifier = Modifier
                .size(iconSize)
                .padding(top = 2.dp)
        )
        Text(
            text = text,
            fontSize = 14.sp,
            color = FigmaTextPrimary,
            lineHeight = 18.2.sp
        )
    }
}

/**
 * Информационный блок с предупреждением.
 */
@Composable
fun WarningBox(
    text: String,
    modifier: Modifier = Modifier,
    iconUrl: String = "https://www.figma.com/api/mcp/asset/d8c079e7-eb12-4d09-b9de-a123d83b58e9"
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, FigmaBrandOrange, RoundedCornerShape(20.dp))
            .padding(15.dp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            AsyncImageWithPlaceholder(imageUrl = iconUrl, modifier = Modifier.size(24.dp))
            Text(
                text = text,
                fontSize = 14.sp,
                color = FigmaTextPrimary,
                lineHeight = 18.2.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

/**
 * Маленькая кнопка действий со стрелочкой (Детальнее, Перейти).
 */
@Composable
fun ActionDetailsButton(
    text: String,
    onClick: () -> Unit = {},
    iconUrl: String = "https://www.figma.com/api/mcp/asset/33a1936a-8799-4609-87fa-9701fb09c0a0",
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .height(40.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(FigmaSecondaryBtnBg)
            .padding(horizontal = 20.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(text = text, color = FigmaBrandBlue, fontSize = 15.sp)
        AsyncImageWithPlaceholder(imageUrl = iconUrl, modifier = Modifier.size(18.dp))
    }
}
