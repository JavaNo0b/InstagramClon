package com.example.instagram.model

interface LoginView {

    // 코드 값을 받아옴
    fun onLoginSuccess(code : String, result : Result)
    fun onLoginFailure(resp: SignUpResponse)

}