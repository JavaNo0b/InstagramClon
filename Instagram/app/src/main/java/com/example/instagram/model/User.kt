package com.example.instagram.model

import com.google.gson.annotations.SerializedName

//data class User(
//    val userName: String,
//    val userId: String,
//    val userIntro: String,
//    val userWebsite: String?
//)
data class Response(
    val isSuccess: String,
    val returnCode: String,
    val returnMsg: String,
    val result: String
)
//유저 정보 테이블
data class User(
    @SerializedName(value = "userName") var name : String,
    @SerializedName(value = "userId") var id : String,
    @SerializedName(value = "userEmail") var email : String,
    @SerializedName(value = "userPwd") var password : String,
)

data class Login(
    @SerializedName(value = "userInfo") var id : String,
    @SerializedName(value = "userPwd") var password : String
)
