package com.example.listatareas.pojos

class DatosUsuarios {
    companion object{
        val listaUsuarios= arrayOf(
            Usuario("pepe","1234",
                listOf(
                    Tarea(Tarea.Tipo.OCIO,"Ver peli"),
                    Tarea(Tarea.Tipo.COMPRAR,"Ir al super")
                )
            ),
            Usuario("luis","1234",
                listOf(
                    Tarea(Tarea.Tipo.LIMPIAR,"Cocina"),
                    Tarea(Tarea.Tipo.COMPRAR,"Ir al super")
                )
            ),
            Usuario("jose","1234",
                listOf(
                    Tarea(Tarea.Tipo.OCIO,"Ver peli"),
                    Tarea(Tarea.Tipo.ESTUDIAR,"Practica fragments")
                )
            ),
            Usuario("antonio","1234",
                listOf(
                    Tarea(Tarea.Tipo.ESTUDIAR,"matematicas"),
                    Tarea(Tarea.Tipo.OCIO,"Ir al cine")
                )
            ),
            Usuario("alberto","1234",
                listOf(
                    Tarea(Tarea.Tipo.LIMPIAR,"coche"),
                    Tarea(Tarea.Tipo.COMPRAR,"telefono")
                )
            ),
            Usuario("rodrigo","1234",
                listOf(
                    Tarea(Tarea.Tipo.OCIO,"Ver peli"),
                    Tarea(Tarea.Tipo.COMPRAR,"Ir al mercado")
                )
            ),

        )
    }
}