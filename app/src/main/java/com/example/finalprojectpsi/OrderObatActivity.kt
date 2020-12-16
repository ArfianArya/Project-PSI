package com.example.finalprojectpsi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class OrderObatActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var etnama : EditText
    private lateinit var etjumlahProduk : EditText
    private lateinit var etAlamat : EditText
    private lateinit var btnSave : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_obat)

        etnama = findViewById(R.id.et_nama)
        etjumlahProduk = findViewById(R.id.et_jumlahProduk)
        etAlamat = findViewById(R.id.et_Alamat)
        btnSave = findViewById(R.id.btnOrder)

        btnSave.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        saveData()
    }
    private fun saveData(){
        val nama = etnama.text.toString().trim()
        val jumlah = etjumlahProduk.text.toString().trim()
        val alamat = etAlamat.text.toString().trim()
        if(nama.isNotEmpty()){
            etnama.error = "Isi Nama"
            return
        }
        if(jumlah.isNotEmpty()){
            etjumlahProduk.error = "Isi Jumlah Produk"
            return
        }
        if(alamat.isNotEmpty()){
            etAlamat.error = "Isi Alamat"
            return
        }

        val ref = FirebaseDatabase.getInstance().getReference("Pesanan")
        val id = ref.push().key

        val psnan = Pesanan(id, nama, jumlah, alamat)

        if (id != null) {
            ref.child(id).setValue(psnan).addOnCompleteListener{
                Toast.makeText(applicationContext, "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show()
            }
        }

    }
}