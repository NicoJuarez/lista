package com.alandstudio3.lista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.alandstudio3.lista.database.room.database.ListDataBase
import com.alandstudio3.lista.database.room.database.ListRepo

class MainActivity : AppCompatActivity() {

    private var database : ListRepo? = null

    override fun onStart() {
        super.onStart()
        ListDataBase.getInstance(this).let {
            database = ListRepo(it)
        }
        Log.d("MAIN::", "onStart: Creando Main activity - valor de repo: $database")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun getDataBaseRepo(): ListRepo? {
        return database
    }
}