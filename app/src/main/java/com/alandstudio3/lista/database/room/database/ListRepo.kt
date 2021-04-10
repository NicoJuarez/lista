package com.alandstudio3.lista.database.room.database

import com.alandstudio3.lista.database.room.entities.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

class ListRepo(
    private val db: ListDataBase
) {


    fun getAll(): List<Item>{
        return runBlocking (Dispatchers.Default) {
            return@runBlocking db.getItemDao().getAll()
        }
    }

    fun getItemById(id: Int): Item{
        return runBlocking (Dispatchers.Default) {
            return@runBlocking db.getItemDao().getById(id)
        }
    }

    fun insertItem(item: List<Item>){
        return runBlocking (Dispatchers.Default) {
            return@runBlocking db.getItemDao().insert(item)
        }
    }

    fun deleteItem(id: Int){
        return runBlocking (Dispatchers.Default) {
            return@runBlocking db.getItemDao().delete(id)
        }
    }

    fun cleanTable(){
        return runBlocking (Dispatchers.Default) {
            return@runBlocking db.getItemDao().cleanTable()
        }
    }

}