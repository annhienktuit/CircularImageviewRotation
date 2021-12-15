package com.annhienktuit.circularrotationimageview
import android.animation.ObjectAnimator
import android.content.Context
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator

class RotateAnimation {
    private var mContext: Context
    private var imageView: CircularImageView
    private var animation: ObjectAnimator
    constructor(context: Context, view: CircularImageView){
        this.mContext = context
        this.imageView = view
        animation= ObjectAnimator.ofFloat(imageView, View.ROTATION, 0f, 360f).setDuration(20000)
    }

    fun startAnimation(){
        animation.repeatCount = Animation.INFINITE
        animation.interpolator = LinearInterpolator()
        animation.start()
    }

    fun pause(){
        animation.pause()
    }

    fun resume(){
        animation.resume()
    }

    fun cancel(){
        animation.cancel()
    }

    fun setDuration(duration: Long){
        animation.duration = duration
    }


}