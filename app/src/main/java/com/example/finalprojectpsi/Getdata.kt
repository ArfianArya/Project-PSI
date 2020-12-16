package com.example.finalprojectpsi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.*
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
        reference.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                Log.e("cancel", p0.toString())
            }

            override fun onDataChange(p0 : DataSnapshot) {
                var list = ArrayList<DatabaseModel>()
                for(data in p0.children){
                    val model = data.getValue(DatabaseModel::class.java)
                    list.add(model as DatabaseModel)
                }
                if(list.size>0) {
                    val adapter = DataAdapter(list)
                    recyvlerview.adapter = adapter
                }
            }

        })
    }
}