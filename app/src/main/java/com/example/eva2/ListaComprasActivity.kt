package com.example.eva2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ListaComprasActivity : AppCompatActivity() {

    private lateinit var editTextProduct: EditText
    private lateinit var buttonAdd: Button
    private lateinit var listView: ListView

    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lista_compras)

        editTextProduct = findViewById(R.id.editTextProduct)
        buttonAdd = findViewById(R.id.buttonAdd)
        listView = findViewById(R.id.listView)

        // Inicializar el adaptador con una lista vacía
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mutableListOf())
        listView.adapter = adapter

        buttonAdd.setOnClickListener {
            agregarProducto()
        }

        // Manejar la eliminación de productos cuando se hace clic en un elemento de la lista
        listView.setOnItemClickListener { _, _, position, _ ->
            eliminarProducto(position)
        }
    }

    private fun agregarProducto() {
        val nuevoProducto = editTextProduct.text.toString().trim()
        if (nuevoProducto.isNotEmpty()) {
            adapter.add(nuevoProducto)
            adapter.notifyDataSetChanged()
            editTextProduct.text.clear()
        }
    }

    private fun eliminarProducto(position: Int) {
        adapter.remove(adapter.getItem(position))
        adapter.notifyDataSetChanged()
    }
}
