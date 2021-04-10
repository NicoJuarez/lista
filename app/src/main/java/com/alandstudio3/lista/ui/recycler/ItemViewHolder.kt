package com.alandstudio3.lista.ui.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alandstudio3.lista.database.room.entities.Item
import com.alandstudio3.lista.databinding.ItemViewHolderLayoutBinding

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binder: ItemViewHolderLayoutBinding = ItemViewHolderLayoutBinding.bind(itemView)

    fun bind(item: Item){
        binder.item.text = item.name
    }

}