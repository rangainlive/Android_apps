package com.proud_indian.bottomnav2.storage.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proud_indian.bottomnav2.presentation.activities.home.MainApplication
import com.proud_indian.bottomnav2.storage.entities.CheckList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date

class CheckListViewModel : ViewModel() {

    val checkListDao = MainApplication.checkListDatabase.getTodoDao()

    // Current Date
    val createdAt = Date.from(Instant.now())
    // Base Default Done Date
    val doneAt = Date.from(LocalDateTime.of(1950, 1, 1, 0, 0).atZone(ZoneId.systemDefault()).toInstant())

    val checkList : LiveData<List<CheckList>> = checkListDao.getAllTodo()

    fun addCheckList(title: String, desc: String, listGroupId: Int) {
        viewModelScope.launch (Dispatchers.IO){
            checkListDao.addTodo(CheckList(title = title, desc = desc, createdAt = createdAt, doneAt = doneAt, listGroupId = listGroupId))
        }
    }

    fun deleteCheckList(id : Int){
        viewModelScope.launch (Dispatchers.IO){
            checkListDao.deleteTodo(id)
        }
    }

    fun updateCheckListStatus(id : Int) {
        viewModelScope.launch (Dispatchers.IO){
            checkListDao.updateCheckListStatus(id, createdAt)
        }
    }

    fun updateCheckList(id: Int, title: String, desc: String, listGroupId: Int){
        viewModelScope.launch (Dispatchers.IO){
            checkListDao.updateCheckList(id, title, desc, listGroupId)
        }
    }
}