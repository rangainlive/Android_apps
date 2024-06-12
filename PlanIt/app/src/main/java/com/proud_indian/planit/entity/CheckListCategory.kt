package com.proud_indian.planit.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "check_list_categories")
data class CheckListCategory(
    @ColumnInfo(name = "category_id")
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,

    @ColumnInfo(name = "category_name")
    val categoryName : String,

    val status : String,

    @ColumnInfo(name = "created_at")
    val createdAt : Date

)
