package com.example.mylottieapp

import android.graphics.Outline
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.ImageView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val motionLayout = findViewById<ViewGroup>(R.id.root)
        val lottie = findViewById<View>(R.id.main_animation_1)
        val window = findViewById<ImageView>(R.id.window)
        val blurView = findViewById<View>(R.id.blur_view)

        val outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View, outline: Outline?) {
                val rect = Rect(0, 0, view.width, view.height)
                outline?.setRoundRect(rect, rect.width() / 2f)
            }
        }

        blurView.clipToOutline = true
        blurView.outlineProvider = outlineProvider


    }


}