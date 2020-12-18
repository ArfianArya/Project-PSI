package com.example.finalprojectpsi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_order.view.*
import kotlinx.android.synthetic.main.rv_layout.view.*

class DataAdapter(var list: ArrayList<DatabaseModel>) : RecyclerView.Adapter<DataAdapter.ViewHolder>(){
    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        var namaProduk = itemView.tv_namaProdukTrans
        var jumlahProduk = itemView.tv_jumlahProdukTrans
        var alamatTujuan = itemView.tv_AlamatTrans

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.rv_layout,parent,false)
        return ViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.namaProduk.text = list[position].getnamaProduk()
        holder.jumlahProduk.text = list[position].getjumlahProduk()
        holder.alamatTujuan.text = list[position].getalamat()

    }
}