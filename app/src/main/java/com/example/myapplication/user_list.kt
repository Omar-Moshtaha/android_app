package com.example.myapplication

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityUserListBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class UserList : AppCompatActivity() {
lateinit var  binding:ActivityUserListBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding= ActivityUserListBinding.inflate(layoutInflater)
        MainActivity.data.clear()

        setContentView(binding.root)

        var myAdapter = Adapter(this, MainActivity.data)
        binding.listItem.adapter = myAdapter

        val db =

            Firebase.firestore;
        db.collection("users")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {

MainActivity.data.add(User(1,document.data.get("name").toString(),document.data.get("phone").toString(),document.data.get("address").toString()))
               myAdapter.notifyDataSetChanged()
                }
            }
            .addOnFailureListener { exception ->
            }

    }
}