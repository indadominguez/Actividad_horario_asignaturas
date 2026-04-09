package timetabletatus
gi

import timetable.controller.TimeTableManager
import timetable.input.ConsoleInput
import timetable.builder.TimeTableBuilder
import timetable.writer.ManualTimeTableWriter
import timetable.writer.TimeTableWriter

/**
 * Punto de entrada principal de la aplicación.
 * Inicializa los componentes y ejecuta el gestor de horarios.
 */
fun main() {
    val entrada = ConsoleInput()
    val constructor = TimeTableBuilder()
    val escritor: TimeTableWriter = ManualTimeTableWriter()

    val gestor = TimeTableManager(entrada, constructor, escritor)

    gestor.execute()
}