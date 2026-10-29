package com.example

import com.example.model.EventConfig
import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.ZonedDateTime

/**
 * Deterministic Countdown Calculation Unit Tests
 * Conforms to Master Prompt Section 5.7 and Section 20.
 */
class CountdownCalculationTest {

    private val eventStartMillis = EventConfig.eventStartTimestamp // 2026-11-25 09:00:00 Africa/Algiers
    private val eventEndMillis = EventConfig.eventEndTimestamp     // 2026-11-25 18:00:00 Africa/Algiers

    // Test 1: Exactly 29 calendar days before the event date (October 27, 2026 at 09:00:00 Africa/Algiers)
    @Test
    fun testCase01_exactly29DaysBeforeEvent() {
        val currentMillis = eventStartMillis - (29L * 24 * 3600 * 1000)
        val result = EventConfig.calculateCountdown(currentMillis)
        assertEquals(EventConfig.CountdownState.UPCOMING, result.state)
        assertEquals(29L, result.days)
        assertEquals(0L, result.hours)
        assertEquals(0L, result.minutes)
        assertEquals(0L, result.seconds)
    }

    // Test 2: Exactly 25 days before the event start timestamp
    @Test
    fun testCase02_exactly25DaysBeforeEvent() {
        val currentMillis = eventStartMillis - (25L * 24 * 3600 * 1000)
        val result = EventConfig.calculateCountdown(currentMillis)
        assertEquals(EventConfig.CountdownState.UPCOMING, result.state)
        assertEquals(25L, result.days)
        assertEquals(0L, result.hours)
        assertEquals(0L, result.minutes)
        assertEquals(0L, result.seconds)
    }

    // Test 3: Exactly 24 hours remaining
    @Test
    fun testCase03_exactly24HoursRemaining() {
        val currentMillis = eventStartMillis - (24L * 3600 * 1000)
        val result = EventConfig.calculateCountdown(currentMillis)
        assertEquals(EventConfig.CountdownState.UPCOMING, result.state)
        assertEquals(1L, result.days)
        assertEquals(0L, result.hours)
        assertEquals(0L, result.minutes)
        assertEquals(0L, result.seconds)
    }

    // Test 4: Less than 24 hours remaining (e.g. 15 hours, 30 minutes, 45 seconds)
    @Test
    fun testCase04_lessThan24HoursRemaining() {
        val remaining = (15L * 3600 + 30 * 60 + 45) * 1000
        val currentMillis = eventStartMillis - remaining
        val result = EventConfig.calculateCountdown(currentMillis)
        assertEquals(EventConfig.CountdownState.UPCOMING, result.state)
        assertEquals(0L, result.days)
        assertEquals(15L, result.hours)
        assertEquals(30L, result.minutes)
        assertEquals(45L, result.seconds)
    }

    // Test 5: Exactly One hour remaining
    @Test
    fun testCase05_oneHourRemaining() {
        val currentMillis = eventStartMillis - (3600 * 1000)
        val result = EventConfig.calculateCountdown(currentMillis)
        assertEquals(EventConfig.CountdownState.UPCOMING, result.state)
        assertEquals(0L, result.days)
        assertEquals(1L, result.hours)
        assertEquals(0L, result.minutes)
        assertEquals(0L, result.seconds)
    }

    // Test 6: Exactly One minute remaining
    @Test
    fun testCase06_oneMinuteRemaining() {
        val currentMillis = eventStartMillis - (60 * 1000)
        val result = EventConfig.calculateCountdown(currentMillis)
        assertEquals(EventConfig.CountdownState.UPCOMING, result.state)
        assertEquals(0L, result.days)
        assertEquals(0L, result.hours)
        assertEquals(1L, result.minutes)
        assertEquals(0L, result.seconds)
    }

    // Test 7: A few seconds remaining (e.g. 12 seconds)
    @Test
    fun testCase07_fewSecondsRemaining() {
        val currentMillis = eventStartMillis - (12 * 1000)
        val result = EventConfig.calculateCountdown(currentMillis)
        assertEquals(EventConfig.CountdownState.UPCOMING, result.state)
        assertEquals(0L, result.days)
        assertEquals(0L, result.hours)
        assertEquals(0L, result.minutes)
        assertEquals(12L, result.seconds)
    }

    // Test 8: The exact event start timestamp
    @Test
    fun testCase08_exactEventStartTimestamp() {
        val result = EventConfig.calculateCountdown(eventStartMillis)
        assertEquals(EventConfig.CountdownState.ONGOING, result.state)
        assertEquals(0L, result.days)
        assertEquals(0L, result.hours)
        assertEquals(0L, result.minutes)
        assertEquals(0L, result.seconds)
    }

    // Test 9: A timestamp after the event has started (e.g. 2 hours into event)
    @Test
    fun testCase09_afterEventHasStartedOngoing() {
        val currentMillis = eventStartMillis + (2L * 3600 * 1000)
        val result = EventConfig.calculateCountdown(currentMillis)
        assertEquals(EventConfig.CountdownState.ONGOING, result.state)
    }

    // Test 10: A completed event with confirmed end time (e.g. 1 hour after end)
    @Test
    fun testCase10_completedEventAfterEndTime() {
        val currentMillis = eventEndMillis + (3600 * 1000)
        val result = EventConfig.calculateCountdown(currentMillis)
        assertEquals(EventConfig.CountdownState.COMPLETED, result.state)
    }

    // Test 11: An unconfirmed event date
    @Test
    fun testCase11_unconfirmedEventDate() {
        val currentMillis = eventStartMillis - (10L * 24 * 3600 * 1000)
        val result = EventConfig.calculateCountdown(
            currentTimestamp = currentMillis,
            dateConfirmed = false,
            timeConfirmed = true
        )
        assertEquals(EventConfig.CountdownState.UNCONFIRMED, result.state)
    }

    // Test 12: A missing event start time
    @Test
    fun testCase12_missingEventStartTime() {
        val currentMillis = eventStartMillis - (10L * 24 * 3600 * 1000)
        val result = EventConfig.calculateCountdown(
            currentTimestamp = currentMillis,
            dateConfirmed = true,
            timeConfirmed = false
        )
        assertEquals(EventConfig.CountdownState.UNCONFIRMED, result.state)
    }

    // Test 13: A device time zone different from event time zone (e.g. UTC, Tokyo UTC+9)
    @Test
    fun testCase13_differentDeviceTimeZoneConsistency() {
        // ZonedDateTime in Tokyo (UTC+9) corresponding to same instant
        val tokyoZoned = ZonedDateTime.of(2026, 11, 24, 18, 0, 0, 0, java.time.ZoneId.of("Asia/Tokyo"))
        val tokyoEpochMillis = tokyoZoned.toInstant().toEpochMilli()

        // 2026-11-24 18:00 Tokyo is 2026-11-24 10:00 Africa/Algiers (23 hours before start at 09:00 Nov 25)
        val result = EventConfig.calculateCountdown(tokyoEpochMillis)
        assertEquals(EventConfig.CountdownState.UPCOMING, result.state)
        assertEquals(0L, result.days)
        assertEquals(23L, result.hours)
        assertEquals(0L, result.minutes)
        assertEquals(0L, result.seconds)
    }

    // Test 14: Refreshing or reopening the application maintains identical state
    @Test
    fun testCase14_reopeningApplicationConsistency() {
        val currentMillis = eventStartMillis - (5L * 24 * 3600 * 1000 + 4L * 3600 * 1000)
        val resultFirstOpen = EventConfig.calculateCountdown(currentMillis)
        val resultSecondOpen = EventConfig.calculateCountdown(currentMillis)
        assertEquals(resultFirstOpen, resultSecondOpen)
        assertEquals(5L, resultSecondOpen.days)
        assertEquals(4L, resultSecondOpen.hours)
    }

    // Test 15: Returning after device idle correctly reflects elapsed timestamp
    @Test
    fun testCase15_returningAfterIdleRecalculatesAccurately() {
        val initialMillis = eventStartMillis - (1000 * 100) // 100 seconds before
        val initialResult = EventConfig.calculateCountdown(initialMillis)
        assertEquals(1L, initialResult.minutes)
        assertEquals(40L, initialResult.seconds)

        // Device was idle for 30 seconds
        val afterIdleMillis = initialMillis + (30 * 1000)
        val afterIdleResult = EventConfig.calculateCountdown(afterIdleMillis)
        assertEquals(1L, afterIdleResult.minutes)
        assertEquals(10L, afterIdleResult.seconds)
    }
}
