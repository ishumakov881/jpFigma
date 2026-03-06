package com.walhalla.jpfigma.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material.icons.filled.RemoveCircleOutline
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.ui.model.PaymentTransaction
import com.walhalla.jpfigma.ui.theme.*

@Composable
fun PaymentTransactionItem(
    modifier: Modifier = Modifier,
    transaction: PaymentTransaction
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        // Icon indicating income or expense
        Icon(
            imageVector = if (transaction.isIncome) Icons.Default.AddCircleOutline else Icons.Default.RemoveCircleOutline,
            contentDescription = null,
            tint = if (transaction.isIncome) Green else Color.Red,
            modifier = Modifier.size(32.dp)
        )

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = transaction.date,
                color = Text3,
                fontSize = 12.sp
            )
            Text(
                text = transaction.description,
                color = Text1,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(top = 2.dp)
            )
        }

        Column(horizontalAlignment = Alignment.End) {
            Text(
                text = (if (transaction.isIncome) "+" else "-") + " ${transaction.amount} ₽",
                color = if (transaction.isIncome) Green else Text1,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            if (transaction.balanceAfter != null) {
                Text(
                    text = "Остаток: ${transaction.balanceAfter} ₽",
                    color = Text3,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
fun PaymentInputField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    suffix: String? = null
) {
    Surface(
        modifier = modifier
            .height(56.dp)
            .shadow(elevation = 6.dp, shape = RoundedCornerShape(5.dp), clip = false, ambientColor = Color(0x40003E6D), spotColor = Color(0x40003E6D)),
        shape = RoundedCornerShape(5.dp),
        color = Color.White
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 15.dp, vertical = 10.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = label, color = Text3, fontSize = 14.sp)
                BasicTextField(
                    value = value,
                    onValueChange = onValueChange,
                    textStyle = LocalTextStyle.current.copy(
                        color = Text2,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
            if (suffix != null) {
                Text(
                    text = suffix,
                    color = Text2,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
        }
    }
}

@Composable
fun OnlinePaymentCard(
    modifier: Modifier = Modifier,
    accountNumber: String,
    onAccountChange: (String) -> Unit,
    amount: String,
    onAmountChange: (String) -> Unit,
    email: String,
    onEmailChange: (String) -> Unit,
    onPayClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(LightBlueBg, RoundedCornerShape(20.dp))
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Text(
            text = "Оплата онлайн",
            modifier = Modifier.fillMaxWidth(),
            color = TitleColor,
            fontSize = 20.sp
        )
        
        Text(
            text = "Введите номер Вашего лицевого счета и сумму платежа",
            modifier = Modifier.fillMaxWidth(),
            color = TitleColor,
            fontSize = 14.sp
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            PaymentInputField(
                modifier = Modifier.weight(1.2f),
                label = "Лицевой счёт",
                value = accountNumber,
                onValueChange = onAccountChange
            )
            PaymentInputField(
                modifier = Modifier.weight(0.8f),
                label = "Сумма",
                value = amount,
                onValueChange = onAmountChange,
                suffix = "Р"
            )
        }

        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(text = "E-mail (необязательно)", color = Text2, fontSize = 16.sp)
            PaymentInputField(
                label = "E-mail",
                value = email,
                onValueChange = onEmailChange
            )
        }

        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            color = Color.White
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                Text(text = "Сумма платежа", color = TitleColor, fontSize = 18.sp)
                
                Text(
                    text = "$amount Р",
                    color = TitleColor,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )

                Button(
                    onClick = onPayClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = BrandColor1),
                    shape = RoundedCornerShape(30.dp)
                ) {
                    Text(text = "Оплатить", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }

                Text(
                    text = "Нажимая на кнопку \"Оплатить\", Вы соглашаетесь с условиями на обработку персональных данных",
                    color = Color(0xFF687F8F),
                    fontSize = 13.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 16.sp
                )
            }
        }
    }
}
