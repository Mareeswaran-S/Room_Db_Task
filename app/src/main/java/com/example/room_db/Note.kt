package com.example.room_db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_Table")
data class Note(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    @ColumnInfo(name = "Title")
    var title:String,
    @ColumnInfo(name ="Name")
    var name:String

)