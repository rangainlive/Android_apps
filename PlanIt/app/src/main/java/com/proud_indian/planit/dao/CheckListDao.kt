package com.proud_indian.planit.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.proud_indian.planit.entity.CheckList
import kotlinx.coroutines.flow.Flow

@Dao
interface CheckListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(checkListItem : CheckList)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(checkListItem: CheckList)

    @Delete
    suspend fun delete(checkListItem: CheckList)

    @Query("SELECT * FROM check_list")
    fun getAllCheckList():Flow<List<CheckList>>

    @Query("SELECT * FROM check_list WHERE list_id = :id")
    fun getItem(id : Int): Flow<CheckList>

}