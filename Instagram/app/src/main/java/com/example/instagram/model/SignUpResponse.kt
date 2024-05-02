package com.example.instagram.model

//회원가입 api 응답
data class SignUpResponse(
    val isSuccess: Boolean,
    val returnCode: String,
    val returnMsg: String,
    val result: Result?
)

data class Result (
    var userIdx:Int,
    var jwt:String
)
