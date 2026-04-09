package timetable.writer

import timetable.model.TimeTable

/**
 * Interfaz que define cómo se debe mostrar o exportar un horario.
 */
interface TimeTableWriter {

    /**
     * Muestra o exporta el horario.
     *
     * @param horario Horario a mostrar o exportar.
     */
    fun escribir(horario: TimeTable)
}