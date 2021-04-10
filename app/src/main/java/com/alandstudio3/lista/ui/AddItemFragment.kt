package com.alandstudio3.lista.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.navigation.Navigation
import com.alandstudio3.lista.R
import com.alandstudio3.lista.database.room.database.ListDataBase
import com.alandstudio3.lista.database.room.database.ListRepo
import com.alandstudio3.lista.database.room.entities.Item
import com.alandstudio3.lista.databinding.FragmentAddObjectBinding
import com.google.android.material.snackbar.Snackbar


class AddItemFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_object, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = FragmentAddObjectBinding.bind(view)

        binding.addButton.setOnClickListener{
            val text = binding.productInputEdit.text
            if(text != null && text.isNotEmpty()){
                val repo = ListRepo(ListDataBase.getInstance(requireContext()))

                repo.insertItem(listOf(
                    Item(text.toString())
                ))
                binding.productInputEdit.text = null
                Snackbar.make(view, "Agregado: $text", Snackbar.LENGTH_SHORT)
                    .setAnimationMode(Snackbar.ANIMATION_MODE_SLIDE)
                    .show();
            }
        }

        binding.backButton.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(R.id.listFragment)
        }
    }




}