package com.proud_indian.planit.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.proud_indian.planit.common.PiConstants
import java.util.Date


@Entity(tableName = "check_list")
data class CheckList(
    @ColumnInfo(name = "list_id")
    @PrimaryKey
    var id : Int,
    var title : String,
    var desc : String,
    var status : String = PiConstants.CHECK_LIST_ITEM_ACTIVE,

    @ColumnInfo(name = "created_at")
    var createdAt : Date,

    @ColumnInfo(name = "done_at")
    var doneAt : Date,

    @ColumnInfo(name = "category_id")
    var categoryId : Int = 0
)
