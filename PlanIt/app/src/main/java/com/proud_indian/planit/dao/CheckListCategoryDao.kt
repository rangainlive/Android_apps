package com.proud_indian.planit.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.proud_indian.planit.entity.CheckList
import com.proud_indian.planit.entity.CheckListCategory
import kotlinx.coroutines.flow.Flow

@Dao
interface CheckListCategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(checkListCategory : CheckListCategory)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(checkListCategory: CheckListCategory)

    @Delete
    suspend fun delete(checkListCategory: CheckListCategory)

    @Query("SELECT * FROM check_list_categories")
    fun getAllCheckListCategories(): Flow<List<CheckListCategory>>

    @Query("SELECT * FROM check_list_categories WHERE category_id = :id")
    fun getCategory(id : Int): Flow<CheckListCategory>
}

/***
 * Query("""
 * SELECT * FROM items AS I
 * INNER JOIN shopping_list AS SL ON I.listIdFk = SL.list_id
 * INNER JOIN stores AS ST ON I.storeIdFk = ST.store_id
 * """)
 */

/***
 * data class ItemsWithStoreAndList (
 *      @Embedded val item : Item,
 *      @Embedded val shoppingList : ShoppingList,
 *      @Embedded val store : Store,
 */