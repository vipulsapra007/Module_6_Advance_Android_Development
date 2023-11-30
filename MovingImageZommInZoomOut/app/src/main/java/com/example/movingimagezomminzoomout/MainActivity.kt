package com.example.movingimagezomminzoomout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.movingimagezomminzoomout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnZoomIn.setOnClickListener {
            var animation=AnimationUtils.loadAnimation(this,R.anim.zoom_in)
            binding.ivThumbnail.startAnimation(animation)
        }

        binding.btnZoomOut.setOnClickListener {
            var animation=AnimationUtils.loadAnimation(this,R.anim.zoom_out)
            binding.ivThumbnail.startAnimation(animation)
        }

        binding.btnMoveLeft.setOnClickListener {
            var animation=AnimationUtils.loadAnimation(this,R.anim.move_left)
            binding.ivThumbnail.startAnimation(animation)
        }
        binding.btnMoveRight.setOnClickListener {
            var animation=AnimationUtils.loadAnimation(this,R.anim.move_right)
            binding.ivThumbnail.startAnimation(animation)
        }


    }


}