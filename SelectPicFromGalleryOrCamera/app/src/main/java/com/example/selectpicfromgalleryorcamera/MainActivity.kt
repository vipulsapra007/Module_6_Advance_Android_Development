package com.example.selectpicfromgalleryorcamera

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.content.FileProvider
import com.example.selectpicfromgalleryorcamera.databinding.ActivityMainBinding
import java.io.File
import java.io.FileOutputStream
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    var bitmap:Bitmap?=null
    lateinit var binding: ActivityMainBinding
    private val galleryResultLauncher =
        registerForActivityResult(ActivityResultContracts.OpenDocument()) {
           it?.let {

               bitmap=uriToBitmap(it)

               if (bitmap!=null){
                   binding.ivThumbnail.setImageBitmap(bitmap)

                   setImagePath(bitmap)
               }

           }

        }

    private fun setImagePath(bitmap: Bitmap?) {
        var root=File(filesDir,"Images")
        if (!root.exists()){
            root.mkdir()
        }

        var fileName="${System.currentTimeMillis()}.png"
        var mFile=File(root,fileName)
        try {
            var fout=FileOutputStream(mFile)
            bitmap?.compress(Bitmap.CompressFormat.PNG,100,fout)
            binding.tvPath.setText(mFile.path)
        }catch (e:Exception){
            e.printStackTrace()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivThumbnail.setOnClickListener {

            showSelectionDialog()
        }


    }

    private fun showSelectionDialog() {
        AlertDialog.Builder(this)
            .setTitle("Select From Below Options")
            .setItems(arrayOf("From Gallery"), {

                    dialog, index ->
                when (index) {
                    0 -> {
                        galleryResultLauncher.launch(arrayOf("image/png", "image/jpeg"))
                    }
                }
            }).show()


    }


    private fun uriToBitmap(imageUri: Uri): Bitmap? {

        try {
            var parcelFileDescriptor=contentResolver.openFileDescriptor(imageUri,"r")
            var fileDescriptor=parcelFileDescriptor?.fileDescriptor
            var bitMap=BitmapFactory.decodeFileDescriptor(fileDescriptor)

            parcelFileDescriptor?.close()
            return bitMap

        }catch (e:Exception){
            e.printStackTrace()
        }
        return null

    }


}