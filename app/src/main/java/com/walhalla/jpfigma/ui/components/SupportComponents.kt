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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.model.*
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun SupportScreenBody(
    modifier: Modifier = Modifier,
    title: String = MockData.SupportScreen.title,
    phonesTitle: String = MockData.SupportScreen.phonesTitle,
    phonesDescription: String = MockData.SupportScreen.phonesDescription,
    phones: List<SupportPhone> = MockData.SupportScreen.phones,
    btnInternetCall: String = MockData.SupportScreen.btnInternetCall,
    btnInternetCallHint: String = MockData.SupportScreen.btnInternetCallHint,
    btnCallback: String = MockData.SupportScreen.btnCallback,
    messengersTitle: String = MockData.SupportScreen.messengersTitle,
    messengersDescription: String = MockData.SupportScreen.messengersDescription,
    messengers: List<MessengerLink> = MockData.SupportScreen.messengers,
    socialChannelsTitle: String = MockData.SupportScreen.socialChannelsTitle,
    socialChannels: List<String> = MockData.SupportScreen.socialChannels,
    warningText: String = MockData.SupportScreen.warningText,
    writeSupportTitle: String = MockData.SupportScreen.writeSupportTitle,
    messageLabel: String = MockData.SupportScreen.messageLabel,
    messagePlaceholder: String = MockData.SupportScreen.messagePlaceholder,
    btnSend: String = MockData.SupportScreen.btnSend,
    archiveTitle: String = MockData.SupportScreen.archiveTitle,
    chatMessages: List<SupportChatMessage> = MockData.SupportScreen.chatMessages,
    btnShowMore: String = MockData.SupportScreen.btnShowMore
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .verticalScroll(scrollState)
            .padding(vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = title,
            color = TitleColor,
            fontSize = 22.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        SupportPhonesCard(
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
fun SupportPhonesCard(
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
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(White)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(text = phonesTitle, fontSize = 18.sp, color = TitleColor)
            Text(text = phonesDescription, fontSize = 12.sp, color = Text3, lineHeight = 14.4.sp)
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
                    Text(text = phone.number, fontSize = 17.sp, color = Text2)
                }
            }
        }

        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Button(
                onClick = { },
                modifier = Modifier.fillMaxWidth().height(40.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0FB752)),
                shape = RoundedCornerShape(20.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                    AsyncImageWithPlaceholder(imageUrl = MockData.SupportScreen.iconPhone, modifier = Modifier.size(24.dp))
                    Text(text = btnInternetCall, color = White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    Text(text = btnInternetCallHint, color = White, fontSize = 13.sp)
                }
            }
            OutlinedButton(
                onClick = { },
                modifier = Modifier.fillMaxWidth().height(40.dp),
                border = BorderStroke(1.dp, BrandColor1),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(text = btnCallback, color = BrandColor1, fontSize = 14.sp)
            }
        }

        HorizontalDivider(color = LineColor, thickness = 1.dp)

        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(text = messengersTitle, fontSize = 18.sp, color = TitleColor)
            Text(text = messengersDescription, fontSize = 12.sp, color = Text3, lineHeight = 14.4.sp)
        }

        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            messengers.forEach { link ->
                Row(
                    modifier = Modifier.clickable { },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    SocialIcon(link.type, size = 20.dp)
                    Text(text = link.label, fontSize = 16.sp, color = Text2)
                }
            }
        }

        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(text = socialChannelsTitle, fontSize = 18.sp, color = TitleColor)
            Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                socialChannels.forEach { type ->
                    SocialIcon(type, size = 30.dp)
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, BrandColor2, RoundedCornerShape(20.dp))
                .padding(15.dp)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                AsyncImageWithPlaceholder(imageUrl = MockData.SupportScreen.iconWarning, modifier = Modifier.size(24.dp))
                Text(text = warningText, fontSize = 14.sp, color = Text2, lineHeight = 18.2.sp)
            }
        }
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
            .background(Brush.linearGradient(colors = listOf(Color(0xFFCCE6FF), Color(0xFF95C5F3))))
    ) {
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF041E37),
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 15.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(White)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(text = label, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Text2)
                TextField(
                    value = text,
                    onValueChange = { text = it },
                    placeholder = { Text(text = placeholder, color = Color(0xFF8A9CAF), fontSize = 15.sp) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .border(1.dp, Color(0xFF839AB1), RoundedCornerShape(8.dp)),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFFBFDFF),
                        unfocusedContainerColor = Color(0xFFFBFDFF),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
            }
            OutlinedButton(
                onClick = { },
                modifier = Modifier.fillMaxWidth().height(40.dp),
                border = BorderStroke(1.dp, BrandColor1),
                shape = RoundedCornerShape(20.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    AsyncImageWithPlaceholder(imageUrl = MockData.SupportScreen.iconSend, modifier = Modifier.size(24.dp))
                    Text(text = btnText, color = BrandColor1, fontSize = 15.sp)
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
            .background(Brush.linearGradient(colors = listOf(Color(0xFFCCE6FF), Color(0xFF95C5F3))))
    ) {
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF041E37),
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 15.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(White)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            messages.forEach { msg ->
                SupportChatBubble(msg)
            }
            
            OutlinedButton(
                onClick = { },
                modifier = Modifier.fillMaxWidth().height(40.dp),
                border = BorderStroke(1.dp, BrandColor1),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(text = btnText, color = BrandColor1, fontSize = 15.sp)
            }
        }
    }
}

@Composable
fun SupportChatBubble(msg: SupportChatMessage) {
    val alignment = if (msg.isOperator) Alignment.Start else Alignment.End
    val bubbleColor = if (msg.isOperator) Color(0xFFE8F3FB) else Color(0xFFFBF0E8)
    val shape = if (msg.isOperator) {
        RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp, bottomStart = 20.dp, bottomEnd = 20.dp)
        // Adjusting for actual Figma look (no top left corner for operator usually, or vice versa)
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
                AsyncImageWithPlaceholder(imageUrl = MockData.SupportScreen.iconOperator, modifier = Modifier.size(18.dp))
            }
            Text(text = msg.author, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Text2)
            Text(text = msg.timestamp, fontSize = 13.sp, color = Text3)
            if (msg.status == "read") {
                AsyncImageWithPlaceholder(imageUrl = MockData.SupportScreen.iconStatusRead, modifier = Modifier.size(20.dp))
            }
        }
        Box(
            modifier = Modifier
                .clip(shape)
                .background(bubbleColor)
                .padding(15.dp)
        ) {
            Text(text = msg.content, fontSize = 16.sp, color = Text2, lineHeight = 20.8.sp)
        }
    }
}

@Composable
fun OperatorIcon(type: String) {
    // Placeholder for operator icons (MKS, +7, etc)
    val iconUrl = when (type) {
        "mks" -> "https://www.figma.com/api/mcp/asset/7c7500bb-0b6f-400f-9634-cc72330d69b8"
        "plus7" -> "https://www.figma.com/api/mcp/asset/f1c5c331-fc49-4310-9f39-a0dd9317b419"
        "cityphone" -> "https://www.figma.com/api/mcp/asset/d1b30fc9-ecb0-4c97-83a3-e0fe544f4941"
        "nadofon" -> "https://www.figma.com/api/mcp/asset/3c83ed0e-c95f-4a1d-9888-08fb07acffb9"
        else -> ""
    }
    AsyncImageWithPlaceholder(imageUrl = iconUrl, modifier = Modifier.size(20.dp))
}

@Composable
fun SocialIcon(type: String, size: androidx.compose.ui.unit.Dp) {
    val iconUrl = when (type) {
        "vk" -> "https://www.figma.com/api/mcp/asset/102e1ddf-32d7-42ad-a9f1-3221c55d841d"
        "telegramm" -> "https://www.figma.com/api/mcp/asset/79b8ab17-729e-4042-aa2b-30492d9d6c48"
        else -> ""
    }
    AsyncImageWithPlaceholder(imageUrl = iconUrl, modifier = Modifier.size(size))
}
