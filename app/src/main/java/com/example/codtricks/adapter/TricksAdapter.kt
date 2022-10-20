package com.example.codtricks.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.codtricks.data.ItemTricks
import com.example.codtricks.databinding.ItemTricksBinding

class TricksAdapter(val data :ArrayList<ItemTricks>) : RecyclerView.Adapter<TricksAdapter.ItemTricksHolder>() {
    lateinit var binding : ItemTricksBinding
    inner class ItemTricksHolder (itemView : View) :RecyclerView.ViewHolder(itemView){

        fun bindItem (position: Int) {
            Glide.with(itemView.context)
                .load(data[position].url)
                .into(binding.imgTricks)
            binding.txtTricksTitle.text = data[position].title
            binding.txtTricksSubtitle.text = data[position].subTitle
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemTricksHolder {
        binding = ItemTricksBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return ItemTricksHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ItemTricksHolder, position: Int) {
        holder.bindItem(position)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}