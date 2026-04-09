package timetable.model

/**
 * Representa un horario completo de un grupo.
 *
 * @property groupName Nombre del grupo.
 * @property rows Lista de filas del horario.
 */
data class TimeTable(
    val groupName: String,
    val rows: List<TimeTableRow>
)