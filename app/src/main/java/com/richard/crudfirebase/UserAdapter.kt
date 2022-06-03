package com.richard.crudfirebase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuAdapter
import androidx.recyclerview.widget.RecyclerView

class UserAdapter
    (var results : ArrayList<UserModel>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>()
{

    // 1. INNER CLASS MY VIEW HOLDER
    class UserViewHolder (val view : View) : RecyclerView.ViewHolder(view){
        val idNama = view.findViewById<TextView>(R.id.idNama)
        val idEmail = view.findViewById<TextView>(R.id.idEmail)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.view_data_user,parent,false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.idNama.text = results[position].name
        holder.idEmail.text = results[position].email
    }

    override fun getItemCount(): Int {
        return results.size
    }
    }
