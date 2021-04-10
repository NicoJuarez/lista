package com.alandstudio3.lista.database.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alandstudio3.lista.database.room.dao.ItemDao
import com.alandstudio3.lista.database.room.entities.Item

@Database(
    entities = [Item::class],
    version = 1,
    exportSchema = false
)
abstract class ListDataBase : RoomDatabase() {

    abstract fun getItemDao(): ItemDao

    companion object {

        private const val DATA_BASE_NAME = "lista_data_base"

        @Volatile
        private var instance: ListDataBase? = null

        fun getInstance(context: Context) =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context,
                    ListDataBase::class.java,
                    DATA_BASE_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build().also { instance = it }
            }


//        fun getInstance(context: Context): ListDataBase? {
//
//            instance?.let {
//                instance = Room.databaseBuilder(
//                    context,
//                    ListDataBase::class.java,
//                    DATA_BASE_NAME
//                )
//                    .fallbackToDestructiveMigration()
//                    .build()
//                return@let instance
//            }
//
//            return instance
//        }

    }

}