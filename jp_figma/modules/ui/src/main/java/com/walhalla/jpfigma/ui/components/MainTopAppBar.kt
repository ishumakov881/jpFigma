package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.R
import com.walhalla.jpfigma.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopAppBar(
    onMenuClick: () -> Unit,
    messageCount: String,
    modifier: Modifier = Modifier,
    isWarningVisible: Boolean = true
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                FigmaImage(
                    model = R.drawable.ic_toolbar_logo,
                    modifier = Modifier.width(72.dp)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "Личный кабинет",
                    color = FigmaBrandBlue,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = onMenuClick) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_toolbar_menu_burger),
                    contentDescription = "Меню",
                    tint = FigmaBrandBlue
                )
            }
        },
        actions = {
            Row(
                modifier = Modifier.padding(end = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (isWarningVisible) {
                    FigmaImage(
                        model = R.drawable.ic_toolbar_warning_symbol,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = "Внимание!",
                        color = Color(0xFFDB2525),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 5.dp)
                    )
                    Spacer(Modifier.width(20.dp))
                }
                
                FigmaImage(
                    model = R.drawable.ic_toolbar_messages,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(Modifier.width(5.dp))
                Text(
                    text = messageCount,
                    color = Color(0xFFF25B23),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = FigmaCardWhite
        )
    )
}
