package com.deeprows.football.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Background = Color(0xFF07090D)
private val CardBackground = Color(0xFF10141B)
private val SecondaryBackground = Color(0xFF171C24)
private val PrimaryText = Color(0xFFF4F6F8)
private val SecondaryText = Color(0xFF9AA3AE)
private val AccentRed = Color(0xFFFF1744)

@Composable
fun HomeScreen() {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {

        item {
            HomeHeader()
        }

        item {
            FootballLiveBanner()
        }

        item {
            SectionTitle(
                title = "Football Live"
            )
        }

        item {
            MatchPreviewCard(
                league = "Premier League",
                home = "Arsenal",
                away = "Coventry City",
                time = "20:00"
            )
        }

        item {
            MatchPreviewCard(
                league = "Premier League",
                home = "Chelsea",
                away = "Liverpool",
                time = "20:30"
            )
        }

        item {
            SectionTitle(
                title = "Quick Access"
            )
        }

        item {
            QuickAccessRow()
        }

        item {
            Spacer(
                modifier = Modifier.height(30.dp)
            )
        }
    }
}

@Composable
private fun HomeHeader() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 18.dp,
                vertical = 16.dp
            ),

        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = "DEEPR O WSS",
                color = PrimaryText,
                fontSize = 23.sp,
                fontWeight = FontWeight.ExtraBold
            )

            Text(
                text = "All In One Entertainment",
                color = SecondaryText,
                fontSize = 12.sp
            )
        }

        Box(
            modifier = Modifier
                .size(10.dp)
                .background(
                    AccentRed,
                    RoundedCornerShape(50)
                )
        )
    }
}

@Composable
private fun FootballLiveBanner() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            ),

        shape = RoundedCornerShape(20.dp),

        colors = CardDefaults.cardColors(
            containerColor = SecondaryBackground
        )
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(9.dp)
                        .background(
                            AccentRed,
                            RoundedCornerShape(50)
                        )
                )

                Text(
                    text = "  FOOTBALL LIVE",
                    color = PrimaryText,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }

            Spacer(
                modifier = Modifier.height(9.dp)
            )

            Text(
                text = "Watch live matches and follow upcoming fixtures.",
                color = SecondaryText,
                fontSize = 13.sp
            )
        }
    }
}

@Composable
private fun SectionTitle(
    title: String
) {

    Text(
        text = title,

        modifier = Modifier.padding(
            horizontal = 18.dp,
            vertical = 14.dp
        ),

        color = PrimaryText,
        fontSize = 19.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun MatchPreviewCard(
    league: String,
    home: String,
    away: String,
    time: String
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 5.dp
            ),

        shape = RoundedCornerShape(16.dp),

        colors = CardDefaults.cardColors(
            containerColor = CardBackground
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = league,
                    color = SecondaryText,
                    fontSize = 11.sp
                )

                Spacer(
                    modifier = Modifier.height(7.dp)
                )

                Text(
                    text = home,
                    color = PrimaryText,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = away,
                    color = PrimaryText,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = time,
                color = PrimaryText,
                fontSize = 17.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}

@Composable
private fun QuickAccessRow() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp
            ),

        horizontalArrangement =
            Arrangement.spacedBy(10.dp)
    ) {

        QuickAccessCard(
            title = "Highlights",
            modifier = Modifier.weight(1f)
        )

        QuickAccessCard(
            title = "TV Channels",
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun QuickAccessCard(
    title: String,
    modifier: Modifier
) {

    Card(
        modifier = modifier,

        shape = RoundedCornerShape(16.dp),

        colors = CardDefaults.cardColors(
            containerColor = CardBackground
        )
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp),

            contentAlignment = Alignment.Center
        ) {

            Text(
                text = title,
                color = PrimaryText,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
