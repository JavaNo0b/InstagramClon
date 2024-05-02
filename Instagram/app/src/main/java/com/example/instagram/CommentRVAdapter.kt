package com.example.instagram

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram.databinding.ItemCommentBinding
import com.example.instagram.model.comment

class CommentRVAdapter(val items: ArrayList<comment>): RecyclerView.Adapter<CommentRVAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemCommentBinding): RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentRVAdapter.ViewHolder {
        val binding = ItemCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentRVAdapter.ViewHolder, position: Int) {
        holder.binding.itemCommentNicknameTv.text = items[position].userID
        holder.binding.itemCommentNicknameCommentTv.text = items[position].comentContents
    }

    override fun getItemCount(): Int = items.size
}