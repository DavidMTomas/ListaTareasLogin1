package com.example.listatareas.pojos

import java.io.Serializable

data class Usuario(
    val nombre: String, val password: String, val tareas: List<Tarea>
) : Serializable {
}

//val nombre: String, val password: String = "", val tareas: List<Tarea> = emptyList<Tarea>()