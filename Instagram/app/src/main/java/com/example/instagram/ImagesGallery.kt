package com.example.instagram

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore

class ImagesGallery {

    fun listOfImages(context: Context): ArrayList<String> {
        var uri: Uri
        var cursor: Cursor
        var column_index_data: Int
        var listOfAllImages: ArrayList<String> = ArrayList()
        var absolutePathOfImage: String
        uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        var projection = arrayOf(MediaStore.MediaColumns.DATA, MediaStore.Images.Media.BUCKET_DISPLAY_NAME)

        var orderBy: String = MediaStore.Video.Media.DATE_TAKEN
        cursor = context.contentResolver.query(uri, projection, null, null, orderBy + " DESC")!!

        column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA)

        while (cursor.moveToNext()){
            absolutePathOfImage = cursor.getString(column_index_data)
            listOfAllImages.add(absolutePathOfImage)
        }
        return listOfAllImages
    }
}