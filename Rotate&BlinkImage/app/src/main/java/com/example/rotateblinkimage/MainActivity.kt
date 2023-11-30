package com.example.rotateblinkimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.example.rotateblinkimage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnRotate.setOnClickListener {

            var animation=AnimationUtils.loadAnimation(this,R.anim.rotate)
            binding.ivThumbnail.startAnimation(animation)

        }
        binding.btnBlink.setOnClickListener {
            var animation=AnimationUtils.loadAnimation(this,R.anim.blink)
            binding.ivThumbnail.startAnimation(animation)

        }



    }
}