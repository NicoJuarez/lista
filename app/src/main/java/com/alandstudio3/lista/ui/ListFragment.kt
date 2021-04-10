package com.alandstudio3.lista.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.alandstudio3.lista.R
import com.alandstudio3.lista.database.room.database.ListDataBase
import com.alandstudio3.lista.database.room.database.ListRepo
import com.alandstudio3.lista.database.room.entities.Item
import com.alandstudio3.lista.databinding.FragmentListBinding
import com.alandstudio3.lista.ui.recycler.ItemListAdapter


class ListFragment : BaseFragment() {

    private lateinit var binder: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binder =
            FragmentListBinding.bind(inflater.inflate(R.layout.fragment_list, container, false))

        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val repo = ListRepo(ListDataBase.getInstance(requireContext()))

        //            repo.insertItem(listOf(
        //                Item("Aceite")
        //            ))
        val adapter = ItemListAdapter(repo.getAll())
        binder.itemListRecycler.adapter = adapter

        binder.fabButton.setOnClickListener{
            Navigation.findNavController(binder.root).navigate(R.id.addObjectFragment)
        }
    }


}