package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.model.*
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun AccountTypeBadge(
    type: AccountType,
    modifier: Modifier = Modifier
) {
    val backgroundColor = when (type) {
        AccountType.MAIN -> Green
        AccountType.VIEW_ONLY -> Color(0xFFFAEDE9)
        AccountType.FULL_CONTROL -> Color(0xFFFBDDD5)
        AccountType.FINANCIAL_LINK -> Color(0xFFF3FFEE)
    }
    val textColor = when (type) {
        AccountType.MAIN -> White
        AccountType.VIEW_ONLY -> Color(0xFF815E52)
        AccountType.FULL_CONTROL -> BrandColor2
        AccountType.FINANCIAL_LINK -> Green
    }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .padding(horizontal = 6.dp, vertical = 2.dp)
    ) {
        Text(
            text = type.label.uppercase(),
            color = textColor,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 13.75.sp
        )
    }
}

@Composable
fun AccountBalance(
    balance: String,
    paidUntil: String,
    colorType: BalanceColorType,
    isPaidFromMain: Boolean = false,
    modifier: Modifier = Modifier
) {
    val balanceColor = when (colorType) {
        BalanceColorType.GREEN -> Green
        BalanceColorType.RED -> Color(0xFFDB2525)
        BalanceColorType.ORANGE -> Color(0xFFFF8A00)
        BalanceColorType.GREY -> Color(0xFFA7B9CC)
    }

    val paidUntilColor = if (colorType == BalanceColorType.RED) Color(0xFFDB2525) else SecondaryText

    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(
                text = "Баланс:",
                color = Text2,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 2.dp)
            )
            Text(
                text = balance,
                color = balanceColor,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "₽",
                color = balanceColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 2.dp)
            )
        }
        Text(
            text = paidUntil,
            color = if (isPaidFromMain) Green else paidUntilColor,
            fontSize = if (isPaidFromMain) 12.sp else 12.sp,
            fontWeight = if (isPaidFromMain) FontWeight.SemiBold else FontWeight.Normal,
            lineHeight = 15.6.sp
        )
    }
}

@Composable
fun AccountDetailRow(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            color = SecondaryText,
            fontSize = 14.sp
        )
        Text(
            text = value,
            color = Text2,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun AccountCard(
    account: LinkedAccount,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(White)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            if (account.type != AccountType.MAIN) {
                AsyncImageWithPlaceholder(
                    imageUrl = MockData.LinkedAccountsScreen.iconLinked,
                    modifier = Modifier.size(24.dp)
                )
            }
            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Text(
                    text = account.name,
                    color = TitleColor,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                AccountTypeBadge(type = account.type)
            }
        }

        val contentPadding = if (account.type == AccountType.MAIN) 0.dp else 34.dp

        Column(
            modifier = Modifier.padding(start = contentPadding),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            AccountBalance(
                balance = account.balance,
                paidUntil = account.paidUntil,
                colorType = if (account.isAlert) BalanceColorType.RED else account.balanceColorType,
                isPaidFromMain = account.isPaidFromMain
            )

            Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                AccountDetailRow(label = "Лицевой счет:", value = account.accountNumber)
                AccountDetailRow(label = "Тарифный план:", value = account.tariff)
                if (account.linkedCount != null) {
                    AccountDetailRow(label = "Привязанных аккаунтов:", value = account.linkedCount.toString())
                }
            }

            if (account.actions.isNotEmpty()) {
                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    verticalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    account.actions.forEach { action ->
                        AccountActionLink(action = action)
                    }
                }
            }
        }
    }
}

@Composable
fun AccountActionLink(
    action: AccountAction,
    modifier: Modifier = Modifier
) {
    val iconUrl = when (action) {
        AccountAction.EDIT -> MockData.LinkedAccountsScreen.iconEdit
        AccountAction.REFILL -> MockData.LinkedAccountsScreen.iconRefill
        AccountAction.UNLINK -> MockData.LinkedAccountsScreen.iconUnlink
        AccountAction.GO_TO -> MockData.LinkedAccountsScreen.iconGoTo
    }

    Row(
        modifier = modifier.clickable { },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        AsyncImageWithPlaceholder(
            imageUrl = iconUrl,
            modifier = Modifier.size(20.dp)
        )
        Text(
            text = action.label,
            color = BrandColor1,
            fontSize = 14.sp
        )
    }
}
