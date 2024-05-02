package com.example.instagram

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.instagram.databinding.FragmentHomeBinding
import com.example.instagram.model.comment
import com.example.instagram.model.posts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var postRVAdapter: PostRVAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        getPosts()
        initRecyclerView()
        return binding.root
    }

    //RecyclerView 초기화하기
    private fun initRecyclerView(){
        //테스트 데이터 넣어주기
        var items : ArrayList<String> = ArrayList()
        items.add("yunsuk1")
        items.add("yunsuk2")
        items.add("yunsuk3")
        items.add("yunsuk4")
        items.add("yunsuk5")
        items.add("yunsuk6")
        items.add("yunsuk7")
        items.add("yunsuk8")
        items.add("yunsuk9")
        items.add("yunsuk10")
        //스토리 ReyclerView에 adapter 연결
        binding.homeStoryRv.adapter = StoryRVAdapter(items)
        binding.homeStoryRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        //게시물 RecyclerView에 adapter 연결
        postRVAdapter = PostRVAdapter(requireContext(), this@HomeFragment)
        postRVAdapter.setMyItemClickListener(object: PostRVAdapter.MyItemClickListener{
            override fun onClickComment(commentList: ArrayList<comment>) {
                showBottomDialog(commentList)
            }
        })
        binding.homePostRv.adapter = postRVAdapter
        binding.homePostRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun getJwt(): String?{
        val spf = context?.getSharedPreferences("auth", android.content.Context.MODE_PRIVATE)!!
        return spf.getString("jwt", null)
    }

    private fun getPosts(){
        val service = getRetrofit().create(RetrofitInterface::class.java)
        Log.d("jwt", getJwt().toString())
        getJwt()?.let { service.getHomePosts(it).enqueue(object: Callback<posts>{
            override fun onResponse(call: Call<posts>, response: Response<posts>) {
                val resp = response.body()!!
                Log.d("getPosts_resp", resp?.returnCode.toString())
                when(resp.returnCode){
                    "DB500" -> {
                        Log.d("getPosts[DB500]", "데이터베이스 연결에 실패하였습니다.")
                    }
                    "TOKEN400" -> {
                        Log.d("getPosts[TOKEN400]", "Jwt Not Exist")
                    }
                    "COMMON200" -> {
                        Log.d("getPosts[SUCCESS]", resp.result.toString())
                        postRVAdapter.addItems(resp.result)
                    }
                }
            }

            override fun onFailure(call: Call<posts>, t: Throwable) {
                Log.d("getPosts: onFailure", t.message.toString())
            }

        })}
    }

    private fun showBottomDialog(commentList: ArrayList<comment>) {
        val bottomsheet = CommentBottomSheet(commentList)
        bottomsheet.show(requireActivity().supportFragmentManager, "CommentBottomSheet")
    }



}