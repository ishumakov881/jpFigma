package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.Image
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.SubcomposeAsyncImage
import com.walhalla.jpfigma.R
import com.walhalla.jpfigma.ui.theme.*

/**
 * Универсальный компонент для загрузки изображений. 
 * Поддерживает как URL (String), так и локальные ресурсы (Int).
 */
@Composable
fun FigmaImage(
    model: Any?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
    tint: Color? = null
) {
    when (model) {
        is Int -> {
            Image(
                painter = painterResource(id = model),
                contentDescription = null,
                modifier = modifier,
                contentScale = contentScale,
                colorFilter = tint?.let { ColorFilter.tint(it) }
            )
        }
        is String -> {
            SubcomposeAsyncImage(
                model = model,
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
    }
}

/**
 * Старый компонент для обратной совместимости, теперь использует FigmaImage.
 */
@Composable
fun AsyncImageWithPlaceholder(
    imageUrl: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit
) {
    FigmaImage(model = imageUrl, modifier = modifier, contentScale = contentScale)
}

/**
 * Стандартный заголовок экрана с кнопкой назад.
 */
@Composable
fun ScreenHeader(
    title: String,
    onBackClick: () -> Unit = {},
    backIconRes: Int = R.drawable.ic_back_arrow,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        FigmaImage(
            model = backIconRes,
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
 * Элемент списка с буллитом.
 */
@Composable
fun BulletListItem(
    text: String,
    modifier: Modifier = Modifier,
    iconRes: Int = R.drawable.ic_bullet_dot,
    iconSize: Dp = 20.dp
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.Top
    ) {
        FigmaImage(
            model = iconRes,
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
    iconRes: Int = R.drawable.ic_warning
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, FigmaBrandOrange, RoundedCornerShape(20.dp))
            .padding(15.dp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            FigmaImage(model = iconRes, modifier = Modifier.size(24.dp))
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
 * Маленькая кнопка действий со стрелочкой.
 */
@Composable
fun ActionDetailsButton(
    text: String,
    onClick: () -> Unit = {},
    iconRes: Int = R.drawable.ic_arrow_right_blue,
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
        FigmaImage(model = iconRes, modifier = Modifier.size(18.dp))
    }
}
