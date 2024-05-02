package com.example.instagram

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram.databinding.ItemStoryBinding

class StoryRVAdapter(val items: ArrayList<String>): RecyclerView.Adapter<StoryRVAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemStoryBinding): RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryRVAdapter.ViewHolder {
        val binding = ItemStoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoryRVAdapter.ViewHolder, position: Int) {
        holder.binding.storyNicknameTv.text = items[position]
    }

    override fun getItemCount(): Int = items.size
}