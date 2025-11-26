package com.example.minhaagenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtNome = findViewById<EditText>(R.id.edtNome)
        val edtTelefone = findViewById<EditText>(R.id.edtTelefone)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val listView = findViewById<ListView>(R.id.listContatos)

        val lista = ArrayList<String>()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lista)
        listView.adapter = adapter

        btnAdd.setOnClickListener {
            val nome = edtNome.text.toString()
            val telefone = edtTelefone.text.toString()

            if (nome.isNotBlank() && telefone.isNotBlank()) {
                lista.add("$nome - $telefone")
                adapter.notifyDataSetChanged()

                edtNome.text.clear()
                edtTelefone.text.clear()
            } else {
                Toast.makeText(this, "Preencha nome e telefone!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
