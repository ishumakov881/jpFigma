package com.walhalla.jpfigma.ui.mockScreens

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.walhalla.jpfigma.ui.components.ReferFriendScreenBody
import com.walhalla.jpfigma.ui.model.MockData

@Composable
fun ReferFriendScreen() {
    var bonusSliderValue by remember { mutableStateOf(0.5f) }
    var yourLogin by remember { mutableStateOf("") }
    var friendName by remember { mutableStateOf("") }
    var friendPhone by remember { mutableStateOf("") }
    var friendCity by remember { mutableStateOf("") }
    var friendStreet by remember { mutableStateOf("") }
    var friendHouse by remember { mutableStateOf("") }
    var friendFlat by remember { mutableStateOf("") }
    var friendSource by remember { mutableStateOf("") }
    var friendExtra by remember { mutableStateOf("") }

    ReferFriendScreenBody(
        bonusSliderValue = bonusSliderValue,
        yourLogin = yourLogin,
        friendName = friendName,
        friendPhone = friendPhone,
        friendCity = friendCity,
        friendStreet = friendStreet,
        friendHouse = friendHouse,
        friendFlat = friendFlat,
        friendSource = friendSource,
        friendExtra = friendExtra,
        onBonusSliderChange = { bonusSliderValue = it },
        onYourLoginChange = { yourLogin = it },
        onFriendNameChange = { friendName = it },
        onFriendPhoneChange = { friendPhone = it },
        onFriendCityChange = { friendCity = it },
        onFriendStreetChange = { friendStreet = it },
        onFriendHouseChange = { friendHouse = it },
        onFriendFlatChange = { friendFlat = it },
        onFriendSourceChange = { friendSource = it },
        onFriendExtraChange = { friendExtra = it }
    )
}

@Preview(showBackground = true)
@Composable
fun ReferFriendScreenPreview() {
    ReferFriendScreen()
}
