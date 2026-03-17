package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
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
import com.walhalla.jpfigma.R
import com.walhalla.jpfigma.ui.model.*
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun LinkedAccountsScreenBody(
    mainAccount: LinkedAccount,
    linkedAccounts: List<LinkedAccount>,
    modifier: Modifier = Modifier,
    onLinkAccountClick: () -> Unit = {},
    onActionClick: (LinkedAccount, AccountAction) -> Unit = { _, _ -> }
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(FigmaBackgroundGray)
            .verticalScroll(scrollState)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // Title
        Text(
            text = "Услуга “Связанные аккаунты”",
            color = FigmaTitleColor,
            fontSize = 22.sp,
            lineHeight = 24.2.sp
        )

        // Description
        Text(
            text = buildAnnotatedString {
                append("\"Связанные аккаунты\" - удобное решение для управления несколькими  лицевыми счетами. Все счета в одном профиле: контролируйте баланс и  оплачивайте быстро и просто. Более подробно с услугой можно ознакомиться ")
                withStyle(SpanStyle(color = FigmaBrandBlue)) {
                    append("здесь")
                }
                append(".")
            },
            color = FigmaTextPrimary,
            fontSize = 14.sp,
            lineHeight = 18.2.sp
        )

        // Free Service Notice
        Text(
            text = buildAnnotatedString {
                withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Услуга “Связанные аккаунты” предоставляется ")
                }
                withStyle(SpanStyle(color = FigmaSuccessGreen, fontWeight = FontWeight.Bold)) {
                    append("бесплатно")
                }
            },
            color = FigmaTextPrimary,
            fontSize = 16.sp,
            lineHeight = 17.6.sp
        )

        // Main Account Card
        AccountInfoCard(
            account = mainAccount,
            onActionClick = { onActionClick(mainAccount, it) }
        )

        // Linked Accounts Section Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = "Ваши связанные аккаунты",
                color = FigmaTitleColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.weight(1f)
            )
            
            // View Toggle Icons
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(FigmaCardWhite),
                    contentAlignment = Alignment.Center
                ) {
                    FigmaImage(model = R.drawable.ic_list, modifier = Modifier.size(24.dp))
                }
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(Color(0xFFCFDAE4)),
                    contentAlignment = Alignment.Center
                ) {
                    FigmaImage(model = R.drawable.ic_grid, modifier = Modifier.size(24.dp))
                }
            }
        }

        // Linked Accounts List
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(FigmaCardWhite)
        ) {
            linkedAccounts.forEachIndexed { index, account ->
                AccountInfoCard(
                    account = account,
                    onActionClick = { onActionClick(account, it) },
                    modifier = Modifier.background(FigmaCardWhite)
                )
                if (index < linkedAccounts.size - 1) {
                    HorizontalDivider(
                        modifier = Modifier.padding(horizontal = 20.dp),
                        thickness = 1.dp,
                        color = FigmaLineColor
                    )
                }
            }
        }

        // Link New Account Button
        Button(
            onClick = onLinkAccountClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            colors = ButtonDefaults.buttonColors(containerColor = FigmaBrandBlue),
            shape = RoundedCornerShape(20.dp),
            contentPadding = PaddingValues(0.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                FigmaImage(model = R.drawable.ic_plus, modifier = Modifier.size(24.dp))
                Text(
                    text = "Привязать аккаунт",
                    color = FigmaCardWhite,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun AccountInfoCard(
    account: LinkedAccount,
    onActionClick: (AccountAction) -> Unit,
    modifier: Modifier = Modifier
) {
    FigmaCard(
        modifier = modifier,
        cornerRadius = 20.dp,
        padding = 20.dp
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                if (account.type != AccountType.MAIN) {
                    FigmaImage(model = R.drawable.ic_linked, modifier = Modifier.size(24.dp))
                }
                Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                    Text(
                        text = account.name,
                        color = FigmaTitleColor,
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
                AccountBalanceSection(
                    balance = account.balance,
                    paidUntil = account.paidUntil,
                    colorType = if (account.isAlert) BalanceColorType.RED else account.balanceColorType,
                    isPaidFromMain = account.isPaidFromMain
                )

                Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                    AccountDetailItem(label = "Лицевой счет:", value = account.accountNumber)
                    AccountDetailItem(label = "Тарифный план:", value = account.tariff)
                    if (account.linkedCount != null) {
                        AccountDetailItem(label = "Привязанных аккаунтов:", value = account.linkedCount.toString())
                    }
                }

                if (account.actions.isNotEmpty()) {
                    @OptIn(ExperimentalLayoutApi::class)
                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(20.dp),
                        verticalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        account.actions.forEach { action ->
                            Row(
                                modifier = Modifier.clickable { onActionClick(action) },
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(5.dp)
                            ) {
                                FigmaImage(
                                    model = when (action) {
                                        AccountAction.EDIT -> R.drawable.ic_edit
                                        AccountAction.REFILL -> R.drawable.ic_refill
                                        AccountAction.UNLINK -> R.drawable.ic_unlink
                                        AccountAction.GO_TO -> R.drawable.ic_goto
                                    },
                                    modifier = Modifier.size(20.dp)
                                )
                                Text(
                                    text = action.label,
                                    color = FigmaBrandBlue,
                                    fontSize = 14.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AccountTypeBadge(type: AccountType) {
    val backgroundColor = when (type) {
        AccountType.MAIN -> FigmaSuccessGreen
        AccountType.VIEW_ONLY -> Color(0xFFFAEDE9)
        AccountType.FULL_CONTROL -> Color(0xFFFBDDD5)
        AccountType.FINANCIAL_LINK -> Color(0xFFF3FFEE)
    }
    val textColor = when (type) {
        AccountType.MAIN -> FigmaCardWhite
        AccountType.VIEW_ONLY -> Color(0xFF815E52)
        AccountType.FULL_CONTROL -> FigmaBrandOrange
        AccountType.FINANCIAL_LINK -> FigmaSuccessGreen
    }

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .padding(horizontal = 6.dp, vertical = 2.dp)
    ) {
        Text(
            text = type.label.uppercase(),
            color = textColor,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun AccountBalanceSection(
    balance: String,
    paidUntil: String,
    colorType: BalanceColorType,
    isPaidFromMain: Boolean = false
) {
    val balanceColor = when (colorType) {
        BalanceColorType.GREEN -> FigmaSuccessGreen
        BalanceColorType.RED -> Color(0xFFDB2525)
        BalanceColorType.ORANGE -> Color(0xFFFF8A00)
        BalanceColorType.GREY -> Color(0xFFA7B9CC)
    }

    val paidUntilColor = if (colorType == BalanceColorType.RED) Color(0xFFDB2525) else FigmaTextLight

    Column {
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(
                text = "Баланс:",
                color = FigmaTextPrimary,
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
            color = if (isPaidFromMain) FigmaSuccessGreen else paidUntilColor,
            fontSize = 12.sp,
            fontWeight = if (isPaidFromMain) FontWeight.SemiBold else FontWeight.Normal,
            lineHeight = 15.6.sp
        )
    }
}

@Composable
fun AccountDetailItem(label: String, value: String) {
    Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
        Text(text = label, color = FigmaTextLight, fontSize = 14.sp)
        Text(text = value, color = FigmaTextPrimary, fontSize = 14.sp, fontWeight = FontWeight.Bold)
    }
}
