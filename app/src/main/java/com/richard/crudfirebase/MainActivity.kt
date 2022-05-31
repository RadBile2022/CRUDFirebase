package com.richard.crudfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var etEmail : EditText
    private lateinit var etName : EditText
    private lateinit var btnSave : Button
    private lateinit var mDBRef : DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        etEmail = findViewById(R.id.etEmail)
        etName = findViewById(R.id.etNama)
        btnSave = findViewById(R.id.btnSave)

        mDBRef = FirebaseDatabase.getInstance().reference
        btnSave.setOnClickListener{
            saveData()
            Log.i("Latihan","data berhasil cuy")
        }
    }

    fun saveData(){

        var name = etName.text.toString()
        var email = etEmail.text.toString()
        var uuid = UUID.randomUUID().toString()
        mDBRef.child("user").child(uuid).setValue(User (name, email))
        Toast.makeText(this,"Data Berhasil Tersimpan", Toast.LENGTH_LONG).show()

        etEmail.text.clear()
        etName.text.clear()
    }
}