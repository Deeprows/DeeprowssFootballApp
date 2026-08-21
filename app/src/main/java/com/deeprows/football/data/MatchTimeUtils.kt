package com.deeprows.football.data

import java.time.Duration
import java.time.OffsetDateTime
import java.time.ZoneId

object MatchTimeUtils {

    private const val MATCH_DURATION_MINUTES = 96L

    fun parseKickoff(kickoff: String): OffsetDateTime {
        return OffsetDateTime.parse(kickoff)
    }

    fun getStatus(
        kickoff: String,
        now: OffsetDateTime = OffsetDateTime.now()
    ): MatchStatus {

        val kickoffTime = parseKickoff(kickoff)

        val matchEnd = kickoffTime.plusMinutes(
            MATCH_DURATION_MINUTES
        )

        return when {

            now.isBefore(kickoffTime) -> {
                MatchStatus.UPCOMING
            }

            now.isBefore(matchEnd) -> {
                MatchStatus.LIVE
            }

            else -> {
                MatchStatus.ENDED
            }
        }
    }

    fun getRemainingTime(
        kickoff: String,
        now: OffsetDateTime = OffsetDateTime.now()
    ): Duration {

        val kickoffTime = parseKickoff(kickoff)

        return Duration.between(
            now,
            kickoffTime
        )
    }

    fun formatCountdown(
        kickoff: String,
        now: OffsetDateTime = OffsetDateTime.now()
    ): String {

        val duration = getRemainingTime(
            kickoff,
            now
        )

        if (duration.isNegative) {
            return "LIVE"
        }

        val totalSeconds = duration.seconds

        val hours = totalSeconds / 3600

        val minutes =
            (totalSeconds % 3600) / 60

        val seconds =
            totalSeconds % 60

        return String.format(
            "%02d:%02d:%02d",
            hours,
            minutes,
            seconds
        )
    }

    fun formatLocalKickoff(
        kickoff: String
    ): String {

        val dateTime = parseKickoff(kickoff)

        val localDateTime =
            dateTime.atZoneSameInstant(
                ZoneId.systemDefault()
            )

        return String.format(
            "%02d:%02d",
            localDateTime.hour,
            localDateTime.minute
        )
    }
}
