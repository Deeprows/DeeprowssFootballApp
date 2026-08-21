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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.deeprows.football.data.FootballMatch
import com.deeprows.football.data.FootballRepository
import com.deeprows.football.data.MatchStatus

private val Background = Color(0xFF07090D)
private val CardBackground = Color(0xFF10141B)
private val SecondaryBackground = Color(0xFF171C24)
private val PrimaryText = Color(0xFFF4F6F8)
private val SecondaryText = Color(0xFF9AA3AE)
private val AccentRed = Color(0xFFFF1744)
private val LiveGreen = Color(0xFF35D07F)

@Composable
fun FootballLiveScreen() {

    val matches = remember {
        FootballRepository.getMatches()
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Background),

        contentPadding = androidx.compose.foundation.layout.PaddingValues(
            bottom = 24.dp
        )
    ) {

        item {
            FootballHeader()
        }

        item {
            LiveBanner()
        }

        item {
            MatchSectionTitle(
                title = "Matches"
            )
        }

        items(
            items = matches,
            key = { it.id }
        ) { match ->

            FootballMatchCard(match)
        }

        item {

            Spacer(
                modifier = Modifier.height(20.dp)
            )
        }
    }
}

@Composable
private fun FootballHeader() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 18.dp,
                vertical = 16.dp
            )
    ) {

        Text(
            text = "Football Live",
            color = PrimaryText,
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(
            modifier = Modifier.height(4.dp)
        )

        Text(
            text = "Live and upcoming football matches",
            color = SecondaryText,
            fontSize = 13.sp
        )
    }
}

@Composable
private fun LiveBanner() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 5.dp
            ),

        shape = RoundedCornerShape(18.dp),

        colors = CardDefaults.cardColors(
            containerColor = SecondaryBackground
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(10.dp)
                    .background(
                        AccentRed,
                        RoundedCornerShape(50)
                    )
            )

            Column(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .weight(1f)
            ) {

                Text(
                    text = "FOOTBALL LIVE",
                    color = PrimaryText,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Follow today's fixtures",
                    color = SecondaryText,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
private fun MatchSectionTitle(
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
private fun FootballMatchCard(
    match: FootballMatch
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 5.dp
            ),

        shape = RoundedCornerShape(18.dp),

        colors = CardDefaults.cardColors(
            containerColor = CardBackground
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement =
                    Arrangement.SpaceBetween,

                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Text(
                    text = match.competition,
                    color = SecondaryText,
                    fontSize = 11.sp
                )

                StatusBadge(
                    status = match.status
                )
            }

            Spacer(
                modifier = Modifier.height(14.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),

                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = match.homeTeam,
                        color = PrimaryText,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = match.awayTeam,
                        color = PrimaryText,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Column(
                    horizontalAlignment =
                        Alignment.End
                ) {

                    Text(
                        text = match.kickoff.substringAfter("T").substringBefore("+"),
                        color = PrimaryText,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.ExtraBold
                    )

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Text(
                        text = "Match",
                        color = SecondaryText,
                        fontSize = 10.sp
                    )
                }
            }
        }
    }
}

@Composable
private fun StatusBadge(
    status: MatchStatus
) {

    val text = when (status) {
        MatchStatus.LIVE -> "LIVE"
        MatchStatus.UPCOMING -> "UPCOMING"
        MatchStatus.ENDED -> "ENDED"
    }

    val textColor = when (status) {
        MatchStatus.LIVE -> LiveGreen
        MatchStatus.UPCOMING -> SecondaryText
        MatchStatus.ENDED -> SecondaryText
    }

    Row(
        verticalAlignment =
            Alignment.CenterVertically
    ) {

        if (status == MatchStatus.LIVE) {

            Box(
                modifier = Modifier
                    .size(7.dp)
                    .background(
                        LiveGreen,
                        RoundedCornerShape(50)
                    )
            )

            Spacer(
                modifier = Modifier.size(5.dp)
            )
        }

        Text(
            text = text,
            color = textColor,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
