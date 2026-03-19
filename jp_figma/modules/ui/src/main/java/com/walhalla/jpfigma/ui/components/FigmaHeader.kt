package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.R
import com.walhalla.jpfigma.ui.theme.ColorFigma

@Composable
fun FigmaHeader(
    modifier: Modifier = Modifier,
    accountNumber: String = "12345678",
    balance: String = "515.33",
    notificationsCount: Int = 52,
    onLogoClick: () -> Unit = {},
    onNotificationsClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(ColorFigma.White),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .width(1600.dp)
                .fillMaxHeight()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Logo and Title
            Row(
                modifier = Modifier
                    .width(300.dp)
                    .clickable { onLogoClick() },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_toolbar_logo),
                    contentDescription = "Main Logo",
                    modifier = Modifier.size(width = 108.dp, height = 60.dp)
                )
                Text(
                    text = "ЛИЧНЫЙ\nКАБИНЕТ",
                    color = ColorFigma.BrandColor1,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 25.sp
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            // Right side items
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                // Warning
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_toolbar_warning_symbol),
                        contentDescription = "Warning",
                        modifier = Modifier.size(36.dp)
                    )
                    Text(
                        text = "Внимание!",
                        color = ColorFigma.Red,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                // Notifications
                Row(
                    modifier = Modifier.clickable { onNotificationsClick() },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_toolbar_messages),
                        contentDescription = "Notifications",
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = notificationsCount.toString(),
                        color = ColorFigma.BrandColor2,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                // Account info
                Row(
                    verticalAlignment = Alignment.Baseline,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "Лицевой счёт:",
                        color = ColorFigma.Text3,
                        fontSize = 16.sp
                    )
                    Text(
                        text = accountNumber,
                        color = ColorFigma.Text1,
                        fontSize = 24.sp
                    )
                }

                // Balance info
                Row(
                    verticalAlignment = Alignment.Baseline,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "Ваш баланс:",
                        color = ColorFigma.Text3,
                        fontSize = 16.sp
                    )
                    Row(
                        verticalAlignment = Alignment.Baseline,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Text(
                            text = balance,
                            color = ColorFigma.Green,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "₽",
                            color = ColorFigma.Green,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}
