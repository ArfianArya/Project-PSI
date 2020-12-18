package com.example.finalprojectpsi

class DatabaseModel {
    private var namaProduk : String = ""
    private var jumlahProduk : String = ""
    private var alamat :String = ""

    constructor(namaProduk: String, jumlahProduk: String, alamat: String) {
        this.namaProduk = namaProduk
        this.jumlahProduk = jumlahProduk
        this.alamat = alamat
    }
    fun getnamaProduk(): String{
        return namaProduk
    }
    fun getjumlahProduk(): String{
        return jumlahProduk
    }
    fun getalamat(): String{
        return alamat
    }
}
