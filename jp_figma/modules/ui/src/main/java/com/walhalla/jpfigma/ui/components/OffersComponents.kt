package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.model.Offer
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun OffersScreenBody(
    offers: List<Offer>,
    modifier: Modifier = Modifier,
    onOfferClick: (Offer) -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(FigmaBackgroundGray)
            .padding(horizontal = 20.dp)
    ) {
        Spacer(Modifier.height(20.dp))
        Text(
            text = "Доступные акции",
            color = FigmaTitleColor,
            fontSize = 22.sp,
            fontWeight = FontWeight.Normal
        )
        Spacer(Modifier.height(20.dp))
        
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(offers) { offer ->
                OfferCard(
                    offer = offer,
                    onClick = { onOfferClick(offer) }
                )
            }
        }
    }
}

@Composable
fun OfferCard(
    offer: Offer,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(FigmaCardWhite)
            .clickable { onClick() }
    ) {
        Box(modifier = Modifier.fillMaxWidth().height(100.dp)) {
            FigmaImage(
                model = offer.imageUrl,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Surface(
                color = FigmaBrandOrange,
                shape = RoundedCornerShape(bottomEnd = 10.dp),
                modifier = Modifier.align(Alignment.TopStart)
            ) {
                Text(
                    text = offer.tag,
                    color = Color.White,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = offer.title,
                color = FigmaTextPrimary,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 2
            )
            Text(
                text = offer.description,
                color = FigmaTextSecondary,
                fontSize = 12.sp,
                lineHeight = 15.6.sp,
                maxLines = 3
            )
        }
    }
}
