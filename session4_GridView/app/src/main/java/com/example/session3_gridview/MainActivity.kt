package com.example.session3_gridview

import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.session3_gridview.model.DataModel

class MainActivity : AppCompatActivity() {
    lateinit var gridView: GridView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        gridView = findViewById(R.id.gridview)

        val array: ArrayList<DataModel> = ArrayList<DataModel>()
        array.add(DataModel("GridView", R.drawable.ic_launcher_background))
        array.add(DataModel("GridView1", R.drawable.ic_launcher_background))
        array.add(DataModel("GridView2", R.drawable.ic_launcher_background))
        array.add(DataModel("GridView3", R.drawable.ic_launcher_background))

        val adapter = GridViewAdapter(this, array)
        gridView.adapter = adapter
        gridView.setOnItemClickListener { adapterView, view, position, id ->

           var  model =array.get(position);
            Toast.makeText(this,"click"+model.get_Name(),Toast.LENGTH_LONG).show()

        }

    }
}