package com.example.instagram.model

data class posts(
    val isSuccess: String,
    val returnCode: String,
    val returnMsg: String,
    val result: ArrayList<post>
)

data class post(
    val postIdx: Int,
    val userProfileImg: String,
    val postContent: String,
    val commentNum: Int,
    val uploadTime: String,
    val imgList: ArrayList<image>,
    val commentList: ArrayList<comment>,
    val userID: String
)

