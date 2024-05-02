package com.example.instagram.Profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.instagram.databinding.FragmentInfoRillsBinding

class InfoLillsFragment : Fragment() {

    private lateinit var binding : FragmentInfoRillsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoRillsBinding.inflate(inflater, container, false)
        return binding.root
    }
}