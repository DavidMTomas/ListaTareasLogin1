package com.example.listatareas.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listatareas.R
import com.example.listatareas.databinding.ItemListaBinding
import com.example.listatareas.pojos.Tarea


class AdapterLista(val  lista:List<Tarea>, val evento:Evento):RecyclerView.Adapter<AdapterLista.ViewHolder>() {
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        fun render(tarea: Tarea) {
            binding.tvTipo.text=tarea.tipo.toString()
            binding.tvTexto.text=tarea.texto.toString()
            setEvento(tarea)
        }

        private fun setEvento(tarea: Tarea) {
            binding.root.setOnClickListener {
                evento.enviarEvento(tarea)
            }
        }

        val binding=ItemListaBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_lista,parent,false))
    }

    override fun getItemCount(): Int =lista.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.render(lista[position])
    }
}