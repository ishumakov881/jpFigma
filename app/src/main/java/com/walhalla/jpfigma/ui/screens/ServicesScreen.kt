package com.walhalla.jpfigma.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.components.*
import com.walhalla.jpfigma.ui.model.*
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun ServicesScreen(
    modifier: Modifier = Modifier
) {
    val paidServices = MockData.getPaidServices()
    val freeServices = MockData.getFreeServices()

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF4F7FB)),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                text = "Услуги",
                color = TitleColor,
                fontSize = 22.sp,
                modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp)
            )
        }

        // Paid Services
        item {
            AccountCard(
                title = "Платные услуги",
                gradient = Brush.linearGradient(listOf(Color(0xFFCCE6FF), Color(0xFF95C5F3))),
                horizontalPadding = 0.dp
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    paidServices.forEachIndexed { index, service ->
                        ServiceListItem(service = service)
                        if (index < paidServices.size - 1) {
                            HorizontalDivider(color = LineColor)
                        }
                    }
                }
            }
        }

        // Free Services
        item {
            AccountCard(
                title = "Бесплатные услуги",
                gradient = Brush.linearGradient(listOf(Color(0xFFCCE6FF), Color(0xFF95C5F3))),
                horizontalPadding = 0.dp
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    freeServices.forEachIndexed { index, service ->
                        ServiceListItem(service = service)
                        if (index < freeServices.size - 1) {
                            HorizontalDivider(color = LineColor)
                        }
                    }
                }
            }
        }
    }
}
