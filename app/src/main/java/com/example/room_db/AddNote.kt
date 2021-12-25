package com.example.room_db

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddNote : AppCompatActivity() {
    private lateinit var id:EditText
    private lateinit var name:EditText
    private lateinit var save:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        setUI()
        save.setOnClickListener {

            if(validate())
            {
                saveNote()
            }
        }
    }

    private fun saveNote() {
        val database=MyDatabase?.getInstance(this)
        val noteDao = database?.NoteDao()
        val note=Note(0,id.text.toString(),name.text.toString())
        GlobalScope.launch {
            noteDao?.insert(note)
            withContext(Dispatchers.Main)
            {
                Toast.makeText(this@AddNote, "Note Saved", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    private fun validate():Boolean{
        if (id.text.isEmpty() or name.text.isEmpty())
        {
            Toast.makeText(this, "please enter a id and a name", Toast.LENGTH_SHORT).show()
            return false
        }
            return true
    }

    private fun setUI() {
        id =findViewById(R.id.etid)
        name =findViewById(R.id.etname)
        save =findViewById(R.id.save)
    }
}