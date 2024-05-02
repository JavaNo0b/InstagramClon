package com.example.instagram

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.instagram.databinding.ItemPostBinding
import com.example.instagram.model.comment
import com.example.instagram.model.post
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PostRVAdapter(val context: Context, val homeFragment: HomeFragment): RecyclerView.Adapter<PostRVAdapter.ViewHolder>() {

    val items: ArrayList<post> = ArrayList()

    interface MyItemClickListener {
        fun onClickComment(commentList: ArrayList<comment>)
    }

    private lateinit var mItemClickListener: MyItemClickListener
    fun setMyItemClickListener(itemCLickListener: MyItemClickListener){
        mItemClickListener = itemCLickListener
    }


    inner class ViewHolder(val binding: ItemPostBinding): RecyclerView.ViewHolder(binding.root) {}

    fun addItems(items: ArrayList<post>){
        this.items.addAll(items)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostRVAdapter.ViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostRVAdapter.ViewHolder, position: Int) {
        holder.binding.itemPostNicknameTv.text = items[position].userID
        holder.binding.itemPostTitleTv.text = items[position].userID
        if(items[position].imgList.size != 0){
            val vpadapter = PostVPAdapter(homeFragment)
            for(i in items[position].imgList){
                vpadapter.addFragment(PostSubFragment(i.postImgUrl))
            }
            holder.binding.itemPostMainVp.adapter = vpadapter
            holder.binding.itemPostMainVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
            if(items[position].imgList.size != 1){
                holder.binding.itemPostCircleIndicator.setViewPager(holder.binding.itemPostMainVp)
            }
        }
        Glide.with(context).load(items[position].userProfileImg).into(holder.binding.itemPostProfileIv)
        holder.binding.itemPostCommentInfo.text = "댓글 " + items[position].commentNum+"개 모두보기"

        holder.binding.itemPostCommentInfo.setOnClickListener {
            mItemClickListener.onClickComment(items[position].commentList)
        }

        holder.binding.itemPostCommentIv.setOnClickListener {
            mItemClickListener.onClickComment(items[position].commentList)
        }

        //좋아요 클릭 시
        holder.binding.itemPostLikeIv.setOnClickListener {  }
    }

    override fun getItemCount(): Int = items.size
}