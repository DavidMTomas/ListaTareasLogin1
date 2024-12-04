package com.example.listatareas.adapters

import com.example.listatareas.pojos.Tarea


interface Evento {
 fun enviarEvento(tarea: Tarea)
}
