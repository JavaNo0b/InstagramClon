package com.example.instagram.SignUp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.instagram.Login.LoginActivity
import com.example.instagram.databinding.ActivitySignup2Binding
import com.example.instagram.model.AuthService
import com.example.instagram.model.SignUpView
import com.example.instagram.model.User

class SignUp2Activity: AppCompatActivity(), SignUpView {
    lateinit var binding: ActivitySignup2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignup2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //계속 진행하기 누를 시 회원가입 진행
        binding.signUp2SignUpBtn.setOnClickListener{
            signUp()
        }

    }

    //입력받은 정보를 User타입으로 기입
    private fun getUser(): User {
        val email:String = (intent.getStringExtra("email")).toString()
        Log.d("email", email)
        val pwd:String = binding.signUp2PasswordInputEt.text.toString()
        val name: String = binding.signUp2NameInputEt.text.toString()
        val id: String = getId(email)

        return User(name, id, email, pwd)
    }

    //입력받은 이메일에서 @앞부분을 출력하는 코드
    private fun getId(email: String): String {
        val charEmail = email.toCharArray()
        val atIndex = charEmail.indexOf('@')
        var id: String =""
        if (atIndex != -1) {
            // "@" 이전까지의 문자열 추출
            id = email.substring(0, atIndex)}
        return id
    }

    private fun signUp(){
        if(binding.signUp2NameInputEt.text.toString().isEmpty()){
            Toast.makeText(this, "이름 형식이 잘못되었습니다.", Toast.LENGTH_SHORT).show()
            return
        }
        if(binding.signUp2PasswordInputEt.text.toString().isEmpty()){
            Toast.makeText(this, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
            return
        }
        val authService = AuthService()
        authService.setSignUpView(this)

        authService.signUp(getUser()) //getUser에서 저장한 User타입의 정보를 회원가입 api에 보냄
    }

    override fun onSignUpSuccess() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    override fun onSignUpFailure(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}