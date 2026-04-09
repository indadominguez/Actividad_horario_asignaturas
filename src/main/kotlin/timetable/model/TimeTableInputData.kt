package timetable.model

/**
 * Contiene los datos introducidos por el usuario para crear un horario.
 *
 * @property groupName Nombre del grupo.
 * @property timeSlots Lista de franjas horarias.
 * @property subjectsBySlot Asignaturas por franja y día.
 */
data class TimeTableInputData(
    val groupName: String,
    val timeSlots: List<TimeSlot>,
    val subjectsBySlot: Map<TimeSlot, Map<DayOfWeek, String>>
)