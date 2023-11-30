package com.example.framebyframeanimation

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.framebyframeanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var frameAnimation:AnimationDrawable
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    override fun onStart() {
        super.onStart()
        binding.imageView.setBackgroundResource(R.drawable.battery_animation_list)
        frameAnimation=binding.imageView.background as AnimationDrawable
        frameAnimation.start()


    }
}