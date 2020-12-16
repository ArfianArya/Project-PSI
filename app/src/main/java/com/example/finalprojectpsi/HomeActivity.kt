package com.example.finalprojectpsi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnObat.setOnClickListener {
            Intent(this@HomeActivity, DaftarObatActivity::class.java).also {
                startActivity(it)
            }
        }
        btnOrderObat.setOnClickListener {
            Intent(this@HomeActivity, OrderActivity::class.java).also {
                startActivity(it)
            }
        }

        btnTransaksi.setOnClickListener {
            startActivity(Intent(applicationContext, Getdata::class.java))

        }

        btnLogout.setOnClickListener {
            Intent(this@HomeActivity, LoginActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }



    }
}