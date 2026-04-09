package timetable.controller

import timetable.input.ConsoleInput
import timetable.builder.TimeTableBuilder
import timetable.writer.TimeTableWriter

/**
 * Clase que coordina el flujo principal de la aplicación.
 *
 * @property entrada Componente encargado de leer los datos.
 * @property constructor Componente que construye el modelo del horario.
 * @property escritor Componente que muestra o exporta el horario.
 */
class TimeTableManager(
    private val entrada: ConsoleInput,
    private val constructor: TimeTableBuilder,
    private val escritor: TimeTableWriter
) {

    /**
     * Ejecuta el flujo completo:
     * 1. Leer los datos de entrada.
     * 2. Construir el modelo de horario.
     * 3. Mostrar o exportar el horario.
     */
    fun execute() {
        val datosEntrada = entrada.leerDatos()
        val horario = constructor.construir(datosEntrada)
        escritor.escribir(horario)
    }
}