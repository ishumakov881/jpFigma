package com.walhalla.jpfigma.ui.offers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.walhalla.jpfigma.ui.offers.components.OfferCard

@Composable
fun OffersScreen(
    offers: List<Offer>,
    onOfferClick: (Offer) -> Unit
) {
    OffersScreenBody(
        offers = offers,
        onOfferClick = onOfferClick
    )
}

@Composable
fun OffersScreenBody(
    modifier: Modifier = Modifier,
    offers: List<Offer>,
    onOfferClick: (Offer) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        contentPadding = PaddingValues(vertical = 20.dp)
    ) {
        item {
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    text = "Доступные акции",
                    color = Color(0xFF060606),
                    fontSize = 22.sp,
                    lineHeight = 24.2.sp
                )
                Text(
                    text = "Вам доступны следующие акции и предложения",
                    color = Color(0xFF313E49),
                    fontSize = 16.sp,
                    lineHeight = 20.8.sp
                )
            }
        }
        items(offers) { offer ->
            OfferCard(
                offer = offer,
                onDetailsClick = { onOfferClick(offer) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun OffersScreenPreview() {
//    OffersScreen(
//        offers = emptyList(),
//        onOfferClick = TODO()
//    )
}
