fun main() {
    val tareas = mutableListOf<String>()
    var continuar = true

    while (continuar) {
        println("\n=== GESTOR DE TAREAS ===")
        println("1. Añadir tarea")
        println("2. Completar tarea")
        println("3. Listar tareas")
        println("4. Ver pendientes")
        println("5. Salir")
        print("Elige una opción: ")

        val opcion = readlnOrNull()?.toIntOrNull()

        when (opcion) {
            1 -> {
                print("nombre de tarea")
                val nuevaTarea = readlnOrNull() ?: ""
                if (opcionValida(nuevaTarea)) {
                    añadir(tareas, nuevaTarea)
                }
            }
            2 -> {
                listar(tareas)
                if (tareas.isNotEmpty()) {
                    print("id de la tarea ")
                    val indice = readlnOrNull()?.toIntOrNull()
                    if (indice != null) {
                        completar(tareas, indice - 1)
                    }
                }
            }
            3 -> listar(tareas)
            4 -> mostrarPendientes(tareas)
            5 -> {
                continuar = false
            }
            else -> println("numero invalido")
        }
    }
}

fun añadir(lista: MutableList<String>, tarea: String) {
    lista.add(tarea)
    println("tarea añadida")
}

fun completar(lista: MutableList<String>, indice: Int) {
    if (indice in lista.indices) {
        if (!lista[indice].startsWith("[X]")) {
            lista[indice] = "[X] ${lista[indice]}"
            println("tarea marcada como completada")
        } else {
            println("esta tarea ya esta marcada")
        }
    } else {
        println("error: no existe la tarea")
    }
}
fun listar(lista: List<String>) {
    println("\n--- LISTA DE TAREAS ---")
    if (lista.isEmpty()) {
        println("no hay tarea en la lista")
    } else {
        for ((i, tarea) in lista.withIndex()) {
            println("${i + 1}. $tarea")
        }
    }
}

fun List<String>.pendientes(): List<String> {
    return this.filter { !it.startsWith("[X]") }
}

fun mostrarPendientes(lista: List<String>) {
    val listaPendientes = lista.pendientes()
    println("\n--- TAREAS PENDIENTES ---")
    if (listaPendientes.isEmpty()) {
        println("no hay")
    } else {
        for ((i, tarea) in listaPendientes.withIndex()) {
            println("${i + 1}. $tarea")
        }
    }
}
fun opcionValida(texto: String): Boolean {
    return if (texto.isNotBlank()) {
        true
    } else {
        println("la tarea no puede estar vacia")
        false
    }
}