package com.example.listatareas.activities

import android.content.DialogInterface
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.listatareas.R
import com.example.listatareas.adapters.Evento
import com.example.listatareas.databinding.ActivityMainBinding
import com.example.listatareas.databinding.DialogoBinding
import com.example.listatareas.fragments.ListaFragment
import com.example.listatareas.fragments.LoginFragment
import com.example.listatareas.pojos.Tarea
import com.example.listatareas.pojos.Usuario
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity(),Evento {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val usuario=intent.getSerializableExtra("user") as? Usuario

        if(usuario==null){
            // inicia fragment
            val fragment = LoginFragment()
            val envio = supportFragmentManager.beginTransaction()
            envio.replace(R.id.fragmentContainerLogin, fragment)
            envio.commit()
        }

        if (usuario!=null){
            val fragment=ListaFragment.newInstance(usuario)
            val enviar=supportFragmentManager.beginTransaction()
            enviar.replace(R.id.fragmentContainerLista,fragment)
            enviar.commit()
        }

    }

    override fun enviarEvento(tarea: Tarea) {
       val dialogo=DialogoBinding.inflate(layoutInflater)
        dialogo.apply {
            tvText.text=tarea.texto.toString()
        }
        MaterialAlertDialogBuilder(this)
            .setTitle(tarea.tipo.toString())
            .setView(dialogo.root)
            .setPositiveButton("aceptar",DialogInterface.OnClickListener { dialog, which ->
                dialog.cancel()
            })
            .setCancelable(false)
            .show()
    }
}