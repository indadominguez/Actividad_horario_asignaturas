package timetable.model

/**
 * Representa una fila del horario, correspondiente a una franja horaria.
 *
 * @property timeSlot La franja horaria.
 * @property subjectsByDay Asignaturas por día.
 */
data class TimeTableRow(
    val timeSlot: TimeSlot,
    val subjectsByDay: Map<DayOfWeek, String>
)