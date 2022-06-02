package com.richard.crudfirebase

import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuAdapter
import androidx.recyclerview.widget.RecyclerView

class UserAdapter
    (var results : ArrayList<UserModel.Result>) : RecyclerView.Adapter<UserAdapter.MyViewHolder>()
{

    // 1. INNER CLASS MY VIEW HOLDER
    class MyViewHolder (val view : View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.view.
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}