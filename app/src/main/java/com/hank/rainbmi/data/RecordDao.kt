package com.hank.rainbmi.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RecordDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(recod: Record)

    @Query("select * from Record")
    fun gatAll(): List<Record>

}