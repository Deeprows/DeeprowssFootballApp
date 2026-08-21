package com.deeprows.football

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.deeprows.football.data.FootballMatch
import com.deeprows.football.data.FootballRepository
import com.deeprows.football.ui.DeeprowssTheme
import com.deeprows.football.ui.FootballLiveScreen
import com.deeprows.football.ui.HomeScreen
import com.deeprows.football.ui.MatchDetailsScreen

private val NavigationBackground = Color(0xFF10141B)
private val NavigationText = Color(0xFFF4F6F8)
private val AppBackground = Color(0xFF07090D)

private enum class AppTab(
    val title: String,
    val icon: String
) {
    HOME("Home", "⌂"),
    LIVE("Live", "⚽"),
    TV("TV", "TV"),
    MOVIES("Movies", "▶"),
    MORE("More", "⋯")
}

private sealed class AppScreen {

    data object Main : AppScreen()

    data class MatchDetails(
        val match: FootballMatch
    ) : AppScreen()
}

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            DeeprowssTheme {

                DeeprowssApp()
            }
        }
    }
}

@Composable
private fun DeeprowssApp() {

    var selectedTab by remember {
        mutableStateOf(AppTab.HOME)
    }

    var currentScreen by remember {
        mutableStateOf<AppScreen>(
            AppScreen.Main
        )
    }

    when (val screen = currentScreen) {

        AppScreen.Main -> {

            MainAppScreen(
                selectedTab = selectedTab,

                onTabSelected = { tab ->

                    selectedTab = tab
                },

                onMatchSelected = { match ->

                    currentScreen =
                        AppScreen.MatchDetails(match)
                }
            )
        }

        is AppScreen.MatchDetails -> {

            MatchDetailsScreen(
                match = screen.match,

                onBack = {

                    currentScreen =
                        AppScreen.Main
                }
            )
        }
    }
}

@Composable
private fun MainAppScreen(
    selectedTab: AppTab,
    onTabSelected: (AppTab) -> Unit,
    onMatchSelected: (FootballMatch) -> Unit
) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),

        containerColor = AppBackground,

        bottomBar = {

            NavigationBar(
                modifier =
                    Modifier.navigationBarsPadding(),

                containerColor =
                    NavigationBackground
            ) {

                AppTab.entries.forEach { tab ->

                    NavigationBarItem(

                        selected =
                            selectedTab == tab,

                        onClick = {

                            onTabSelected(tab)
                        },

                        icon = {

                            Text(
                                text = tab.icon,
                                fontSize = 19.sp,
                                color =
                                    NavigationText
                            )
                        },

                        label = {

                            Text(
                                text = tab.title
                            )
                        }
                    )
                }
            }
        }
    ) {

        when (selectedTab) {

            AppTab.HOME -> {

                HomeScreen()
            }

            AppTab.LIVE -> {

                FootballLiveScreen(
                    onMatchSelected =
                        onMatchSelected
                )
            }

            AppTab.TV -> {

                ScreenPlaceholder(
                    title = "TV Channels"
                )
            }

            AppTab.MOVIES -> {

                ScreenPlaceholder(
                    title = "Movies"
                )
            }

            AppTab.MORE -> {

                ScreenPlaceholder(
                    title = "More"
                )
            }
        }
    }
}

@Composable
private fun ScreenPlaceholder(
    title: String
) {

    Box(
        modifier = Modifier.fillMaxSize(),

        contentAlignment =
            Alignment.Center
    ) {

        Text(
            text = title,
            color = Color.White,
            fontSize = 24.sp
        )
    }
}
