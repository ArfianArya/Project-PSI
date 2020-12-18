package com.example.finalprojectpsi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_daftar_obat.*
import kotlinx.android.synthetic.main.activity_getdata.*

class Getdata : AppCompatActivity() {

    private lateinit var database : FirebaseDatabase
    private lateinit var reference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getdata)

        database = FirebaseDatabase.getInstance()
        reference=database.getReference("Order")

        getData()
    }
    private fun getData(){

        var alamat = mutableListOf<String>()
        var  namaProduk = mutableListOf<String>()
        var jumlahProduk = mutableListOf<Int>()
        recyvlerview.layoutManager= LinearLayoutManager (this)
        database.getReference("Order").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {

            }

            override fun onDataChange(snapshot: DataSnapshot) {
                for (h in snapshot.children) {
                    alamat.add(h.getValue(DatabaseModel::class.java)!!.getalamat())
                    namaProduk.add(h.getValue(DatabaseModel::class.java)!!.getnamaProduk())
                    jumlahProduk.add(h.getValue(DatabaseModel::class.java)!!.getjumlahProduk().toInt())

                }
                recyvlerview.adapter=RecyclerAdapter(alamat, namaProduk, jumlahProduk)
            }
        })
    }
}

//        reference.addValueEventListener(object : ValueEventListener{
//            override fun onCancelled(p0: DatabaseError) {
//                Log.e("cancel", p0.toString())
//            }
//
//            override fun onDataChange(p0 : DataSnapshot) {
//                var list = ArrayList<DatabaseModel>()
//                for(data in p0.children){
//                    val model = data.getValue(DatabaseModel::class.java)
//                    list.add(model as DatabaseModel)
//                }
//                if(list.size>0) {
//                    val adapter = DataAdapter(list)
//                    recyvlerview.adapter = adapter
//                }
//            }
//
//        })

