package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.background
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
import com.walhalla.jpfigma.R
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun ReferFriendScreenBody(
    bonusSliderValue: Float,
    yourLogin: String,
    friendName: String,
    friendPhone: String,
    friendCity: String,
    friendStreet: String,
    friendHouse: String,
    friendFlat: String,
    friendSource: String,
    friendExtra: String,
    modifier: Modifier = Modifier,
    onBonusSliderChange: (Float) -> Unit = {},
    onYourLoginChange: (String) -> Unit = {},
    onFriendNameChange: (String) -> Unit = {},
    onFriendPhoneChange: (String) -> Unit = {},
    onFriendCityChange: (String) -> Unit = {},
    onFriendStreetChange: (String) -> Unit = {},
    onFriendHouseChange: (String) -> Unit = {},
    onFriendFlatChange: (String) -> Unit = {},
    onFriendSourceChange: (String) -> Unit = {},
    onFriendExtraChange: (String) -> Unit = {},
    onSubmitClick: () -> Unit = {}
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
        ScreenHeader(title = "Подключи друга")

        FigmaCard(modifier = Modifier.padding(horizontal = 20.dp)) {
            Column(verticalArrangement = Arrangement.spacedBy(15.dp)) {
                Text(
                    text = "Подключите своего друга к ЛДС и получите бонус в виде пополнения счета для себя и для друга. Суммарно бонус составляет 180 руб. Вы и только Вы решаете, какую часть бонуса взять себе, а какую подарить другу!",
                    fontSize = 14.sp, color = FigmaTextPrimary, lineHeight = 18.2.sp
                )
                Text(
                    text = "Двигая бегунок по шкале в ту или иную сторону, Вы сможете выставить размеры бонусов для Вас и Вашего друга в пределах 180 руб.",
                    fontSize = 14.sp, color = FigmaTextPrimary, lineHeight = 18.2.sp
                )
            }
        }

        Text(
            text = "Баланс бонусов",
            color = FigmaDarkTitle,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        FigmaCard(modifier = Modifier.padding(horizontal = 20.dp)) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Text(
                    text = "Передвигайте бегунок, чтоб определить, кому сколько достанется",
                    fontSize = 13.sp, color = FigmaTextSecondary, textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
                
                // Bonus Display
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    BonusCounter(label = "Вам", value = (180 * (1 - bonusSliderValue)).toInt().toString())
                    BonusCounter(label = "Другу", value = (180 * bonusSliderValue).toInt().toString())
                }

                Slider(
                    value = bonusSliderValue,
                    onValueChange = onBonusSliderChange,
                    colors = SliderDefaults.colors(
                        thumbColor = FigmaBrandBlue,
                        activeTrackColor = FigmaBrandBlue,
                        inactiveTrackColor = FigmaLineColor
                    )
                )
            }
        }

        Text(
            text = "Ваши данные",
            color = FigmaDarkTitle,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        FigmaCard(modifier = Modifier.padding(horizontal = 20.dp)) {
            Column(verticalArrangement = Arrangement.spacedBy(15.dp)) {
                WarningText(text = "Внимание! Вы уже должны быть подключены к сети")
                ReferTextField(
                    label = "Введите Ваш лицевой счёт или логин",
                    value = yourLogin,
                    onValueChange = onYourLoginChange,
                    placeholder = "Введите Ваш лицевой счёт или логин"
                )
            }
        }

        Text(
            text = "Данные подключаемого друга",
            color = FigmaDarkTitle,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        FigmaCard(modifier = Modifier.padding(horizontal = 20.dp)) {
            Column(verticalArrangement = Arrangement.spacedBy(15.dp)) {
                WarningText(text = "Внимание! Здесь должны быть указаны данные того человека, которого мы должны подключить!")
                
                ReferTextField(label = "Имя Вашего друга *", value = friendName, onValueChange = onFriendNameChange, placeholder = "Введит имя друга")
                ReferTextField(label = "Мобильный телефон *", value = friendPhone, onValueChange = onFriendPhoneChange, placeholder = "Введите номер телефона", hint = "В формате: +7 959 123 45 67")
                ReferTextField(label = "Населённый пункт *", value = friendCity, onValueChange = onFriendCityChange, placeholder = "Выберите населённый нункт")
                ReferTextField(label = "Квартал / улица *", value = friendStreet, onValueChange = onFriendStreetChange, placeholder = "Квартал / улица", hint = "(введите не менее 3-х символов из названия квартала или улицы)")
                
                Row(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
                    ReferTextField(label = "Дом *", value = friendHouse, onValueChange = onFriendHouseChange, placeholder = "Номер дома", modifier = Modifier.weight(1f))
                    ReferTextField(label = "Квартира", value = friendFlat, onValueChange = onFriendFlatChange, placeholder = "Номер квартиры", modifier = Modifier.weight(1f))
                }

                ReferTextField(label = "Откуда узнали", value = friendSource, onValueChange = onFriendSourceChange, placeholder = "Выберите вариант")
                ReferTextField(label = "Дополнительная информация", value = friendExtra, onValueChange = onFriendExtraChange, placeholder = "Дополнительная информация")

                Text(text = "* - поля обязательны для заполнения", color = FigmaTextHint, fontSize = 12.sp)

                Button(
                    onClick = onSubmitClick,
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = FigmaBrandBlue),
                    shape = RoundedCornerShape(25.dp)
                ) {
                    Text(text = "Оставить заявку", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun BonusCounter(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = label, color = FigmaTextSecondary, fontSize = 14.sp)
        Row(verticalAlignment = Alignment.Bottom) {
            Text(text = value, color = FigmaBrandBlue, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(text = " ₽", color = FigmaBrandBlue, fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 4.dp))
        }
    }
}

@Composable
fun WarningText(text: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        FigmaImage(model = R.drawable.ic_warning, modifier = Modifier.size(24.dp))
        Text(text = text, color = FigmaBrandOrange, fontSize = 14.sp, fontWeight = FontWeight.Bold, lineHeight = 18.2.sp)
    }
}

@Composable
fun ReferTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    hint: String? = null
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(5.dp)) {
        Text(text = label, color = FigmaTextLight, fontSize = 14.sp)
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = placeholder, color = FigmaTextHint, fontSize = 14.sp) },
            shape = RoundedCornerShape(8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = FigmaBrandBlue,
                unfocusedBorderColor = FigmaLineColor
            )
        )
        if (hint != null) {
            Text(text = hint, color = FigmaTextHint, fontSize = 11.sp)
        }
    }
}
