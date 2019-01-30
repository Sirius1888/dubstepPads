package com.example.myapplication

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Color
import android.graphics.Color.WHITE
import android.media.AudioManager
import android.media.AudioManager.STREAM_MUSIC
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.widget.Button
import androidx.core.os.postDelayed
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.util.*

class MainActivity : AppCompatActivity() {
    var count: Int = 0
    val soundPool: SoundPool = SoundPool(5, AudioManager.STREAM_MUSIC, 0)

    private lateinit var mRandom:Random
    private lateinit var mHandler: Handler
    private lateinit var mRunnable:Runnable



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mHandler = Handler()

        val soundIdBoom: Int = soundPool.load(application, R.raw.boom1, 1)
        val soundIdClap: Int = soundPool.load(applicationContext, R.raw.clap, 1)
        val soundIdHihat: Int = soundPool.load(applicationContext, R.raw.hihat, 1)
        val soundIdKick: Int = soundPool.load(applicationContext, R.raw.kick, 1)
        val soundIdOpenHat: Int = soundPool.load(applicationContext, R.raw.openhat, 1)
        val soundIdRide: Int = soundPool.load(applicationContext, R.raw.ride, 1)
        val soundIdSnare: Int = soundPool.load(applicationContext, R.raw.snare, 1)
        val soundIdTink: Int = soundPool.load(applicationContext, R.raw.tink, 1)


        boomPlaySound(soundIdBoom)
        clapPlaySound(soundIdClap)
        hihatPlaySound(soundIdHihat)
        kickPlaySound(soundIdKick)
        openhatPlaySound(soundIdOpenHat)
        ridePlaySound(soundIdRide)
        snarePlaySound(soundIdSnare)
        tinkPlaySound(soundIdTink)

    }
    private fun resetColor(button: Button) {
        Handler().postDelayed({
            button.setBackgroundColor(getResources().getColor(R.color.whiteButtons))
        }, 1010)
    }

    private fun resetColor() {
        Handler().postDelayed({
            boom_play_sound_button.setBackgroundColor(getResources().getColor(R.color.whiteButtons))
            clap_play_sound_button.setBackgroundColor(getResources().getColor(R.color.whiteButtons))
            hihat_play_sound_button.setBackgroundColor(getResources().getColor(R.color.whiteButtons))
            kick_play_sound_button.setBackgroundColor(getResources().getColor(R.color.whiteButtons))
            openhat_play_sound_button.setBackgroundColor(getResources().getColor(R.color.whiteButtons))
            ride_play_sound_button.setBackgroundColor(getResources().getColor(R.color.whiteButtons))
            snare_play_sound_button.setBackgroundColor(getResources().getColor(R.color.whiteButtons))
            tink_play_sound_button.setBackgroundColor(getResources().getColor(R.color.whiteButtons))
        }, 1010)
    }


    fun changColorAnim(button: Button) {
        val anim: ValueAnimator = ValueAnimator.ofFloat(0f, 1f)
        anim.setDuration(1000)
        val hsv: FloatArray = floatArrayOf(0f,1f,1f)
        var runColor: Int

        anim.addUpdateListener(ValueAnimator.AnimatorUpdateListener() { animation: ValueAnimator ->
            hsv[0] = 360 * animation.animatedFraction // 360 * animation.animatedFraction
            runColor = Color.HSVToColor(hsv)
            button.setBackgroundColor(runColor)

        })
        anim.repeatCount = Animation.ABSOLUTE
        anim.start()
    }


    fun boomPlaySound(soundIdBoom: Int) {
        boom_play_sound_button.setOnClickListener {
            soundPool.play(soundIdBoom, 1F, 1F,0,0, 1F)
            changColorAnim(boom_play_sound_button)
//            resetColor(boom_play_sound_button)
            resetColor()
        }

    }



    private fun clapPlaySound(soundIdClap: Int) {
        clap_play_sound_button.setOnClickListener {
            soundPool.play(soundIdClap, 1F, 1F,0,0, 1F)
            changColorAnim(clap_play_sound_button)
//            resetColor(clap_play_sound_button)
            resetColor()
        }
    }

    private fun hihatPlaySound(soundIdHihat: Int) {
        hihat_play_sound_button.setOnClickListener {
            soundPool.play(soundIdHihat, 1F, 1F,0,0, 1F)
            changColorAnim(hihat_play_sound_button)
//            resetColor(hihat_play_sound_button)
            resetColor()
        }
    }

    private fun kickPlaySound(soundIdKick: Int) {
        kick_play_sound_button.setOnClickListener {
            soundPool.play(soundIdKick, 1F, 1F,0,0, 1F)
            changColorAnim(kick_play_sound_button)
//            resetColor(kick_play_sound_button)
            resetColor()
        }
    }

    private fun openhatPlaySound(soundIdOpenHat: Int) {
        openhat_play_sound_button.setOnClickListener {
            soundPool.play(soundIdOpenHat, 1F, 1F,0,0, 1F)
            changColorAnim(openhat_play_sound_button)
//            resetColor(openhat_play_sound_button)
            resetColor()
        }
    }

    private fun ridePlaySound(soundIdRide: Int) {
        ride_play_sound_button.setOnClickListener {
            soundPool.play(soundIdRide, 1F, 1F,0,0, 1F)
            changColorAnim(ride_play_sound_button)
//            resetColor(ride_play_sound_button)
            resetColor()
        }
    }

    private fun snarePlaySound(soundIdSnare: Int) {
        snare_play_sound_button.setOnClickListener {
            soundPool.play(soundIdSnare, 1F, 1F,0,0, 1F)
            changColorAnim(snare_play_sound_button)
//            resetColor(snare_play_sound_button)
            resetColor()
        }
    }

    private fun tinkPlaySound(soundIdTink: Int) {
        tink_play_sound_button.setOnClickListener {
            soundPool.play(soundIdTink, 1F, 1F,0,0, 1F)
            changColorAnim(tink_play_sound_button)
//            resetColor(tink_play_sound_button)
            resetColor()
        }
    }
}
