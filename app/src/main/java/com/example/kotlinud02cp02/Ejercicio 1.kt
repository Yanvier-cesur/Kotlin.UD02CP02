package com.example.kotlinud02cp02

fun main(){
    val notas = """ 
        Ana,7,8,9
        Luis,5,6,4
        Marta,9,10,8
    """.trimMargin()
    val notasdividas = notas.split("\n")

    for (notasdividass in notasdividas){
        val datos = notasdividass.split(",")
        val nombre = datos[0]

        val nota1 = datos[1].toDouble()
        val nota2 = datos[2].toDouble()
        val nota3 = datos[3].toDouble()

        val notamedia = (nota1 + nota2 + nota3) / 3

        val calificacion = when {
            notamedia < 5.0 -> "Suspenso tonto"
            notamedia < 7.0 -> "Aprobado"
            notamedia < 9.0 -> "Notable"
            else -> "Sobresaliente"
        }
            println("Alumno : $nombre | Notas : $nota1, $nota2, $nota3 | Nota media : $notamedia | Calificacion : $calificacion")

    }
}