package com.deeprows.football.data

enum class MatchStatus {
    LIVE,
    UPCOMING,
    ENDED
}

data class FootballMatch(
    val id: String,
    val competition: String,
    val homeTeam: String,
    val awayTeam: String,
    val kickoff: String,
    val status: MatchStatus
)
