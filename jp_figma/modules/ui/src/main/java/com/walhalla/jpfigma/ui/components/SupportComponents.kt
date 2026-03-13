package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.walhalla.jpfigma.ui.model.*
import com.walhalla.jpfigma.ui.theme.*
import  com.walhalla.ui0.R
@Composable
fun SupportScreenBody(
    title: String,
    phonesTitle: String,
    phonesDescription: String,
    phones: List<SupportPhone>,
    btnInternetCall: String,
    btnInternetCallHint: String,
    btnCallback: String,
    messengersTitle: String,
    messengersDescription: String,
    messengers: List<MessengerLink>,
    socialChannelsTitle: String,
    socialChannels: List<String>,
    warningText: String,
    writeSupportTitle: String,
    messageLabel: String,
    messagePlaceholder: String,
    btnSend: String,
    archiveTitle: String,
    chatMessages: List<SupportChatMessage>,
    btnShowMore: String,
    modifier: Modifier = Modifier
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
        ScreenHeader(title = title)

        FigmaCard(modifier = Modifier.padding(horizontal = 20.dp)) {
            SupportPhonesSection(
                phonesTitle = phonesTitle,
                phonesDescription = phonesDescription,
                phones = phones,
                btnInternetCall = btnInternetCall,
                btnInternetCallHint = btnInternetCallHint,
                btnCallback = btnCallback,
                messengersTitle = messengersTitle,
                messengersDescription = messengersDescription,
                messengers = messengers,
                socialChannelsTitle = socialChannelsTitle,
                socialChannels = socialChannels,
                warningText = warningText
            )
        }

        SupportWriteCard(
            title = writeSupportTitle,
            label = messageLabel,
            placeholder = messagePlaceholder,
            btnText = btnSend
        )

        SupportArchiveCard(
            title = archiveTitle,
            messages = chatMessages,
            btnText = btnShowMore
        )
    }
}

@Composable
fun SupportPhonesSection(
    phonesTitle: String,
    phonesDescription: String,
    phones: List<SupportPhone>,
    btnInternetCall: String,
    btnInternetCallHint: String,
    btnCallback: String,
    messengersTitle: String,
    messengersDescription: String,
    messengers: List<MessengerLink>,
    socialChannelsTitle: String,
    socialChannels: List<String>,
    warningText: String
) {
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(text = phonesTitle, fontSize = 18.sp, color = FigmaTitleColor)
            Text(text = phonesDescription, fontSize = 12.sp, color = FigmaTextSecondary, lineHeight = 14.4.sp)
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
                onClick = { },
                modifier = Modifier.fillMaxWidth().height(40.dp),
                colors = ButtonDefaults.buttonColors(containerColor = FigmaBrandGreen),
                shape = RoundedCornerShape(20.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                    FigmaImage(model = MockData.SupportScreen.iconPhone, modifier = Modifier.size(24.dp))
                    Text(text = btnInternetCall, color = White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    Text(text = btnInternetCallHint, color = White, fontSize = 13.sp)
                }
            }
            OutlinedButton(
                onClick = { },
                modifier = Modifier.fillMaxWidth().height(40.dp),
                border = BorderStroke(1.dp, FigmaBrandBlue),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(text = btnCallback, color = FigmaBrandBlue, fontSize = 14.sp)
            }
        }

        HorizontalDivider(color = FigmaLineColor, thickness = 1.dp)

        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(text = messengersTitle, fontSize = 18.sp, color = FigmaTitleColor)
            Text(text = messengersDescription, fontSize = 12.sp, color = FigmaTextSecondary, lineHeight = 14.4.sp)
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
            Text(text = socialChannelsTitle, fontSize = 18.sp, color = FigmaTitleColor)
            Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                socialChannels.forEach { type ->
                    SocialIcon(type, size = 30.dp)
                }
            }
        }

        WarningBox(text = warningText, iconRes = MockData.SupportScreen.iconWarning)
    }
}

@Composable
fun SupportWriteCard(title: String, label: String, placeholder: String, btnText: String) {
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(FigmaBlueGradient)
    ) {
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF041E37),
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 15.dp)
        )
        FigmaCard(cornerRadius = 20.dp) {
            Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(text = label, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = FigmaTextPrimary)
                    TextField(
                        value = text,
                        onValueChange = { text = it },
                        placeholder = { Text(text = placeholder, color = FigmaTextHint, fontSize = 15.sp) },
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
                    onClick = { },
                    modifier = Modifier.fillMaxWidth().height(40.dp),
                    border = BorderStroke(1.dp, FigmaBrandBlue),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        FigmaImage(model = MockData.SupportScreen.iconSend, modifier = Modifier.size(24.dp))
                        Text(text = btnText, color = FigmaBrandBlue, fontSize = 15.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun SupportArchiveCard(title: String, messages: List<SupportChatMessage>, btnText: String) {
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(FigmaBlueGradient)
    ) {
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF041E37),
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 15.dp)
        )
        FigmaCard(cornerRadius = 20.dp) {
            Column(verticalArrangement = Arrangement.spacedBy(15.dp)) {
                messages.forEach { msg ->
                    SupportChatBubble(msg)
                }
                
                OutlinedButton(
                    onClick = { },
                    modifier = Modifier.fillMaxWidth().height(40.dp),
                    border = BorderStroke(1.dp, FigmaBrandBlue),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(text = btnText, color = FigmaBrandBlue, fontSize = 15.sp)
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
                FigmaImage(model = MockData.SupportScreen.iconOperator, modifier = Modifier.size(18.dp))
            }
            Text(text = msg.author, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = FigmaTextPrimary)
            Text(text = msg.timestamp, fontSize = 13.sp, color = FigmaTextSecondary)
            if (msg.status == "read") {
                FigmaImage(model = MockData.SupportScreen.iconStatusRead, modifier = Modifier.size(20.dp))
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
