package com.example.instagram.model

import android.util.Log
import com.example.instagram.RetrofitInterface
import com.example.instagram.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//회원가입 및 로그인 기능을 만드는 서비스
class AuthService {
    private lateinit var signUpView: SignUpView
    private lateinit var loginView: LoginView

    fun setSignUpView(signUpView: SignUpView){
        this.signUpView = signUpView
    }

    fun setLoginView(loginView: LoginView) {
        this.loginView = loginView
    }

    fun signUp(user: User){ //회원가입 api를 확인하고 관리
        val authService = getRetrofit().create(RetrofitInterface::class.java)

        authService.signUp(user).enqueue(object: Callback<SignUpResponse> {
            override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>) {
                Log.d("SIGNUP/SUCCESS", response.toString())
                val resp: SignUpResponse = response.body()!!
                Log.d("resp", resp.toString())
                when(resp.returnCode){
                    "COMMON200" -> signUpView.onSignUpSuccess() //returnCode의 값이 COMMON200일 때 회원가입 성공
                    else -> signUpView.onSignUpFailure(resp.returnMsg)
                }
            }

            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                Log.d("SIGNUP/FAILURE", t.message.toString())
            }

        }) //user 의 정보로 API호출
    }

    fun login(user: Login){
        // 로그인 API 를 호출함 : 어떤 주소로 들어가겠다
        val authService = getRetrofit().create(RetrofitInterface::class.java)

        // 여기 안에 유저의 정보를 넣어주면 API 를 호출해주는거임 -> enqueue 로 응답 처리, 네트워크 통신이다보니 비동기적으로 접속해야하므로 queue에 넣는거야
        // 입력한 주소 중에 하나로 연결 시도
        authService.login(user).enqueue(object: retrofit2.Callback<SignUpResponse> {
            // object 에 추가된 메소드 정의
            // onResponse : 응답이 왔을 때 처리하는 부분
            override fun onResponse(
                call: Call<SignUpResponse>,
                response: Response<SignUpResponse>
            ) {
                Log.d("Login/SUCCESS", response.toString())
                val resp: SignUpResponse = response.body()!!      // body 가 정보가 들어있는 곳
                when (val code = resp.returnCode) {
                    "COMMON200" -> loginView.onLoginSuccess(code, resp.result!!)
                    else -> loginView.onLoginFailure(resp)
                }
            }

            // onFailure : 네트워크 연결 자체가 실패했을 때 처리하는 부분
            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                Log.d("LOGIN/FAILURE", t.message.toString())    // 비동기 작업
            }
        })
        Log.d("LOGIN", "HELLO")
    }
}