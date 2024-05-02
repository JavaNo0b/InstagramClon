package com.example.instagram

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

class ImgGVAdatper(): BaseAdapter() {
    private var mContext: Context? = null
    private var images: List<String>? = null
    private var photoListener: PhotoListener? = null
    constructor(mContext: Context, images: List<String>) : this() {
        this.mContext = mContext
        this.images = images
    }

    fun setPhotoListener(photoListener: PhotoListener){
        this.photoListener = photoListener
    }

    public interface PhotoListener {
        fun onPhotoClick(path: String)
    }
    override fun getCount(): Int = images?.size!!

    override fun getItem(p0: Int): Any? = null

    override fun getItemId(p0: Int): Long = 0

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val imageView: ImageView
        if(p1 == null){
            imageView = ImageView(mContext)
            imageView.layoutParams = ViewGroup.LayoutParams(300,300)
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        }else{
            imageView = p1 as ImageView
        }
        if(p0 == 0){
            photoListener?.onPhotoClick(images?.get(p0)!!)
        }
        Glide.with(mContext!!).load(images?.get(p0)).into(imageView)
        imageView.setOnClickListener {
            photoListener?.onPhotoClick(images?.get(p0)!!)
        }
        return imageView
    }
}