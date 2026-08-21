package com.deeprows.football.data

object FootballRepository {

    fun getMatches(): List<FootballMatch> {

        return listOf(

            FootballMatch(
                id = "arsenal-coventry-2026-08-21",
                competition = "Premier League",
                homeTeam = "Arsenal",
                awayTeam = "Coventry City",
                kickoff = "2026-08-21T20:00:00+01:00",
                status = MatchStatus.UPCOMING
            ),

            FootballMatch(
                id = "chelsea-real-sociedad-2026-08-21",
                competition = "Premier League",
                homeTeam = "Chelsea",
                awayTeam = "Real Sociedad",
                kickoff = "2026-08-21T20:30:00+01:00",
                status = MatchStatus.UPCOMING
            ),

            FootballMatch(
                id = "barcelona-valencia-2026-08-21",
                competition = "La Liga",
                homeTeam = "Barcelona",
                awayTeam = "Valencia",
                kickoff = "2026-08-21T21:00:00+01:00",
                status = MatchStatus.UPCOMING
            )
        )
    }
}
