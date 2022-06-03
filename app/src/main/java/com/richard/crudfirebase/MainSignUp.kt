package com.richard.crudfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.*
import kotlin.math.sign

class MainSignUp : AppCompatActivity() {

    lateinit var etNameSignUp : EditText
    lateinit var etEmailSignUp : EditText
    lateinit var etPasswordSignUp : EditText
    lateinit var btnSignUp : Button
    private lateinit var DbSignUp : DatabaseReference

    lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        etNameSignUp= findViewById(R.id.etNamaSignUp)
        etEmailSignUp = findViewById(R.id.etEmails)
        etPasswordSignUp = findViewById(R.id.etPassword)
        btnSignUp = findViewById(R.id.btnSignUp)

        mAuth = FirebaseAuth.getInstance()
        DbSignUp = FirebaseDatabase.getInstance().reference

        btnSignUp.setOnClickListener{
            val name = etNameSignUp.text.toString()
            val email = etEmailSignUp.text.toString()
            val password = etPasswordSignUp.text.toString()

           if (name != "" && email != "" && password !=""){
               signUp(email,password)
            }else{
                Toast.makeText(this, "Masih ada field yang kosong",
                    Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun signUp(email : String, password : String){

        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    var name = etNameSignUp.text.toString()
                    var email = etEmailSignUp.text.toString()
                    var uuid = mAuth.uid.toString()
                    DbSignUp.child("user").child(uuid).setValue(SignUp(name,email,uuid))
                    Toast.makeText(this,"Data Sign Up", Toast.LENGTH_LONG).show()

                    Log.i("DataBase","Berhasil")
                    Log.d("Task", task.toString())

                    etEmailSignUp.text.clear()
                    etPasswordSignUp.text.clear()

                }else{
                    Toast.makeText(this, "Sign Up Gagal, "+task.exception, Toast.LENGTH_SHORT).show()
                }
            }
    }





    }

