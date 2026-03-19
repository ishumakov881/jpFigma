package com.walhalla.jpfigma.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walhalla.jpfigma.R
import com.walhalla.jpfigma.ui.components.*
import com.walhalla.jpfigma.ui.theme.ColorFigma

@Composable
fun PaymentMethodsScreenBody(
    modifier: Modifier = Modifier,
    accountNumber: String = "12345678",
    paymentAmount: String = "200",
    emailValue: String = "",
    onPayClick: () -> Unit = {},
    onDetailClick: (String) -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(ColorFigma.MainBg)
    ) {
        FigmaHeader(
            accountNumber = accountNumber,
            onLogoClick = {},
            onNotificationsClick = {}
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentPadding = PaddingValues(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Column(
                    modifier = Modifier.width(1600.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    // Title
                    Text(
                        text = "Способы оплаты",
                        color = ColorFigma.TitleColor,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Normal
                    )

                    // Description
                    Text(
                        text = "Оплатить услуги компании Луганские Домашние Сети можно следующими способами:",
                        color = ColorFigma.Text2,
                        fontSize = 16.sp,
                        lineHeight = 20.sp
                    )

                    // Online Payment Section
                    FigmaCard(
                        backgroundColor = ColorFigma.LightBlueBg
                    ) {
                        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                            Text(
                                text = "Оплата онлайн",
                                color = ColorFigma.TitleColor,
                                fontSize = 20.sp
                            )
                            Text(
                                text = "Введите номер Вашего лицевого счета и сумму платежа",
                                color = ColorFigma.Text1,
                                fontSize = 14.sp
                            )
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(20.dp)
                            ) {
                                FigmaInput(
                                    label = "Лицевой счёт",
                                    value = accountNumber,
                                    modifier = Modifier.weight(1f)
                                )
                                FigmaInput(
                                    label = "Сумма",
                                    value = paymentAmount,
                                    modifier = Modifier.width(160.dp)
                                )
                            }
                            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                                Text(
                                    text = "E-mail (необязательно)",
                                    color = ColorFigma.Text2,
                                    fontSize = 16.sp
                                )
                                FigmaInput(
                                    label = "E-mail",
                                    value = emailValue
                                )
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            // Payment summary
                            FigmaCard(
                                modifier = Modifier.fillMaxWidth(),
                                padding = PaddingValues(horizontal = 30.dp, vertical = 20.dp)
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.spacedBy(10.dp)
                                ) {
                                    Text(
                                        text = "Сумма платежа",
                                        color = ColorFigma.Text1,
                                        fontSize = 18.sp
                                    )
                                    Row(
                                        verticalAlignment = Alignment.Bottom,
                                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                                    ) {
                                        Text(
                                            text = paymentAmount,
                                            color = ColorFigma.Text1,
                                            fontSize = 26.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                        Text(
                                            text = "Р",
                                            color = ColorFigma.Text1,
                                            fontSize = 26.sp,
                                            fontWeight = FontWeight.Bold,
                                            textDecoration = TextDecoration.LineThrough
                                        )
                                    }
                                    FigmaButton(
                                        text = "Оплатить",
                                        onClick = onPayClick,
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                    Text(
                                        text = "Нажимая на кнопку \"Оплатить\", Вы соглашаетесь с условиями на обработку персональных данных",
                                        color = ColorFigma.SecondaryText,
                                        fontSize = 13.sp,
                                        textAlign = TextAlign.Center,
                                        lineHeight = 16.sp
                                    )
                                }
                            }
                        }
                    }

                    // Sberbank Section
                    FigmaCard {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = "Оплата через ",
                                    color = ColorFigma.Text1,
                                    fontSize = 20.sp
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.ic_sber_logo),
                                    contentDescription = "Sber Logo",
                                    modifier = Modifier.height(23.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(20.dp)
                        ) {
                            Text(
                                text = "Оплата услуг компнании ООО \"Луганские сети\" доступна через \"СберБанк\" с комиссией 1%",
                                color = ColorFigma.Text2,
                                fontSize = 14.sp,
                                modifier = Modifier.weight(1f)
                            )
                            FigmaSecondaryButton(
                                text = "Детальнее",
                                onClick = { onDetailClick("sberbank") },
                                iconResId = R.drawable.ic_goto
                            )
                        }
                    }

                    // Post LNR Section
                    FigmaCard {
                        Text(
                            text = "Оплата услуг ЛДС в отделениях почты ЛНР",
                            color = ColorFigma.Text1,
                            fontSize = 20.sp
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(20.dp)
                        ) {
                            Text(
                                text = "Вы можете пополнить счет в отделениях почты ЛНР.",
                                color = ColorFigma.Text2,
                                fontSize = 14.sp,
                                modifier = Modifier.weight(1f)
                            )
                            FigmaSecondaryButton(
                                text = "Детальнее",
                                onClick = { onDetailClick("post") },
                                iconResId = R.drawable.ic_goto
                            )
                        }
                    }

                    // Terminal Section
                    FigmaCard {
                        Text(
                            text = "Оплата услуг ЛДС с помощью платежных терминалов",
                            color = ColorFigma.Text1,
                            fontSize = 20.sp
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = "Абоненты ЛДС могут произвести оплату в сети платежных терминалов, которые расположены в магазинах и супермаркетах Вашего населенного пункта. Для оплаты услуг Вам потребуется лицевой счет, который был присвоен Вам при подключении. Номер лицевого счета указан в памятке пользователя. Для восстановления номера лицевого счета в случае его утери обратитесь в техническую поддержку компании ЛДС.",
                            color = ColorFigma.Text2,
                            fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        FigmaAsyncImage(
                            model = "https://www.figma.com/api/mcp/asset/823a04ea-b65f-4cde-b8bd-1ecc5d646c28",
                            contentDescription = "Terminals",
                            modifier = Modifier.fillMaxWidth().height(300.dp)
                        )
                    }

                    // Payment Point Section
                    FigmaCard {
                        Text(
                            text = "Пункт приёма платежей",
                            color = ColorFigma.Text1,
                            fontSize = 20.sp
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            Text(text = "Адрес:", fontWeight = FontWeight.Medium, color = ColorFigma.Text2, fontSize = 15.sp)
                            Text(text = "кв. Жукова 4 Б/1, главный офис ЛДС", color = ColorFigma.Text2, fontSize = 14.sp)
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = "График работы:", fontWeight = FontWeight.Medium, color = ColorFigma.Text2, fontSize = 15.sp)
                        // More details could go here
                    }
                }
            }

            item {
                FigmaFooter()
            }
        }
    }
}
