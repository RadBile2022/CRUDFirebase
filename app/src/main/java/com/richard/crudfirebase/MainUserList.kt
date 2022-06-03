package com.richard.crudfirebase


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class MainUserList : AppCompatActivity() {

    lateinit var userRecyclerView: RecyclerView
    lateinit var userList : ArrayList<UserModel>
    lateinit var adapter : UserAdapter
    lateinit var mDbRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        mDbRef = FirebaseDatabase.getInstance().getReference()
        userList = ArrayList()
        userRecyclerView = findViewById(R.id.rvUserList)
        adapter = UserAdapter(userList)
        userRecyclerView.layoutManager = LinearLayoutManager(this)
        userRecyclerView.adapter = adapter

        // read data
        mDbRef.child("user").addValueEventListener(
            object  : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (postSnapshot in snapshot.children){
                        val user = postSnapshot.getValue(UserModel::class.java)
                        userList.add(user!!)
                    }
                    adapter.notifyDataSetChanged()
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            }
        )


    }
}