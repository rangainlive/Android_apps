package com.proud_indian.planit.repository

import com.proud_indian.planit.dao.CheckListCategoryDao
import com.proud_indian.planit.dao.CheckListDao
import com.proud_indian.planit.entity.CheckList
import com.proud_indian.planit.entity.CheckListCategory

class PlanItRepository(
    private val checkListDao : CheckListDao,
    private val checkListCategoryDao: CheckListCategoryDao
) {
    //Get All
    val checkList = checkListDao.getAllCheckList()
    val checkListCategory = checkListCategoryDao.getAllCheckListCategories()

    // Get by Id
    fun getCheckListItemDetailsById(id : Int) = checkListDao.getItem(id)
    fun getCheckListCategoryDetailsById(id : Int) = checkListCategoryDao.getCategory(id)

    //Insert
    suspend fun insertCheckList(checkList: CheckList){
        checkListDao.insert(checkList)
    }
    suspend fun insertCheckListCategory(checkListCategory: CheckListCategory){
        checkListCategoryDao.insert(checkListCategory)
    }

    // Delete
    suspend fun deleteCheckList(checkList: CheckList) {
        checkListDao.delete(checkList)
    }

    suspend fun deleteCheckListCategory(checkListCategory: CheckListCategory) {
        checkListCategoryDao.delete(checkListCategory)
    }

    // Update
    suspend fun updateCheckList(checkList: CheckList) {
        checkListDao.update(checkList)
    }

    suspend fun updateCheckListCategory(checkListCategory: CheckListCategory) {
        checkListCategoryDao.update(checkListCategory)
    }

}