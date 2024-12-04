package com.example.listatareas.pojos

import java.io.Serializable

data class Tarea(val tipo: Tipo, val texto: String):Serializable {


    enum class Tipo {
        ESTUDIAR, LIMPIAR, COMPRAR, OCIO
    }

}