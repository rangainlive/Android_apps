package com.proud_indian.planit.pages.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proud_indian.planit.Graph
import com.proud_indian.planit.entity.CheckList
import com.proud_indian.planit.entity.CheckListCategory
import com.proud_indian.planit.repository.PlanItRepository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.Locale.Category

class HomeViewModel(
    private val repository: PlanItRepository = Graph.repository
) : ViewModel(){
    var state by mutableStateOf(HomeState())
        private set
    init {
        getCheckListItems()
        getCheckListCategories()
    }
    private fun getCheckListItems() {
        viewModelScope.launch {
            repository.checkList.collectLatest {
                state = state.copy(
                    checkList = it
                )
            }
        }
    }

    private fun getCheckListCategories() {
        viewModelScope.launch {
            repository.checkListCategory.collectLatest {
                state = state.copy(
                    checkListCategories = it
                )
            }
        }
    }


    fun deleteCheckListItem(checkList : CheckList) {
        viewModelScope.launch {
            repository.deleteCheckList(checkList)
        }
    }

    fun deleteCheckListCategory(checkListCategory: CheckListCategory){
        viewModelScope.launch {
            repository.deleteCheckListCategory(checkListCategory)
        }
    }

    fun updateCheckListItem(checkList: CheckList){
        viewModelScope.launch {
            repository.updateCheckList(checkList)
        }
    }

    fun updateCheckListCategory(checkListCategory: CheckListCategory) {
        viewModelScope.launch {
            repository.updateCheckListCategory(checkListCategory)
        }
    }

    fun getCheckListItemById(id : Int) {
        viewModelScope.launch {
            repository.getCheckListItemDetailsById(id)
        }
    }

    fun getCheckListCategoryById(id : Int) {
        viewModelScope.launch {
            repository.getCheckListCategoryDetailsById(id)
        }
    }


}

data class HomeState (
    val checkList: List<CheckList> = emptyList(),
    val checkListCategories: List<CheckListCategory> = emptyList(),
    val itemChecked : Boolean = false
)