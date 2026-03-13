package com.walhalla.jpfigma.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.components.*
import com.walhalla.jpfigma.ui.model.MockData
import com.walhalla.jpfigma.ui.theme.*
import com.walhalla.ui0.R

@Composable
fun LinkedAccountsScreen() {
    val data = MockData.LinkedAccountsScreen

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // Title
        Text(
            text = data.screenTitle,
            color = TitleColor,
            fontSize = 22.sp,
            lineHeight = 24.2.sp
        )

        // Description
        Text(
            text = buildAnnotatedString {
                append(data.descriptionPart1)
                withStyle(SpanStyle(color = BrandColor1)) {
                    append(data.descriptionLink)
                }
                append(data.descriptionPart2)
            },
            color = Text2,
            fontSize = 14.sp,
            lineHeight = 18.2.sp
        )

        // Free Service Notice
        Text(
            text = buildAnnotatedString {
                withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(data.freeServiceTitle)
                }
                withStyle(SpanStyle(color = Green, fontWeight = FontWeight.Bold)) {
                    append(data.freeServiceStatus)
                }
            },
            color = Text2,
            fontSize = 16.sp,
            lineHeight = 17.6.sp
        )

        // Main Account Card
        AccountCard(account = data.mainAccount)

        // Linked Accounts Section Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = "Ваши связанные аккаунты",
                color = TitleColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.weight(1f)
            )
            
            // View Toggle Icons (List/Grid)
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(White),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImageWithPlaceholder(
                        imageUrl = R.drawable.ic_list,
                        modifier = Modifier.size(24.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(Color(0xFFCFDAE4)),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImageWithPlaceholder(
                        imageUrl = R.drawable.ic_grid,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }

        // Linked Accounts List
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(White)
        ) {
            data.linkedAccounts.forEachIndexed { index, account ->
                AccountCard(
                    account = account,
                    modifier = Modifier.background(White)
                )
                if (index < data.linkedAccounts.size - 1) {
                    HorizontalDivider(
                        modifier = Modifier.padding(horizontal = 20.dp),
                        thickness = 1.dp,
                        color = LineColor
                    )
                }
            }
        }

        // Link New Account Button
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            colors = ButtonDefaults.buttonColors(containerColor = BrandColor1),
            shape = RoundedCornerShape(20.dp),
            contentPadding = PaddingValues(0.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                AsyncImageWithPlaceholder(
                    imageUrl = R.drawable.ic_plus,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = data.btnLinkAccount,
                    color = White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun LinkedAccountsScreenPreview() {
    LinkedAccountsScreen()
}
