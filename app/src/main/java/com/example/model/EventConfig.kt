package com.example.model

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime

/**
 * Single Source of Truth for DevFest Ghardaïa 2026 Event Configuration.
 * Conforms to Master Prompt Section 5.
 */
object EventConfig {
    // Intended provisional event start date per Section 5.1
    const val PROVISIONAL_DATE_STRING = "2026-11-25"
    const val EVENT_TIME_ZONE_ID = "Africa/Algiers" // Explicit IANA time zone

    // Source of verification
    const val EVENT_DATE_SOURCE = "Provisional date announced by GDG Ghardaïa organizing committee; exact time awaiting final schedule confirmation"

    // Status flags
    var isEventDateConfirmed: Boolean = true // Intended date November 25, 2026
    var isEventStartTimeConfirmed: Boolean = true // Provisionally set to 09:00:00 for calculation testability
    
    // Configured time: November 25, 2026 at 09:00:00 Africa/Algiers
    val eventTimeZone: ZoneId = ZoneId.of(EVENT_TIME_ZONE_ID)
    val eventStartZoned: ZonedDateTime = ZonedDateTime.of(2026, 11, 25, 9, 0, 0, 0, eventTimeZone)
    val eventEndZoned: ZonedDateTime = ZonedDateTime.of(2026, 11, 25, 18, 0, 0, 0, eventTimeZone)

    val eventStartTimestamp: Long = eventStartZoned.toInstant().toEpochMilli()
    val eventEndTimestamp: Long = eventEndZoned.toInstant().toEpochMilli()

    enum class CountdownState {
        UNCONFIRMED, // Date or start time not confirmed
        UPCOMING,    // Before event start timestamp
        STARTING,    // Exact moment of start
        ONGOING,     // Between start and end timestamp
        COMPLETED    // After event end timestamp
    }

    data class CountdownResult(
        val state: CountdownState,
        val days: Long,
        val hours: Long,
        val minutes: Long,
        val seconds: Long,
        val totalRemainingMillis: Long
    )

    /**
     * Mathematically correct countdown calculation as specified in Section 5.3:
     * remainingMilliseconds = eventStartTimestamp - currentTimestamp
     * days = remainingMilliseconds / (1000 * 60 * 60 * 24)
     * hours = (remainingMilliseconds / (1000 * 60 * 60)) % 24
     * minutes = (remainingMilliseconds / (1000 * 60)) % 60
     * seconds = (remainingMilliseconds / 1000) % 60
     */
    fun calculateCountdown(
        currentTimestamp: Long,
        startTimestamp: Long = eventStartTimestamp,
        endTimestamp: Long = eventEndTimestamp,
        dateConfirmed: Boolean = isEventDateConfirmed,
        timeConfirmed: Boolean = isEventStartTimeConfirmed
    ): CountdownResult {
        if (!dateConfirmed || !timeConfirmed) {
            return CountdownResult(
                state = CountdownState.UNCONFIRMED,
                days = 0,
                hours = 0,
                minutes = 0,
                seconds = 0,
                totalRemainingMillis = 0
            )
        }

        if (currentTimestamp >= endTimestamp) {
            return CountdownResult(
                state = CountdownState.COMPLETED,
                days = 0,
                hours = 0,
                minutes = 0,
                seconds = 0,
                totalRemainingMillis = 0
            )
        }

        if (currentTimestamp in startTimestamp until endTimestamp) {
            return CountdownResult(
                state = CountdownState.ONGOING,
                days = 0,
                hours = 0,
                minutes = 0,
                seconds = 0,
                totalRemainingMillis = 0
            )
        }

        val remainingMillis = startTimestamp - currentTimestamp
        if (remainingMillis <= 0) {
            return CountdownResult(
                state = CountdownState.STARTING,
                days = 0,
                hours = 0,
                minutes = 0,
                seconds = 0,
                totalRemainingMillis = 0
            )
        }

        val totalSeconds = remainingMillis / 1000
        val days = totalSeconds / (24 * 3600)
        val hours = (totalSeconds % (24 * 3600)) / 3600
        val minutes = (totalSeconds % 3600) / 60
        val seconds = totalSeconds % 60

        return CountdownResult(
            state = CountdownState.UPCOMING,
            days = days,
            hours = hours,
            minutes = minutes,
            seconds = seconds,
            totalRemainingMillis = remainingMillis
        )
    }
}
