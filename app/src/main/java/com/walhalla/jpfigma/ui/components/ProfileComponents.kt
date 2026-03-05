package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.model.PhoneInfo
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun PhoneItem(
    modifier: Modifier = Modifier,
    phone: PhoneInfo,
    onDeleteClick: () -> Unit = {},
    onMakePrimaryClick: () -> Unit = {},
    onActualizeClick: () -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = phone.number,
                color = Text2,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            if (phone.isPrimary) {
                Surface(
                    color = Green,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "ОСНОВНОЙ",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Actualization status/button
            if (phone.isActualized) {
                Surface(
                    modifier = Modifier.weight(1f).height(40.dp),
                    color = GreenBg2,
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Default.Check, contentDescription = null, tint = Green, modifier = Modifier.size(20.dp))
                        Spacer(Modifier.width(8.dp))
                        Text(text = "Актуализирован", color = Green, fontSize = 15.sp)
                    }
                }
            } else {
                OutlinedButton(
                    onClick = onActualizeClick,
                    modifier = Modifier.weight(1f).height(40.dp),
                    shape = RoundedCornerShape(20.dp),
                    border = BorderStroke(1.dp, BrandColor1)
                ) {
                    Icon(Icons.Default.Check, contentDescription = null, tint = BrandColor1, modifier = Modifier.size(20.dp))
                    Spacer(Modifier.width(8.dp))
                    Text(text = "Актуализировать", color = BrandColor1, fontSize = 15.sp)
                }
            }

            // Make primary button (if not already)
            if (!phone.isPrimary) {
                OutlinedButton(
                    onClick = onMakePrimaryClick,
                    modifier = Modifier.weight(1f).height(40.dp),
                    shape = RoundedCornerShape(20.dp),
                    border = BorderStroke(1.dp, BrandColor1)
                ) {
                    Text(text = "Сделать основным", color = BrandColor1, fontSize = 15.sp)
                }
            }

            // Delete button
            OutlinedButton(
                onClick = onDeleteClick,
                modifier = Modifier.size(40.dp),
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(1.dp, BrandColor1),
                contentPadding = PaddingValues(0.dp)
            ) {
                Icon(Icons.Default.DeleteOutline, contentDescription = null, tint = BrandColor1)
            }
        }
    }
}

@Composable
fun ProfileInputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String
) {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text(text = label, color = Text2, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(Color(0xFFFBFDFF), RoundedCornerShape(8.dp))
                .border(1.dp, Color(0xFF839AB1), RoundedCornerShape(8.dp))
                .padding(horizontal = 20.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            if (value.isEmpty()) {
                Text(text = placeholder, color = Color(0xFF8A9CAF), fontSize = 15.sp)
            }
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                textStyle = LocalTextStyle.current.copy(color = Text2, fontSize = 15.sp),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
