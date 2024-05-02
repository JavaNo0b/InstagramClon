package com.example.instagram
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.instagram.databinding.ActivityUploadBinding

class UploadActivity : AppCompatActivity() {

    lateinit var binding: ActivityUploadBinding
    private var images: ArrayList<String> = ArrayList()
    private val MY_READ_PERMISSION_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.closeIv.setOnClickListener {
            finish()
        }
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), MY_READ_PERMISSION_CODE)
        }else{
            loadImages()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode == MY_READ_PERMISSION_CODE){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Read external storage permission granted", Toast.LENGTH_SHORT).show()
                loadImages()
            }else{
                Toast.makeText(this, "Read external storage permission denied", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loadImages(){
        var imagesGallery = ImagesGallery()
        images = imagesGallery.listOfImages(this)
        Log.d("images", images.toString())
        var imgGVAdapter = ImgGVAdatper(this, images)
        imgGVAdapter.setPhotoListener(object: ImgGVAdatper.PhotoListener{
            override fun onPhotoClick(path: String) {
                Glide.with(this@UploadActivity).load(path).into(binding.postIv)
            }
        })
        binding.uploadGv.adapter = imgGVAdapter

    }
}