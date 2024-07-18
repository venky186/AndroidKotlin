package com.example.session3_gridview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.session3_gridview.model.DataModel

class GridViewAdapter(context: Context, modelArrayList: ArrayList<DataModel>) :
ArrayAdapter<DataModel?>(context,0, modelArrayList as ArrayList<DataModel?>){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
       var lisItemView = convertView
        if(lisItemView==null){
            lisItemView = LayoutInflater.from(context).inflate(R.layout.gridviewitem,parent,false)
        }
        val model : DataModel? = getItem(position)
        val tv_name = lisItemView!!.findViewById<TextView>(R.id.text)
        val image = lisItemView!!.findViewById<ImageView>(R.id.image)

        if (model != null) {
            tv_name.setText(model.get_Name())
        }
        if (model != null) {
            image.setBackgroundResource(model.get_ImageId())
        }
        return lisItemView
    }


}