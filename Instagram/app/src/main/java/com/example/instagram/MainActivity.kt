package com.example.instagram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.instagram.Profile.ProfileFragment
import com.example.instagram.databinding.ActivityMainBinding

//conner
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        saveJwt("eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VySWR4Ijo0LCJpYXQiOjE3MDM0MzYwNzIsImV4cCI6NjEzMjM2OTg2MTY4NzYwMH0.g_B39Z2uALSb5xvKUWk_YnmgMKZtocBKn-mbn_7_WgY")
        //Bottom Navigation 연결
        initBottomNavigation()
    }

    private fun initBottomNavigation() {

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fm, HomeFragment())
            .commitAllowingStateLoss()
        getSharedPreferences("a", MODE_PRIVATE)
        binding.mainBottomNav.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.home_nav -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_fm, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.search_nav -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_fm, SearchFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.post_nav -> {
                    startActivity(Intent(this, UploadActivity::class.java))
                }
                R.id.profile_nav -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_fm, ProfileFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }

    private fun saveJwt(jwt: String){
        val spf = this?.getSharedPreferences("auth", android.content.Context.MODE_PRIVATE)!!
        val editor = spf.edit()
        editor.putString("jwt", "Bearer $jwt")
        editor.apply()
    }
}