package com.example.instagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.instagram.databinding.FragmentPostSubBinding

class PostSubFragment(val imgUrl: String) : Fragment() {
    lateinit var binding: FragmentPostSubBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostSubBinding.inflate(inflater, container, false)
        Glide.with(this).load(imgUrl).into(binding.fragmentPostSubIv)
        return binding.root
    }

}