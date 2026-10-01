package com.example.kotlinud02cp02

fun main() {
    print("introduce una contraseña")
    val password = readlnOrNull() ?: ""
    val errores = validarPassword(password)

    if (errores.isEmpty()) {
        println("\na contraseña cumple con todos los requisitos.")
    } else {
        println("\nerror en la contraseña")
        for (error in errores) {
            println("- $error")
        }
    }
}
fun validarPassword(password: String): List<String> {
    val errores = mutableListOf<String>()

    if (password.length < 8) {
        errores.add("debe tener un minimo de 8 caracteres.")
    }

    if (!password.any { it.isUpperCase() }) {
        errores.add("debe incluir al menos una letra mayuscula.")
    }

    if (!password.any { it.isLowerCase() }) {
        errores.add("debe incluir al menos una letra minuscula.")
    }

    if (!password.any { it.isDigit() }) {
        errores.add("debe incluir al menos un numero.")
    }

    if (!password.any { !it.isLetterOrDigit() }) {
        errores.add("debe incluir al menos un caracter especial")
    }

    return errores
}