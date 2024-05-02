package com.example.instagram.model

data class UserInfo(
    val isSuccess: String,
    val returnCode: String,
    val returnMsg: String,
    val result: Info
)

data class Info(
    val userIdx: Int,
    val userName: String,
    val userIntro: String,
    val userWebsite: String?,
    val userProfileImg: String,
    val postNum: Int,
    val followerNum: Int,
    val followingNum: Int,
    val userID: String
)
