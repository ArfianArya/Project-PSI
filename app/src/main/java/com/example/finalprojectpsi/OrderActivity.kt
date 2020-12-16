package com.example.finalprojectpsi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : AppCompatActivity() {

    private lateinit var database : FirebaseDatabase
    private lateinit var reference: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        database = FirebaseDatabase.getInstance()
        reference = database.getReference("Order")

        btnOrder.setOnClickListener{
            sendData()
        }

    }

    private fun sendData(){
        var namaProduk = et_namaProduk.text.toString().trim()
        var jumlah = et_jumlahProduk.text.toString().trim()
        var alamat = et_Alamat.text.toString().trim()
        if(namaProduk.isNotEmpty() && jumlah.isNotEmpty() && alamat.isNotEmpty()){
            var model = DatabaseModel(namaProduk,jumlah,alamat)
            var id = reference.push().key

            reference.child(id!!).setValue(model)
            et_namaProduk.setText("")
            et_jumlahProduk.setText("")
            et_Alamat.setText("")


        }else{
            Toast.makeText(applicationContext, "Setiap kolom harus diisi", Toast.LENGTH_SHORT).show()
        }
    }
}