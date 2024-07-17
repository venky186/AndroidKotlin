package com.example.session3_listview_dynamic

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var editText: EditText
    lateinit var listView: ListView
    lateinit var button: Button

    //create array list for data
    var list: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.listView)
        editText = findViewById(R.id.editText)
        button = findViewById(R.id.btnAdd)

        //create array adapter
        var arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        button.setOnClickListener {
            //read edit text data
            var data = editText.text.toString()
            //add to list view
            list.add(data)

            // clear edit text after add into list view so that we can add new one
            editText.setText("")
            //notify list view that we have new data
            arrayAdapter.notifyDataSetChanged()
            listView.adapter = arrayAdapter


        }

        listView.setOnItemClickListener { adapterView, view, position, id ->

            Toast.makeText(this,"onclick :"+adapterView.getItemAtPosition(position),Toast.LENGTH_LONG).show()
        }


    }
}