package com.example.kotlinud02cp02

fun main() {
    print("escrube un numero ")
    val texto = readlnOrNull() ?: ""

    val textoLimpio = texto.lowercase()

    val frecuencias = mutableMapOf<Char, Int>()

    for (letra in textoLimpio) {
        val cuentaActual = frecuencias[letra] ?: 0
        frecuencias[letra] = cuentaActual + 1
    }

    val frecuenciasOrdenadas = frecuencias.entries.sortedByDescending { it.value }

    println("\n mayor a menos")
    if (frecuenciasOrdenadas.isEmpty()) {
        println("el textono tiene letra.")
    } else {
        for (par in frecuenciasOrdenadas) {
            println("letra '${par.key}': ${par.value} veces")
        }
    }
}