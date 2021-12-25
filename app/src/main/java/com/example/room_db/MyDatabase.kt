package com.example.room_db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class MyDatabase:RoomDatabase() {

    companion object
    {
        @Volatile private var INSTANCE:MyDatabase? = null
        fun getInstance(context: Context): MyDatabase?
        {
            if (INSTANCE == null)
            {
                synchronized(MyDatabase::class.java)
                {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        MyDatabase::class.java,
                        "MyDatabase"
                    ).build()
                    return INSTANCE!!
                }
            }
            return INSTANCE
        }

    }

    abstract fun NoteDao():NoteDao
}