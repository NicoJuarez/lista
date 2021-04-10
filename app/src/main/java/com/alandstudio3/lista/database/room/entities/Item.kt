package com.alandstudio3.lista.database.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = Item.TABLE_NAME)
data class Item(
    @ColumnInfo(name = NAME)
    val name: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var id: Int = 0

    companion object {
        const val TABLE_NAME = "ITEM_TABLE"
        const val ID = "_id"
        const val NAME = "_name"
    }
}
