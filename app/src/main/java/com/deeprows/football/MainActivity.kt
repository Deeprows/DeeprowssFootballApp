package com.deeprows.football

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Background = Color(0xFF07090D)
private val SurfaceDark = Color(0xFF10141B)
private val SurfaceDark2 = Color(0xFF171C24)
private val TextPrimary = Color(0xFFF4F6F8)
private val TextSecondary = Color(0xFF9AA3AE)
private val Accent = Color(0xFF35D07F)

private enum class AppTab(
    val title: String
) {
    HOME("Home"),
    LIVE("Live"),
    TV("TV"),
    MOVIES("Movies"),
    MORE("More")
}

private data class DemoMatch(
    val league: String,
    val home: String,
    val away: String,
    val time: String,
    val status: String
)

private val demoMatches = listOf(
    DemoMatch(
        league = "Premier League",
        home = "Arsenal",
        away = "Coventry City",
        time = "20:00",
        status = "UPCOMING"
    ),
    DemoMatch(
        league = "Premier League",
        home = "Chelsea",
        away = "Liverpool",
        time = "20:30",
        status = "UPCOMING"
    ),
    DemoMatch(
        league = "La Liga",
        home = "Barcelona",
        away = "Valencia",
        time = "21:00",
        status = "UPCOMING"
    )
)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            DeeprowssFootballApp()
        }
    }
}

@Composable
private fun DeeprowssFootballApp() {

    var selectedTab by remember {
        mutableStateOf(AppTab.HOME)
    }

    MaterialTheme {

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Background
        ) {

            Scaffold(
                containerColor = Background,

                bottomBar = {

                    NavigationBar(
                        modifier = Modifier.navigationBarsPadding(),
                        containerColor = SurfaceDark
                    ) {

                        AppTab.entries.forEach { tab ->

                            NavigationBarItem(
                                selected = selectedTab == tab,

                                onClick = {
                                    selectedTab = tab
                                },

                                icon = {

                                    Text(
                                        text = when (tab) {
                                            AppTab.HOME -> "⌂"
                                            AppTab.LIVE -> "⚽"
                                            AppTab.TV -> "TV"
                                            AppTab.MOVIES -> "▶"
                                            AppTab.MORE -> "⋯"
                                        },
                                        fontSize = 20.sp,
                                        color = TextPrimary
                                    )
                                },

                                label = {
                                    Text(tab.title)
                                }
                            )
                        }
                    }
                }
            ) { padding ->

                when (selectedTab) {

                    AppTab.HOME ->
                        HomeScreen(padding)

                    AppTab.LIVE ->
                        FootballLiveScreen(padding)

                    AppTab.TV ->
                        TvChannelsScreen(padding)

                    AppTab.MOVIES ->
                        MoviesScreen(padding)

                    AppTab.MORE ->
                        MoreScreen(padding)
                }
            }
        }
    }
}

@Composable
private fun AppHeader() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 12.dp
            ),

        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = "DEEPR O WSS",
                color = TextPrimary,
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold
            )

            Text(
                text = "Football",
                color = TextSecondary,
                fontSize = 13.sp
            )
        }

        Box(
            modifier = Modifier
                .size(10.dp)
                .background(
                    Accent,
                    RoundedCornerShape(50)
                )
        )
    }
}

@Composable
private fun HomeScreen(
    padding: PaddingValues
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),

        contentPadding = PaddingValues(
            bottom = 20.dp
        )
    ) {

        item {
            AppHeader()
        }

        item {
            HomeHeroCard()
        }

        item {
            SectionTitle("Upcoming Matches")
        }

        items(
            demoMatches.take(2)
        ) { match ->

            MatchCard(match)
        }
    }
}

@Composable
private fun HomeHeroCard() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            ),

        shape = RoundedCornerShape(22.dp),

        colors = CardDefaults.cardColors(
            containerColor = SurfaceDark2
        )
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Text(
                text = "FOOTBALL LIVE",
                color = TextPrimary,
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = "Follow live matches, upcoming fixtures and football content.",
                color = TextSecondary,
                fontSize = 14.sp,
                lineHeight = 20.sp
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(9.dp)
                        .background(
                            Accent,
                            RoundedCornerShape(50)
                        )
                )

                Spacer(
                    modifier = Modifier.width(8.dp)
                )

                Text(
                    text = "LIVE FOOTBALL",
                    color = TextPrimary,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
private fun FootballLiveScreen(
    padding: PaddingValues
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),

        contentPadding = PaddingValues(
            bottom = 20.dp
        )
    ) {

        item {
            AppHeader()
        }

        item {
            SectionTitle("Football Live")
        }

        item {

            Text(
                text = "Live and upcoming matches",
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 4.dp
                ),
                color = TextSecondary,
                fontSize = 13.sp
            )
        }

        items(demoMatches) { match ->

            MatchCard(match)
        }
    }
}

@Composable
private fun TvChannelsScreen(
    padding: PaddingValues
) {

    PlaceholderScreen(
        padding = padding,
        title = "TV Channels",
        subtitle = "Sports, movies, music and news"
    )
}

@Composable
private fun MoviesScreen(
    padding: PaddingValues
) {

    PlaceholderScreen(
        padding = padding,
        title = "Movies",
        subtitle = "Movies and entertainment"
    )
}

@Composable
private fun MoreScreen(
    padding: PaddingValues
) {

    PlaceholderScreen(
        padding = padding,
        title = "More",
        subtitle = "More Deeprowss features"
    )
}

@Composable
private fun PlaceholderScreen(
    padding: PaddingValues,
    title: String,
    subtitle: String
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {

        AppHeader()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),

            horizontalAlignment = Alignment.CenterHorizontally,

            verticalArrangement =
                Arrangement.Center
        ) {

            Text(
                text = title,
                color = TextPrimary,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = subtitle,
                color = TextSecondary,
                fontSize = 14.sp
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
            horizontal = 16.dp,
            vertical = 12.dp
        ),

        color = TextPrimary,
        fontSize = 19.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun MatchCard(
    match: DemoMatch
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
            containerColor = SurfaceDark
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement =
                    Arrangement.SpaceBetween
            ) {

                Text(
                    text = match.league,
                    color = TextSecondary,
                    fontSize = 12.sp
                )

                Text(
                    text = match.status,
                    color = TextSecondary,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(
                modifier = Modifier.height(13.dp)
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
                        text = match.home,
                        color = TextPrimary,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(7.dp)
                    )

                    Text(
                        text = match.away,
                        color = TextPrimary,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Text(
                    text = match.time,
                    color = TextPrimary,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
    }
}
