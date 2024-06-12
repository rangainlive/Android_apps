package com.proud_indian.planit

import android.content.Context
import com.proud_indian.planit.database.PiPlanItDatabase
import com.proud_indian.planit.repository.PlanItRepository

object Graph {

    lateinit var db: PiPlanItDatabase
        private set

    val repository by lazy {
        PlanItRepository(
            checkListDao = db.checkListDao(),
            checkListCategoryDao = db.checkListCategoryDao()
        )
    }

    fun provide(context:Context){
        db = PiPlanItDatabase.getDatabase(context)
    }
}
