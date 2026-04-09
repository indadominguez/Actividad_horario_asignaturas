package timetable.writer

import timetable.model.*

/**
 * Implementación que muestra el horario en consola.
 */
class ManualTimeTableWriter : TimeTableWriter {

    override fun escribir(horario: TimeTable) {
        println("Horario del grupo: ${horario.groupName}")
        imprimirCabecera()

        for (fila in horario.rows) {
            println(formatearFila(fila))
        }
    }

    /** Imprime la cabecera con los días de la semana. */
    private fun imprimirCabecera() {
        print("Hora\t")
        for (dia in DayOfWeek.values()) {
            print("$dia\t")
        }
        println()
    }

    /**
     * Formatea una fila del horario para mostrarla en consola.
     *
     * @param fila Fila del horario.
     * @return Fila formateada.
     */
    private fun formatearFila(fila: TimeTableRow): String {
        val sb = StringBuilder()
        sb.append("${fila.timeSlot.start}-${fila.timeSlot.end}\t")

        for (dia in DayOfWeek.values()) {
            val asignatura = fila.subjectsByDay[dia] ?: "-"
            sb.append("$asignatura\t")
        }

        return sb.toString()
    }
}