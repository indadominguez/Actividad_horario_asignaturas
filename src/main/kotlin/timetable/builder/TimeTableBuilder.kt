package timetable.builder

import timetable.model.*

/**
 * Componente que construye un TimeTable
 * a partir de los datos introducidos por el usuario.
 */
class TimeTableBuilder {

    /**
     * Construye un TimeTable a partir de TimeTableInputData.
     *
     * @param datosEntrada Datos introducidos por el usuario.
     * @return TimeTable listo para mostrar o exportar.
     * @throws IllegalArgumentException si no hay franjas horarias.
     */
    fun construir(datosEntrada: TimeTableInputData): TimeTable {
        require(datosEntrada.timeSlots.isNotEmpty()) { "Debe existir al menos una franja horaria" }

        val filas = datosEntrada.timeSlots.map { franja ->
            TimeTableRow(
                timeSlot = franja,
                subjectsByDay = datosEntrada.subjectsBySlot[franja] ?: emptyMap()
            )
        }

        return TimeTable(
            groupName = datosEntrada.groupName,
            rows = filas
        )
    }
}