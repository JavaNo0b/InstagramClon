package com.example.instagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var imageAdapter: SearchImageAdapter // SearchImageAdapter는 Image를 불러오고 이벤트를 처리하는 adapter이다.
    lateinit var binding: FragmentSearchBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(layoutInflater)


        // searchFragment의 recyclerview를 GridLayout(가로3)으로 설정
        recyclerView = binding.searchRecyclerView
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)

        // recyclerView와 getImageList()에 저장한 이미지 리소스 리스트를 SearchImageAdapter로 연결
        imageAdapter = SearchImageAdapter(getImageList())
        recyclerView.adapter = imageAdapter

        return binding.root
    }

    private fun getImageList(): List<Int>{
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
            R.drawable.grid2,
        )
    }
}