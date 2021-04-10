package com.alandstudio3.lista.database.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.alandstudio3.lista.database.room.entities.Item

@Dao
interface ItemDao {

    @Query("select * from ${Item.TABLE_NAME}")
    suspend fun getAll():List<Item>

    @Query("select * from ${Item.TABLE_NAME} where _id = :id")
    suspend fun getById(id: Int):Item

    @Insert
    suspend fun insert(items: List<Item>)

    @Query("delete from ${Item.TABLE_NAME} where _id = :id")
    suspend fun delete(id: Int)

    @Query("delete from ${Item.TABLE_NAME}")
    suspend fun cleanTable()

}