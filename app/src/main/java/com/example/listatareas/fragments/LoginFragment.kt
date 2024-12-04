package com.example.listatareas.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.listatareas.R
import com.example.listatareas.activities.MainActivity
import com.example.listatareas.databinding.FragmentLoginBinding
import com.example.listatareas.pojos.DatosUsuarios
import com.example.listatareas.pojos.Tarea
import com.example.listatareas.pojos.Usuario

class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)


        binding.btnAdd.setOnClickListener {
            val nombre = binding.etNombre.text.toString().trim()
            val pass = binding.etPasswword.text.toString().trim()

            if (nombre?.isEmpty() == true) {
                binding.etNombre.error = "El nombre no puede ser vacio"
                return@setOnClickListener
            }
            if (pass?.isEmpty() == true) {
                Toast.makeText(context, "El password no puede ser vacio", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            } else {
                val verificarUser = DatosUsuarios.listaUsuarios.find { it.nombre.equals(nombre) }

                if (verificarUser != null) {
                    if (verificarUser.password.equals(pass)) {
                        Toast.makeText(context, "Logeado correctamente", Toast.LENGTH_SHORT)
                            .show()

                        val user=Usuario(nombre.toString(), pass.toString(), emptyList<Tarea>())

                        val intent= Intent(context, MainActivity::class.java)
                        intent.putExtra("user", user)
                        startActivity(intent)
                    } else {
                        Toast.makeText(context, "El password no valido", Toast.LENGTH_LONG)
                            .show()
                        return@setOnClickListener
                    }
                } else Toast.makeText(context, "Usuario no encontrado", Toast.LENGTH_LONG).show()
            }// fin else
        }


    return binding.root
}


}