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

class MainSignIn : AppCompatActivity() {
    lateinit var etLoginEmail : EditText
    lateinit var etLoginPassword : EditText
    lateinit var btnSignIn : Button
    private lateinit var DbSignIn : DatabaseReference

    lateinit var mAuth : FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        etLoginEmail= findViewById(R.id.etLoginEmail)
        etLoginPassword = findViewById(R.id.etLoginPassword)
        btnSignIn = findViewById(R.id.btnLogin)

        mAuth = FirebaseAuth.getInstance()
        DbSignIn = FirebaseDatabase.getInstance().reference

        btnSignIn.setOnClickListener{
            val email = etLoginEmail.text.toString()
            val password = etLoginPassword.text.toString()

            if (email != "" && password !=""){
                signIn(email,password)
            }else{
                Toast.makeText(this, "Masih ada field yang kosong",
                    Toast.LENGTH_LONG).show()
            }
        }
    }


    private fun signIn(email : String, password : String){
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    Toast.makeText(this,"Login Berhasil", Toast.LENGTH_LONG).show()

                    Log.i("DataBase","Berhasil")
                    Log.d("Task", task.toString())


                }else{
                    Toast.makeText(this, "Sign In Gagal, Silahkan Sign Up. "+task.exception, Toast.LENGTH_LONG).show()
                }
            }
    }
}