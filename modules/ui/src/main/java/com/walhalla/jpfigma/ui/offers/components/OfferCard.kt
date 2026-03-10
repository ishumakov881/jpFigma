package com.walhalla.jpfigma.ui.offers.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.SubcomposeAsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade

import com.walhalla.jpfigma.ui.offers.Offer

@Composable
fun OfferCard(
    modifier: Modifier = Modifier,
    offer: Offer,
    onDetailsClick: () -> Unit
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {
            Box(contentAlignment = Alignment.BottomStart) {
                SubcomposeAsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(offer.imageUrl)
                        .crossfade(true)
                        .build(),
                    contentDescription = offer.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(500f / 250f),
                    loading = {
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                    },
                    error = {
                        // Placeholder for error
                    }
                )
                Box(
                    modifier = Modifier
                        .background(
                            Color(0xFFF04E23),
                            shape = RoundedCornerShape(topEnd = 5.dp, bottomEnd = 5.dp)
                        )
                        .padding(horizontal = 20.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = offer.tag,
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Column(
                modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 20.dp, bottom = 15.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = offer.title,
                    color = Color(0xFF060606),
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = offer.description,
                    color = Color(0xFF313E49),
                    fontSize = 14.sp,
                    lineHeight = 18.2.sp // 1.3 * 14
                )
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
                    Button(
                        onClick = onDetailsClick,
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE4F2FF)),
                        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 0.dp),
                        modifier = Modifier.height(32.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Text(
                                text = "Детальнее",
                                color = Color(0xFF1880D0),
                                fontSize = 14.sp
                            )
//                            Icon(
//                                painter = painterResource(id = R.drawable.ic_arrow_forward), // Assuming you have this drawable
//                                contentDescription = null,
//                                tint = Color(0xFF1880D0),
//                                modifier = Modifier.size(18.dp)
//                            )
                        }
                    }
                }
            }
        }
    }
}
