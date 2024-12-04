package com.example.listatareas.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listatareas.R
import com.example.listatareas.adapters.AdapterLista
import com.example.listatareas.adapters.Evento
import com.example.listatareas.databinding.FragmentListaBinding
import com.example.listatareas.pojos.DatosUsuarios
import com.example.listatareas.pojos.Tarea
import com.example.listatareas.pojos.Usuario


class ListaFragment : Fragment() {
    lateinit var binding: FragmentListaBinding
    lateinit var adapterLista: AdapterLista
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var dividerItemDecoration: DividerItemDecoration


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaBinding.inflate(inflater, container, false)
        Log.v("Usuario", "Usuario recibido")
        var evento = requireActivity() as Evento
        var usuario = arguments?.getSerializable("usuario") as? Usuario

        if (usuario != null) {
            Toast.makeText(context, "Usuario ${usuario.nombre}", Toast.LENGTH_LONG).show()
            val userList = DatosUsuarios.listaUsuarios.find { it.nombre.equals(usuario.nombre) }
            if (userList != null) {
                val tareas = userList.tareas
                Log.v("Tareas", "${tareas.toString()}")
                Toast.makeText(context, "tareas ${tareas.size}", Toast.LENGTH_LONG).show()
                adapterLista = AdapterLista(tareas, evento)
                linearLayoutManager = LinearLayoutManager(context)
                dividerItemDecoration =
                    DividerItemDecoration(context, DividerItemDecoration.VERTICAL)

                binding.rvLista.apply {
                    adapter = adapterLista
                    layoutManager = linearLayoutManager
                    addItemDecoration(dividerItemDecoration)
                }
            }
        }

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(usuario: Usuario): ListaFragment {
            val fragment = ListaFragment()
            val bundle = Bundle()
            bundle.putSerializable("usuario", usuario)
            fragment.arguments = bundle
            return fragment
        }
    }
}