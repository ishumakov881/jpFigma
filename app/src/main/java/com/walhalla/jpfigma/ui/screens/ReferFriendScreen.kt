package com.walhalla.jpfigma.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.components.AsyncImageWithPlaceholder
import com.walhalla.jpfigma.ui.model.MockData
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun ReferFriendScreen() {
    val data = MockData.ReferFriendScreen
    val scrollState = rememberScrollState()

    // State for inputs
    var myLogin by remember { mutableStateOf("") }
    var friendName by remember { mutableStateOf("") }
    var friendPhone by remember { mutableStateOf("") }
    var friendCity by remember { mutableStateOf("") }
    var friendStreet by remember { mutableStateOf("") }
    var friendHouse by remember { mutableStateOf("") }
    var friendFlat by remember { mutableStateOf("") }
    var friendSource by remember { mutableStateOf("") }
    var additionalInfo by remember { mutableStateOf("") }

    // State for slider (bonus distribution)
    // 0..180. Value represents "My Bonus". Friend's bonus is 180 - Value.
    // Default is usually 50/50 or similar, let's start at 90 (middle).
    var myBonus by remember { mutableFloatStateOf(90f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .verticalScroll(scrollState)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // 1. Screen Title
        Text(
            text = data.screenTitle,
            color = TitleColor,
            fontSize = 26.sp,
            lineHeight = 28.6.sp
        )

        // 2. Info Card
        InfoSection()

        // 3. Bonus Slider Section
        BonusSliderSection(
            myBonus = myBonus,
            onBonusChange = { myBonus = it }
        )

        // 4. Your Data Section
        YourDataSection(
            login = myLogin,
            onLoginChange = { myLogin = it }
        )

        // 5. Friend Data Section
        FriendDataSection(
            friendName = friendName, onFriendNameChange = { friendName = it },
            friendPhone = friendPhone, onFriendPhoneChange = { friendPhone = it },
            friendCity = friendCity, onFriendCityChange = { friendCity = it },
            friendStreet = friendStreet, onFriendStreetChange = { friendStreet = it },
            friendHouse = friendHouse, onFriendHouseChange = { friendHouse = it },
            friendFlat = friendFlat, onFriendFlatChange = { friendFlat = it },
            friendSource = friendSource, onFriendSourceChange = { friendSource = it },
            additionalInfo = additionalInfo, onAdditionalInfoChange = { additionalInfo = it }
        )
    }
}

@Composable
fun InfoSection() {
    val screenData = MockData.ReferFriendScreen

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(White)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        screenData.descriptionParagraphs.forEach { paragraph ->
            Text(
                text = paragraph,
                color = Text2,
                fontSize = 14.sp,
                lineHeight = 18.2.sp
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            screenData.steps.forEach { step ->
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    AsyncImageWithPlaceholder(
                        imageUrl = screenData.imgEllipse,
                        modifier = Modifier.size(20.dp).padding(top = 2.dp)
                    )
                    Text(
                        text = step,
                        color = Text2,
                        fontSize = 14.sp,
                        lineHeight = 18.2.sp
                    )
                }
            }
        }
    }
}

@Composable
fun SectionHeader(number: String, title: String) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(BrandColor1)
                .padding(5.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = number,
                color = White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Text(
            text = title,
            color = TitleColor,
            fontSize = 18.sp,
            lineHeight = 22.5.sp
        )
    }
}

@Composable
fun BonusSliderSection(
    myBonus: Float,
    onBonusChange: (Float) -> Unit
) {
    val screenData = MockData.ReferFriendScreen
    val friendBonus = 180f - myBonus

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(White)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        SectionHeader("1", screenData.section1Title)

        Text(
            text = screenData.section1Subtitle,
            color = Text2,
            fontSize = 14.sp,
            lineHeight = 18.2.sp
        )

        // Values Display
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            // Me
            Row(horizontalArrangement = Arrangement.spacedBy(5.dp), verticalAlignment = Alignment.Bottom) {
                Text(
                    text = "Мне",
                    color = Text2,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = myBonus.toInt().toString(),
                    color = BrandColor1,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "₽",
                    color = BrandColor1,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }

            // Friend
            Row(horizontalArrangement = Arrangement.spacedBy(5.dp), verticalAlignment = Alignment.Bottom) {
                Text(
                    text = "Другу",
                    color = Text2,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = friendBonus.toInt().toString(),
                    color = BrandColor2,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "₽",
                    color = BrandColor2,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }
        }

        // Slider
        Slider(
            value = myBonus,
            onValueChange = { onBonusChange(it) },
            valueRange = 0f..180f,
            steps = 5,
            colors = SliderDefaults.colors(
                thumbColor = White,
                activeTrackColor = BrandColor1,
                inactiveTrackColor = BrandColor2
            ),
            modifier = Modifier.fillMaxWidth()
        )
        
        // Scale Labels (0, 30, 60... 180)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            listOf("0", "30", "60", "90", "120", "150", "180").forEach { label ->
                Text(text = label, color = SecondaryText, fontSize = 12.sp)
            }
        }
    }
}

@Composable
fun YourDataSection(
    login: String,
    onLoginChange: (String) -> Unit
) {
    val screenData = MockData.ReferFriendScreen

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(White)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        SectionHeader("2", screenData.section2Title)

        Text(
            text = buildAnnotatedString {
                withStyle(SpanStyle(color = BrandColor2, fontWeight = FontWeight.Bold)) {
                    append("Внимание! ")
                }
                withStyle(SpanStyle(color = Text2)) {
                    append(screenData.section2Warning.removePrefix("Внимание! "))
                }
            },
            fontSize = 14.sp
        )

        HorizontalDivider(color = LineColor, thickness = 1.dp)

        Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
            LabelWithStar(screenData.section2InputLabel, isRequired = true)
            CustomTextField(
                value = login,
                onValueChange = onLoginChange,
                placeholder = screenData.section2InputPlaceholder
            )
        }
    }
}

@Composable
fun FriendDataSection(
    friendName: String, onFriendNameChange: (String) -> Unit,
    friendPhone: String, onFriendPhoneChange: (String) -> Unit,
    friendCity: String, onFriendCityChange: (String) -> Unit,
    friendStreet: String, onFriendStreetChange: (String) -> Unit,
    friendHouse: String, onFriendHouseChange: (String) -> Unit,
    friendFlat: String, onFriendFlatChange: (String) -> Unit,
    friendSource: String, onFriendSourceChange: (String) -> Unit,
    additionalInfo: String, onAdditionalInfoChange: (String) -> Unit
) {
    val screenData = MockData.ReferFriendScreen

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(White)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        SectionHeader("3", screenData.section3Title)

        Text(
            text = buildAnnotatedString {
                withStyle(SpanStyle(color = BrandColor2, fontWeight = FontWeight.Bold)) {
                    append("Внимание! ")
                }
                withStyle(SpanStyle(color = Text2)) {
                    append(screenData.section3Warning.removePrefix("Внимание! "))
                }
            },
            fontSize = 14.sp
        )

        HorizontalDivider(color = LineColor, thickness = 1.dp)

        // Inputs
        Column(verticalArrangement = Arrangement.spacedBy(15.dp)) {
            InputField(screenData.inputNameLabel, friendName, onFriendNameChange, screenData.inputNamePlaceholder, isRequired = true)
            InputField(screenData.inputPhoneLabel, friendPhone, onFriendPhoneChange, screenData.inputPhonePlaceholder, screenData.inputPhoneHint, isRequired = true, keyboardType = KeyboardType.Phone)
            InputField(screenData.inputCityLabel, friendCity, onFriendCityChange, screenData.inputCityPlaceholder, isRequired = true)
            InputField(screenData.inputStreetLabel, friendStreet, onFriendStreetChange, screenData.inputStreetPlaceholder, screenData.inputStreetHint, isRequired = true)
            
            Row(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
                Box(modifier = Modifier.weight(1f)) {
                    InputField(screenData.inputHouseLabel, friendHouse, onFriendHouseChange, screenData.inputHousePlaceholder, isRequired = true)
                }
                Box(modifier = Modifier.weight(1f)) {
                    InputField(screenData.inputFlatLabel, friendFlat, onFriendFlatChange, screenData.inputFlatPlaceholder)
                }
            }

            InputField(screenData.inputSourceLabel, friendSource, onFriendSourceChange, screenData.inputSourcePlaceholder)
            
            Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                LabelWithStar(screenData.inputInfoLabel)
                CustomTextField(
                    value = additionalInfo,
                    onValueChange = onAdditionalInfoChange,
                    placeholder = screenData.inputInfoPlaceholder,
                    modifier = Modifier.height(100.dp)
                )
            }
        }

        Text(
            text = screenData.requiredFieldsHint,
            color = BrandColor2,
            fontSize = 12.sp
        )

        Button(
            onClick = { /* TODO */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = BrandColor1),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = screenData.submitButtonText, color = White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun InputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    hint: String? = null,
    isRequired: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
        LabelWithStar(label, isRequired)
        CustomTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = placeholder,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
        )
        if (hint != null) {
            Text(text = hint, color = SecondaryText, fontSize = 12.sp)
        }
    }
}

@Composable
fun LabelWithStar(label: String, isRequired: Boolean = false) {
    Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
        Text(text = label, color = Text2, fontSize = 14.sp, fontWeight = FontWeight.Medium)
        if (isRequired) {
            Text(text = "*", color = BrandColor2, fontSize = 14.sp)
        }
    }
}

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        placeholder = { Text(text = placeholder, color = SecondaryText, fontSize = 14.sp) },
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = LineColor,
            focusedBorderColor = BrandColor1,
            unfocusedContainerColor = White,
            focusedContainerColor = White
        ),
        keyboardOptions = keyboardOptions,
        singleLine = modifier == Modifier
    )
}

@Preview(showBackground = true)
@Composable
fun ReferFriendScreenPreview() {
    ReferFriendScreen()
}
