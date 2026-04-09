package timetable.model

import java.time.LocalTime

/** Representa una franja horaria con hora de inicio y fin. */
data class TimeSlot(
    val start: LocalTime,
    val end: LocalTime
)