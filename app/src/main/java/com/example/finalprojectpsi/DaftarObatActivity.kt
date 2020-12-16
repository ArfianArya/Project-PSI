package com.example.finalprojectpsi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_daftar_obat.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.item_layout.*

class DaftarObatActivity : AppCompatActivity() {
    private var titleList = mutableListOf<String>()
    private var descList = mutableListOf<String>()
    private var imagesList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_obat)
        postToList()
        rv_recyclerView.layoutManager= LinearLayoutManager (this)
        rv_recyclerView.adapter= RecyclerAdapter (titleList, descList, imagesList)


    }
    private fun addToList(title: String, description:String, image:Int){
        titleList.add(title)
        descList.add(description)
        imagesList.add(image)
    }

    private fun postToList(){
        addToList("Mixagrip FLU", "Rp.3.000", R.drawable.obat1)
        addToList("Bordrex", "Rp.8.900", R.drawable.obat2)
        addToList("OBH Combi", "Rp.13.500", R.drawable.obat3)
        addToList("Actifed", "Rp.58.000", R.drawable.obat4)
        addToList("Inhaler", "Rp.90.000", R.drawable.obat5)


    }

}