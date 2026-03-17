package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.R
import com.walhalla.jpfigma.ui.model.*
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun SupportScreenBody(
    phones: List<SupportPhone>,
    messengers: List<MessengerLink>,
    chatMessages: List<SupportChatMessage>,
    modifier: Modifier = Modifier,
    onInternetCallClick: () -> Unit = {},
    onCallbackClick: () -> Unit = {},
    onSendMessageClick: (String) -> Unit = {},
    onShowMoreMessagesClick: () -> Unit = {}
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(FigmaBackgroundGray)
            .verticalScroll(scrollState)
            .padding(vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        ScreenHeader(title = "Техподдержка")

        FigmaCard(modifier = Modifier.padding(horizontal = 20.dp)) {
            SupportPhonesSection(
                phones = phones,
                messengers = messengers,
                onInternetCallClick = onInternetCallClick,
                onCallbackClick = onCallbackClick
            )
        }

        SupportWriteSection(onSendClick = onSendMessageClick)

        SupportArchiveSection(
            messages = chatMessages,
            onShowMoreClick = onShowMoreMessagesClick
        )
    }
}

@Composable
fun SupportPhonesSection(
    phones: List<SupportPhone>,
    messengers: List<MessengerLink>,
    onInternetCallClick: () -> Unit,
    onCallbackClick: () -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(text = "Наши телефоны 24/7", fontSize = 18.sp, color = FigmaTitleColor)
            Text(
                text = "Для улучшения качества обслуживания клиентов и повышения эффективности работы call-центра ваш разговор с оператором может быть записан",
                fontSize = 12.sp, color = FigmaTextSecondary, lineHeight = 14.4.sp
            )
        }

        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            phones.forEach { phone ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    phone.operators.forEach { operator ->
                        OperatorIcon(operator)
                    }
                    Text(text = phone.number, fontSize = 17.sp, color = FigmaTextPrimary)
                }
            }
        }

        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Button(
                onClick = onInternetCallClick,
                modifier = Modifier.fillMaxWidth().height(40.dp),
                colors = ButtonDefaults.buttonColors(containerColor = FigmaBrandGreen),
                shape = RoundedCornerShape(20.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                    FigmaImage(model = R.drawable.ic_support_phone, modifier = Modifier.size(24.dp))
                    Text(text = "Интернет звонок", color = White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    Text(text = "(бесплатно)", color = White, fontSize = 13.sp)
                }
            }
            OutlinedButton(
                onClick = onCallbackClick,
                modifier = Modifier.fillMaxWidth().height(40.dp),
                border = BorderStroke(1.dp, FigmaBrandBlue),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(text = "Заказать обратный звонок", color = FigmaBrandBlue, fontSize = 14.sp)
            }
        }

        HorizontalDivider(color = FigmaLineColor, thickness = 1.dp)

        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(text = "Мессенджеры", fontSize = 18.sp, color = FigmaTitleColor)
            Text(
                text = "Для быстрого и удобного доступа к техподдержке online Вы можете воспользоваться виджетом, размещённым в нижнем правом углу сайта.",
                fontSize = 12.sp, color = FigmaTextSecondary, lineHeight = 14.4.sp
            )
        }

        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            messengers.forEach { link ->
                Row(
                    modifier = Modifier.clickable { },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    SocialIcon(link.type, size = 20.dp)
                    Text(text = link.label, fontSize = 16.sp, color = FigmaTextPrimary)
                }
            }
        }

        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(text = "Официальные каналы", fontSize = 18.sp, color = FigmaTitleColor)
            Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                SocialIcon("vk", size = 30.dp)
                SocialIcon("telegramm", size = 30.dp)
            }
        }

        WarningBox(
            text = "Для улучшения качества обслуживания клиентов и повышения эффективности работы call-центра Ваш разговор с оператором может быть записан.",
            iconRes = R.drawable.ic_support_warning
        )
    }
}

@Composable
fun SupportWriteSection(onSendClick: (String) -> Unit) {
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(FigmaBlueGradient)
    ) {
        Text(
            text = "Написать в техподдержку",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = FigmaDarkTitle,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 15.dp)
        )
        FigmaCard(cornerRadius = 20.dp) {
            Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(text = "Сообщение", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = FigmaTextPrimary)
                    TextField(
                        value = text,
                        onValueChange = { text = it },
                        placeholder = { Text(text = "Введите сообщение...", color = FigmaTextHint, fontSize = 15.sp) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                            .border(1.dp, FigmaInputBorder, RoundedCornerShape(8.dp)),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = FigmaInputBg,
                            unfocusedContainerColor = FigmaInputBg,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(8.dp)
                    )
                }
                OutlinedButton(
                    onClick = { onSendClick(text) },
                    modifier = Modifier.fillMaxWidth().height(40.dp),
                    border = BorderStroke(1.dp, FigmaBrandBlue),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        FigmaImage(model = R.drawable.ic_support_send, modifier = Modifier.size(24.dp))
                        Text(text = "Отправить", color = FigmaBrandBlue, fontSize = 15.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun SupportArchiveSection(messages: List<SupportChatMessage>, onShowMoreClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(FigmaBlueGradient)
    ) {
        Text(
            text = "Архив сообщений",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = FigmaDarkTitle,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 15.dp)
        )
        FigmaCard(cornerRadius = 20.dp) {
            Column(verticalArrangement = Arrangement.spacedBy(15.dp)) {
                messages.forEach { msg ->
                    SupportChatBubble(msg)
                }
                
                OutlinedButton(
                    onClick = onShowMoreClick,
                    modifier = Modifier.fillMaxWidth().height(40.dp),
                    border = BorderStroke(1.dp, FigmaBrandBlue),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(text = "Показать ещё", color = FigmaBrandBlue, fontSize = 15.sp)
                }
            }
        }
    }
}

@Composable
fun SupportChatBubble(msg: SupportChatMessage) {
    val alignment = if (msg.isOperator) Alignment.Start else Alignment.End
    val bubbleColor = if (msg.isOperator) FigmaChatBubbleOperator else FigmaChatBubbleUser
    val shape = if (msg.isOperator) {
        RoundedCornerShape(topStart = 0.dp, topEnd = 20.dp, bottomStart = 20.dp, bottomEnd = 20.dp)
    } else {
        RoundedCornerShape(topStart = 20.dp, topEnd = 0.dp, bottomStart = 20.dp, bottomEnd = 20.dp)
    }

    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = alignment) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier.padding(bottom = 5.dp)
        ) {
            if (msg.isOperator) {
                FigmaImage(model = R.drawable.ic_support_operator, modifier = Modifier.size(18.dp))
            }
            Text(text = msg.author, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = FigmaTextPrimary)
            Text(text = msg.timestamp, fontSize = 13.sp, color = FigmaTextSecondary)
            if (msg.status == "read") {
                FigmaImage(model = R.drawable.ic_status_read, modifier = Modifier.size(20.dp))
            }
        }
        Box(
            modifier = Modifier
                .clip(shape)
                .background(bubbleColor)
                .padding(15.dp)
        ) {
            Text(text = msg.content, fontSize = 16.sp, color = FigmaTextPrimary, lineHeight = 20.8.sp)
        }
    }
}

@Composable
fun OperatorIcon(type: String) {
    val iconRes = when (type) {
        "mks" -> R.drawable.ic_op_mks
        "plus7" -> R.drawable.ic_op_plus7
        "cityphone" -> R.drawable.ic_op_cityphone
        "nadofon" -> R.drawable.ic_op_nadofon
        else -> 0
    }
    if (iconRes != 0) {
        FigmaImage(model = iconRes, modifier = Modifier.size(20.dp))
    }
}

@Composable
fun SocialIcon(type: String, size: androidx.compose.ui.unit.Dp) {
    val iconRes = when (type) {
        "vk" -> R.drawable.ic_vk
        "telegramm" -> R.drawable.ic_telegram
        else -> 0
    }
    if (iconRes != 0) {
        FigmaImage(model = iconRes, modifier = Modifier.size(size))
    }
}
