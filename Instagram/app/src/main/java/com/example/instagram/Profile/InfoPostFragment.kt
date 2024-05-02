package com.example.instagram.Profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram.R
import com.example.instagram.SearchImageAdapter
import com.example.instagram.databinding.FragmentInfoPostBinding

class InfoPostFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: InfoPostAdapter // SearchImageAdapter는 Image를 불러오고 이벤트를 처리하는 adapter이다.
    private lateinit var binding : FragmentInfoPostBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoPostBinding.inflate(inflater, container, false)

        // InfoPostFragment 의 recyclerview 를 GridLayout(가로:3) 으로 설정
        recyclerView = binding.infoPostRecyclerView
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)

        // recyclerView 와 getImageList() 에 저장한 이미지 리소스를 InfoPostAdapter 로 연결
        postAdapter = InfoPostAdapter(getPostList())
        recyclerView.adapter = postAdapter

        return binding.root
    }

    private fun getPostList(): List<Int> {
        return listOf(
            R.drawable.grid1,
            R.drawable.grid2,
            R.drawable.android_logo,
            R.drawable.grid2,
            R.drawable.android_logo,
            R.drawable.grid2,
            R.drawable.grid1,
            R.drawable.grid2,
            R.drawable.android_logo,
            R.drawable.grid2,
            R.drawable.android_logo,
            R.drawable.grid2,
            R.drawable.grid1,
            R.drawable.grid2,
            R.drawable.android_logo,
            R.drawable.grid2,
            R.drawable.android_logo,
            R.drawable.grid2,
            R.drawable.grid1,
            R.drawable.grid2,
            R.drawable.android_logo,
            R.drawable.grid2,
            R.drawable.android_logo,
            R.drawable.grid2,
            R.drawable.grid1,
            R.drawable.grid2
        )
    }
}