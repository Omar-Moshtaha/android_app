package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private  lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding .root)
binding.button.setOnClickListener {
    val db =
        Firebase.firestore

    val user = hashMapOf(
        "name" to binding.name.text.toString(),
        "phone" to binding.phoneNumber.text.toString(),
        "address" to binding.address.text.toString()
    )
    db.collection("users")
        .add(user)
        .addOnSuccessListener { documentReference ->
            println("succeed")
        }
        .addOnFailureListener { e ->
            println("Failed")
        }
}
      
    }
}