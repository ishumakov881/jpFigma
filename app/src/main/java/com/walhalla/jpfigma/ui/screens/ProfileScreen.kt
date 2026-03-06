package com.walhalla.jpfigma.ui.screens

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.walhalla.jpfigma.ui.components.PhoneData
import com.walhalla.jpfigma.ui.components.ProfileScreenBody
import com.walhalla.jpfigma.ui.model.MockData
import com.walhalla.jpfigma.ui.theme.JpFigmaTheme

@Composable
fun ProfileScreen() {
    val profile = MockData.ProfileScreen.profile
    val phones = profile.phones.map {
        PhoneData(it.number, it.isPrimary, it.isActualized)
    }

    var oldPassword by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    ProfileScreenBody(
        accountNumber = profile.accountNumber,
        fullName = profile.fullName,
        address = profile.address,
        phones = phones,
        oldPassword = oldPassword,
        newPassword = newPassword,
        confirmPassword = confirmPassword,
        onOldPasswordChange = { oldPassword = it },
        onNewPasswordChange = { newPassword = it },
        onConfirmPasswordChange = { confirmPassword = it },
        onSavePasswordClick = {},
        onAddPhoneClick = {},
        onDeletePhoneClick = {},
        onMakePrimaryClick = {},
        onActualizePhoneClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    JpFigmaTheme {
        ProfileScreen()
    }
}
