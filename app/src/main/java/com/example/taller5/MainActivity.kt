package com.example.taller5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var btnAdd: Button

    private val adaptador = Adaptador({
            clickListener -> showItemClick(clickListener)
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAdd = findViewById(R.id.btnAdd)

        /*val items: MutableList<String> = mutableListOf()
        items.add("Prueba 1")
        items.add("Prueba 2")
        items.add("Prueba 3")*/

       // val adaptador = Adaptador(items)

        val items: MutableList<String> = mutableListOf()
        items.add("Prueba 1")
        items.add("Prueba 2")
        items.add("Prueba 3")

        btnAdd.setOnClickListener {
            items.add(txtAdd.text.toString())
            adaptador.setItems(items)
            lista.layoutManager = LinearLayoutManager(this)
            lista.adapter = adaptador
        }

        adaptador.setItems(items)

        lista.layoutManager = LinearLayoutManager(this)
        lista.adapter = adaptador

    }

    fun showItemClick(position: Int) {

        var items: MutableList<String> = adaptador.getLista()
        val item = adaptador.getItem(position)
        items.removeAt(position)
        adaptador.setItems(items)
        lista.layoutManager=LinearLayoutManager(this)
        lista.adapter=adaptador
        Toast.makeText(this,item, Toast.LENGTH_SHORT).show()

    }

}