package com.proud_indian.bottomnav2.storage.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.proud_indian.bottomnav2.storage.entities.CheckList
import java.util.Date

@Dao
interface CheckListDao {

    @Query("Select * FROM CheckList")
    fun getAllTodo() : LiveData<List<CheckList>>

    @Insert
    fun addTodo(todo : CheckList)

    @Query("DELETE FROM CheckList WHERE id = :id")
    fun deleteTodo(id : Int)

    @Query("UPDATE CheckList SET doneAt = :doneAt WHERE id = :id")
    fun updateCheckListStatus(id: Int, doneAt: Date)

    @Query("UPDATE CheckList SET title = :title, `desc` = :desc, listGroupId = :listGroupId WHERE id = :id")
    fun updateCheckList(id: Int, title: String, desc: String, listGroupId: Int)

}