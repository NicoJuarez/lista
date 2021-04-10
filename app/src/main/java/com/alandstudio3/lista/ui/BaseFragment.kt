package com.alandstudio3.lista.ui

import androidx.fragment.app.Fragment
import com.alandstudio3.lista.MainActivity
import com.alandstudio3.lista.database.room.database.ListRepo

open class BaseFragment:Fragment() {

    fun getDataBaseRepo():ListRepo?{
        return if(requireActivity() is MainActivity){
            (activity as MainActivity).getDataBaseRepo()
        }else{
            null
        }
    }


}