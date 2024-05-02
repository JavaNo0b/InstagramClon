package com.example.instagram

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

//image의 Res를 list로 받는 adapter
class SearchImageAdapter(private val imageList: List<Int>): RecyclerView.Adapter<SearchImageAdapter.ImageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        //parent의 각 아이템 뷰를 LayoutInflater를 이용해 item_search_grid를 기반으로 생성
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_search_grid, parent, false)
        return ImageViewHolder(view)
    }

    override fun getItemCount(): Int = imageList.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        //해당 position의 imageResource를 받아와 search_imageView의 이미지로 삽입
        val image = imageList[position]
        holder.imageView.setImageResource(image)
    }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.search_imageView)
    }
}