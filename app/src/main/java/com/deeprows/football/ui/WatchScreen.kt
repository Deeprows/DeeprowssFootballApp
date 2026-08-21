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
private val PrimaryText = Color(0xFFF4F6F8)
private val SecondaryText = Color(0xFF9AA3AE)

@Composable
fun WatchScreen(
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
                text = "Watch",
                modifier = Modifier.weight(1f),
                color = PrimaryText,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        /*
         * Native player area.
         *
         * The actual ExoPlayer/Media3 player
         * will be placed here in the next step.
         */
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(230.dp)
                .background(Color.Black),

            contentAlignment =
                Alignment.Center
        ) {

            Text(
                text = "PLAYER",
                color = SecondaryText,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(
            modifier = Modifier.height(18.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp)
        ) {

            Text(
                text = match.homeTeam,
                color = PrimaryText,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "vs",
                color = SecondaryText,
                fontSize = 13.sp
            )

            Text(
                text = match.awayTeam,
                color = PrimaryText,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = match.competition,
                color = SecondaryText,
                fontSize = 12.sp
            )
        }
    }
}
