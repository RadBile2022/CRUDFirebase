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

class Product : AppCompatActivity() {
    private lateinit var etNamaProduct : EditText
    private lateinit var etSatuan : EditText
    private lateinit var etHarga : EditText
    private lateinit var btnSimpan : Button
    private lateinit var mDBRef : DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        supportActionBar!!.hide()

        etNamaProduct = findViewById(R.id.eTNamaProduk)
        etSatuan = findViewById(R.id.etSatuan)
        etHarga = findViewById(R.id.etHarga)
        btnSimpan = findViewById(R.id.btnSimpan)
        mDBRef = FirebaseDatabase.getInstance().reference

        btnSimpan.setOnClickListener{
            saveData()
            Log.i("Latihan","data berhasil cuy")
        }
    }

    fun saveData(){
        var namaBarang = etNamaProduct.text.toString()
        var satuan = etSatuan.text.toString()
        var harga = etHarga.text.toString()
        var uuid = UUID.randomUUID().toString()
        mDBRef.child("barang").child(uuid).setValue(Barang (namaBarang, satuan.toInt(),harga.toInt()))
        Toast.makeText(this,"Data Berhasil Tersimpan", Toast.LENGTH_LONG).show()

        etNamaProduct.text.clear()
        etNamaProduct.text.clear()
        etSatuan.text.clear()
        etHarga.text.clear()

    }
}