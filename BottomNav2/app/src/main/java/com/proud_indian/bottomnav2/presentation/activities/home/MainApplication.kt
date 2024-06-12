package com.proud_indian.bottomnav2.presentation.activities.home

import android.app.Application
import androidx.room.Room
import com.proud_indian.bottomnav2.storage.database.CheckListDatabase

class MainApplication : Application() {

    companion object {
        lateinit var checkListDatabase: CheckListDatabase
    }

    override fun onCreate() {
        super.onCreate()
        checkListDatabase = Room.databaseBuilder(
            applicationContext,
            CheckListDatabase::class.java,
            CheckListDatabase.NAME
        ).build();
    }
}