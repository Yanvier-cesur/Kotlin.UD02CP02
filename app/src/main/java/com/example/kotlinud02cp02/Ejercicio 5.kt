package com.example.kotlinud02cp02

fun main() {
    val asientos = mutableMapOf<String, Boolean>()
    val filas = listOf('A', 'B', 'C', 'D', 'E')

    for (fila in filas) {
        for (col in 1..5) {
            asientos["$fila$col"] = false
        }
    }

    var continuar = true

    while (continuar) {
        println("\n=== CINE  ===")
        println("1. mostrar mapa de asientos")
        println("2. reservar asiento")
        println("3. cancelar reserva")
        println("4. salir")
        print("elige una opcion: ")

        try {
            val opcion = readlnOrNull()?.toInt() ?: 0

            when (opcion) {
                1 -> mostrarMapa(asientos, filas)
                2 -> gestionarAsiento(asientos, reservar = true)
                3 -> gestionarAsiento(asientos, reservar = false)
                4 -> {
                    println("gracias por usar el sistema de reservas")
                    continuar = false
                }
                else -> println("opcion no valida. Elige un numero del 1 al 4.")
            }
        } catch (e: NumberFormatException) {
            println("error: debes introducir un numero valido")
        }
    }
}
fun mostrarMapa(asientos: Map<String, Boolean>, filas: List<Char>) {
    println("\n--- MAPA DE ASIENTOS ---")
    println("    1   2   3   4   5")
    for (fila in filas) {
        print("$fila |")
        for (col in 1..5) {
            val codigo = "$fila$col"

            val estado = asientos[codigo]
            val simbolo = when (estado) {
                false -> " [ ] "
                true -> " [X] "
                null -> " [?] "
            }
            print(simbolo)
        }
        println()
    }
}
fun gestionarAsiento(asientos: MutableMap<String, Boolean>, reservar: Boolean) {
    val accion = if (reservar) "reservar" else "cancelar"
    print("introduce el codigo del asiento a $accion: ")
    val codigo = readlnOrNull()?.uppercase() ?: ""

    val estadoActual = asientos[codigo]

    if (estadoActual == null) {
        println("error: el asiento '$codigo' no existe")
        return
    }

    if (reservar) {
        if (estadoActual) {
            println("el asiento '$codigo' ya está ocupado.")
        } else {
            asientos[codigo] = true
            println("asiento '$codigo' reservado con exito")
        }
    } else {
        if (!estadoActual) {
            println("el asiento '$codigo' ya estaba libre")
        } else {
            asientos[codigo] = false
            println("reserva del asiento '$codigo' cancelada con exito.")
        }
    }
}