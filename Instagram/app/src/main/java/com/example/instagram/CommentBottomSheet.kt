package com.example.instagram

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.instagram.databinding.BottomSheetBinding
import com.example.instagram.model.comment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CommentBottomSheet(val commentList: ArrayList<comment>) : BottomSheetDialogFragment() {

    lateinit var binding: BottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BottomSheetBinding.inflate(layoutInflater)

        val sheet = binding.bottomSheet
        val behaviour = BottomSheetBehavior.from(sheet)
        behaviour.state = BottomSheetBehavior.STATE_EXPANDED


        val commentRVAdapter = CommentRVAdapter(commentList)
        binding.bottomRv.adapter = commentRVAdapter
        binding.bottomRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        binding.bottomSheetEt.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.bottomSheetUpload.visibility = View.GONE
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(p0?.isEmpty() == true){
                    binding.bottomSheetUpload.visibility = View.GONE
                }else{
                    binding.bottomSheetUpload.visibility = View.VISIBLE
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        return binding.root
    }
}