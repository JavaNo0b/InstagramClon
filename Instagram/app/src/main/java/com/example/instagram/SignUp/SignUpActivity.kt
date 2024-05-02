package com.example.instagram.SignUp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.instagram.databinding.ActivitySignupBinding

class SignUpActivity: AppCompatActivity(){
    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.signUpNextBtn.setOnClickListener{
            changeSignup2Activity()
        }

    }

    private fun changeSignup2Activity(){
        if(emailCheck() == 1){
            val intent = Intent(this, SignUp2Activity::class.java)
            intent.putExtra("email", binding.signUpEmailInputEt.text.toString())
            startActivity(intent)
        }else{
            Toast.makeText(this, "이메일 형식이 잘못되었습니다.", Toast.LENGTH_SHORT).show()
        }
    }
    private fun emailCheck(): Int{
        val charEmail = binding.signUpEmailInputEt.text.toString().toCharArray()
        val atIndex = charEmail.indexOf('@')
        if (atIndex != -1){
            return 1
        }else{
            return 0
        }
    }
}