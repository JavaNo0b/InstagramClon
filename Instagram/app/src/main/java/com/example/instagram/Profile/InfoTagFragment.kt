package com.example.instagram.Profile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.instagram.RetrofitInterface
import com.example.instagram.model.Response
import com.example.instagram.model.User
import retrofit2.Call
import retrofit2.Callback
import com.example.instagram.databinding.FragmentInfoTagBinding
import com.example.instagram.getRetrofit

class InfoTagFragment : Fragment() {

    private lateinit var binding: FragmentInfoTagBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoTagBinding.inflate(inflater, container, false)
        return binding.root
    }
}