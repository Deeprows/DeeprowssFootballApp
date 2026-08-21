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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.deeprows.football.data.FootballMatch

private val Background = Color(0xFF07090D)
private val CardBackground = Color(0xFF10141B)
private val PrimaryText = Color(0xFFF4F6F8)
private val SecondaryText = Color(0xFF9AA3AE)
private val AccentRed = Color(0xFFFF1744)

@Composable
fun MatchDetailsScreen(
    match: FootballMatch,
    onBack: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 10.dp,
                    vertical = 8.dp
                ),

            verticalAlignment =
                Alignment.CenterVertically
        ) {

            TextButton(
                onClick = onBack
            ) {

                Text(
                    text = "‹ Back",
                    color = PrimaryText,
                    fontSize = 15.sp
                )
            }

            Text(
                text = "Match",
                modifier = Modifier.weight(1f),
                color = PrimaryText,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

            shape = RoundedCornerShape(20.dp),

            colors = CardDefaults.cardColors(
                containerColor = CardBackground
            )
        ) {

            Column(
                modifier = Modifier.padding(20.dp),

                horizontalAlignment =
                    Alignment.CenterHorizontally
            ) {

                Text(
                    text = match.competition,
                    color = SecondaryText,
                    fontSize = 12.sp
                )

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                Text(
                    text = match.homeTeam,
                    color = PrimaryText,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "VS",
                    modifier = Modifier.padding(
                        vertical = 12.dp
                    ),
                    color = AccentRed,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold
                )

                Text(
                    text = match.awayTeam,
                    color = PrimaryText,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                Text(
                    text = "Watch",
                    color = SecondaryText,
                    fontSize = 13.sp
                )
            }
        }
    }
}
