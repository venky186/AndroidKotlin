package com.example.session3_gridview.model

class DataModel (var name : String , var imgid:Int){

    fun get_Name() : String {
        return name
    }
    fun get_ImageId (): Int {
        return imgid
    }
    fun set_name(textname:String){
        this.name = textname
    }
    fun set_imageid(imgid : Int){
        this.imgid = imgid
    }

}