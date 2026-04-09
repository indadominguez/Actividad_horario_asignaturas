package timetable.writer

import timetable.model.TimeTable

/**
 * Implementación que usaría una librería externa
 * para exportar el horario (PDF, Excel, etc.).
 */
class LibraryTimeTableWriter : TimeTableWriter {

    override fun escribir(horario: TimeTable) {
        println("Exportando el horario usando una librería externa...")
    }
}