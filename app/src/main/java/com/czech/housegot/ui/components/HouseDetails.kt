package com.czech.housegot.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.czech.housegot.R
import com.czech.housegot.ui.theme.*

@Composable
fun HouseDetails(
    house: String,
    founder: String,
    founded: String,
    region: String,
    lord: String,
    heir: String,
    quote: String,
    colorInt: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxSize()
    ) {
        val color = remember {
            when (colorInt) {
                0 -> sage
                1 -> apricot
                2 -> rock_blue
                3 -> scarpa
                4 -> purple
                5 -> melrose
                6 -> yellow
                7 -> orange
                8 -> emerald
                9 -> minsk
                else -> blue
            }
        }
        Card(
            shape = RectangleShape,
            colors = CardDefaults.cardColors(
                containerColor = color
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) {
            val constrains = ConstraintSet {
                val foundedText = createRefFor("founded")
                val houseText = createRefFor("house")
                val quoteText = createRefFor("mottoRow")
                val heirText = createRefFor("incoming")
                val lordText = createRefFor("lord")
                val regionText = createRefFor("region")

                constrain(houseText) {
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.matchParent
                    height = Dimension.wrapContent
                }
                constrain(foundedText) {
                    top.linkTo(houseText.bottom)
                    start.linkTo(houseText.start)
                    end.linkTo(houseText.end)
                }
                constrain(regionText) {
                    start.linkTo(lordText.start)
                    bottom.linkTo(lordText.top, margin = 4.dp)
                }
                constrain(lordText) {
                    start.linkTo(heirText.start)
                    bottom.linkTo(heirText.top, margin = 4.dp)
                }
                constrain(heirText) {
                    start.linkTo(quoteText.start)
                    bottom.linkTo(quoteText.top, margin = 4.dp)
                }
                constrain(quoteText) {
                    start.linkTo(parent.start, margin = 6.dp)
                    end.linkTo(parent.end, margin = 6.dp)
                    bottom.linkTo(parent.bottom, margin = 8.dp)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                }
            }

            ConstraintLayout(
                constraintSet = constrains,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = house,
                    color = black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W500,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .layoutId("house")
                )
                if (founder.isNotEmpty() && founded.isNotEmpty()) {
                    Box(
                        modifier = Modifier
                            .layoutId("founded")
                    ) {
                        Text(
                            text = "Founded by $founder in $founded",
                            color = black,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.W400,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Center,
                        )
                    }
                }
                if (region.isNotEmpty()) {
                    Row(
                        modifier = Modifier
                            .layoutId("region"),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.region),
                            contentDescription = "region icon",
                        )
                        Spacer(
                            modifier = Modifier
                                .width(4.dp)
                        )
                        Text(
                            text = region,
                            color = black,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.W400,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                        )
                    }
                }
                if (lord.isNotEmpty()) {
                    Row(
                        modifier = Modifier
                            .layoutId("lord"),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.lord),
                            contentDescription = "lord icon",
                        )
                        Spacer(
                            modifier = Modifier
                                .width(4.dp)
                        )
                        Text(
                            text = lord,
                            color = black,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.W400,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                        )
                    }
                }
                if (heir.isNotEmpty()) {
                    Row(
                        modifier = Modifier
                            .layoutId("incoming"),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.incoming),
                            contentDescription = "incoming icon",
                        )
                        Spacer(
                            modifier = Modifier
                                .width(4.dp)
                        )
                        Text(
                            text = heir,
                            color = black,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.W400,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                        )
                    }
                }
                if (quote.isNotEmpty()) {
                    Row(
                        modifier = Modifier
                            .layoutId("mottoRow"),
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.quote),
                            contentDescription = "motto icon",
                        )
                        Spacer(
                            modifier = Modifier
                                .width(4.dp)
                        )
                        Text(
                            text = quote,
                            color = black,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.W400,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                        )
                    }
                }

            }
            
        }
    }
}