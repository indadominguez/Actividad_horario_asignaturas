package timetable.input

import timetable.model.*
import java.time.LocalTime

/**
 * Componente encargado de leer los datos del usuario desde consola
 * y construir un objeto TimeTableInputData.
 */
class ConsoleInput {

    /**
     * Lee todos los datos necesarios para construir un horario.
     *
     * @return TimeTableInputData con nombre del grupo, franjas horarias y asignaturas por franja.
     */
    fun leerDatos(): TimeTableInputData {
        val nombreGrupo = leerNombreGrupo()
        val franjas = leerFranjas()
        val asignaturas = leerAsignaturas(franjas)
        return TimeTableInputData(nombreGrupo, franjas, asignaturas)
    }

    /** Solicita el nombre del grupo al usuario. */
    private fun leerNombreGrupo(): String {
        println("Introduce el nombre del grupo:")
        val entrada = readln()
        require(entrada.isNotBlank()) { "El nombre del grupo no puede estar vacío" }
        return entrada
    }

    /**
     * Solicita al usuario las franjas horarias.
     *
     * @return Lista de TimeSlot.
     */
    private fun leerFranjas(): List<TimeSlot> {
        val franjas = mutableListOf<TimeSlot>()
        var cantidadValida = false
        var cantidad = 0

        while (!cantidadValida) {
            println("¿Cuántas franjas horarias quieres introducir?")
            val entrada = readln()
            try {
                cantidad = entrada.toInt()
                require(cantidad > 0) { "Debe introducir al menos una franja horaria válida" }
                cantidadValida = true
            } catch (e: NumberFormatException) {
                println("Error: Debes introducir un número entero.")
            } catch (e: IllegalArgumentException) {
                println("Error: ${e.message}")
            }
        }

        repeat(cantidad) { indice ->
            var inicioValido = false
            var finValido = false
            var inicio: LocalTime = LocalTime.MIN
            var fin: LocalTime = LocalTime.MIN

            while (!inicioValido) {
                println("Introduce la hora de inicio de la franja ${indice + 1} (HH:mm):")
                val entradaInicio = readln()
                try {
                    inicio = LocalTime.parse(entradaInicio)
                    inicioValido = true
                } catch (e: Exception) {
                    println("Error: Formato de hora inválido. Debe ser HH:mm.")
                }
            }

            while (!finValido) {
                println("Introduce la hora de fin de la franja ${indice + 1} (HH:mm):")
                val entradaFin = readln()
                try {
                    fin = LocalTime.parse(entradaFin)
                    require(fin.isAfter(inicio)) { "La hora de fin debe ser posterior a la de inicio." }
                    finValido = true
                } catch (e: java.time.format.DateTimeParseException) {
                    println("Error: Formato de hora inválido. Debe ser HH:mm.")
                } catch (e: IllegalArgumentException) {
                    println("Error: ${e.message}")
                }
            }

            franjas.add(TimeSlot(inicio, fin))
        }

        return franjas
    }

    /**
     * Solicita las asignaturas para cada franja y cada día.
     *
     * @param franjas Lista de franjas horarias.
     * @return Mapa con TimeSlot como clave y asignaturas por día como valor.
     */
    private fun leerAsignaturas(
        franjas: List<TimeSlot>
    ): Map<TimeSlot, Map<DayOfWeek, String>> {
        val resultado = mutableMapOf<TimeSlot, Map<DayOfWeek, String>>()

        for (franja in franjas) {
            val asignaturasPorDia = mutableMapOf<DayOfWeek, String>()
            for (dia in DayOfWeek.values()) {
                println("Asignatura para $dia en ${franja.start}-${franja.end}:")
                asignaturasPorDia[dia] = readln()
            }
            resultado[franja] = asignaturasPorDia
        }

        return resultado
    }
}