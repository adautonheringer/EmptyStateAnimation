package com.example.mylottieapp

import android.graphics.Outline
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.ImageView
import androidx.constraintlayout.motion.widget.MotionLayout
import com.airbnb.lottie.LottieAnimationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val motionLayout = findViewById<MotionLayout>(R.id.root)

        makeBlurViewCircle(findViewById<View>(R.id.blur_view))
        setMotionLayoutTransitionListener(motionLayout)
    }

    private fun setMotionLayoutTransitionListener(motionLayout: MotionLayout){
        motionLayout.setTransitionListener(object: MotionLayout.TransitionListener{
            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
            }

            override fun onTransitionCompleted(p0: MotionLayout, p1: Int) {
                if (p1 == (R.id.end)) {

                    p0.getTransition(R.id.swipe_transition).setEnable(false)

                    p0.getTransition(R.id.close_window_transition).setEnable(true)
                    p0.setTransition(R.id.close_window_transition)
                    p0.transitionToEnd()



                    man_part_1_animation.visibility = View.INVISIBLE
                    man_part_1_animation.pauseAnimation()

                    man_part_2_animation.visibility = View.VISIBLE
                    man_part_2_animation.playAnimation()
                } else {

                    p0.getTransition(R.id.close_window_transition).setEnable(false)
                    p0.getTransition(R.id.swipe_transition).setEnable(true)
                    p0.setTransition(R.id.swipe_transition)

                    man_part_1_animation.visibility = View.VISIBLE
                    man_part_1_animation.playAnimation()

                    man_part_2_animation.visibility = View.INVISIBLE
                    man_part_2_animation.pauseAnimation()
                }

            }

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
            }

        })
    }

    private fun makeBlurViewCircle(blurView: View){
        blurView.clipToOutline = true
        blurView.outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View, outline: Outline?) {
                val rect = Rect(0, 0, view.width, view.height)
                outline?.setRoundRect(rect, rect.width() / 2f)
            }
        }
    }


}