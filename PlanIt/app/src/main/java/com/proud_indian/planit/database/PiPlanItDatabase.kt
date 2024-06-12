package com.proud_indian.planit.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.proud_indian.planit.dao.CheckListCategoryDao
import com.proud_indian.planit.dao.CheckListDao
import com.proud_indian.planit.entity.CheckList
import com.proud_indian.planit.entity.CheckListCategory
import com.proud_indian.planit.utils.convertors.DateConverter

@TypeConverters(value = [DateConverter::class])
@Database(
    entities = [CheckList::class,CheckListCategory::class],
    version = 1,
    exportSchema = false
)
abstract class PiPlanItDatabase:RoomDatabase() {
    abstract fun checkListDao() : CheckListDao
    abstract fun checkListCategoryDao() : CheckListCategoryDao

    companion object {
        @Volatile
        var INSTANCE:PiPlanItDatabase?  = null

        fun getDatabase(context:Context):PiPlanItDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    PiPlanItDatabase::class.java,
                    "pi_plainit_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}