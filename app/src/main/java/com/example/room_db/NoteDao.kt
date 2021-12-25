package com.example.room_db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    //insert
    @Insert
    fun insert(note: Note)

    //delete
    @Delete
    fun delete(note: Note)

    //fetch
    @Query("SELECT * FROM note_Table ")
    fun getAllNotes():LiveData<List<Note>>
}
