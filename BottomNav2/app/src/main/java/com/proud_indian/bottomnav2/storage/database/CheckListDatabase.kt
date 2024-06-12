package com.proud_indian.bottomnav2.storage.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.proud_indian.bottomnav2.storage.convertors.DateConvertors
import com.proud_indian.bottomnav2.storage.dao.CheckListDao
import com.proud_indian.bottomnav2.storage.entities.CheckList

@Database(entities = [CheckList::class], version = 1)
@TypeConverters(DateConvertors::class)
abstract class CheckListDatabase : RoomDatabase(){

    companion object {
        const val NAME = "pi_todo_db"
    }

    abstract fun getTodoDao() : CheckListDao
}