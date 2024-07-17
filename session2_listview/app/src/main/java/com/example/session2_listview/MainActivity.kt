package com.example.session2_listview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    //create data fro list view
    val user = arrayOf("football", "kotlin", "listview", "example")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var myListView = findViewById<ListView>(R.id.listview)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, user)
        myListView.adapter = adapter
        myListView.setOnItemClickListener { adapterView, view, position, l ->
            Toast.makeText(
                this,
                "onclick : " + adapterView.getItemAtPosition(position),
                Toast.LENGTH_LONG
            ).show()
        }

    }
}