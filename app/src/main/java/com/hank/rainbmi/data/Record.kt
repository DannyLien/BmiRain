package com.hank.rainbmi.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity
class Record(
    @NotNull
    @ColumnInfo(name = "nick")
    var nickname: String,
    var counter: Int,
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
) {



}