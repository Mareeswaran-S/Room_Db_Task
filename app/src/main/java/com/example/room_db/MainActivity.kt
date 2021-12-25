package com.example.room_db

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var add:FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        add = findViewById(R.id.add)

        add.setOnClickListener{
           var intent= Intent(this@MainActivity,AddNote::class.java)
            startActivity(intent)
        }
    }
}