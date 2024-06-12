package com.proud_indian.bottomnav2.storage.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.util.Date

@Entity
data class CheckList(
    @PrimaryKey(autoGenerate = true)
    var id: Int=0,
    var title: String,
    var desc: String,
    var createdAt: Date,
    var doneAt: Date,
    var listGroupId: Int,
)
