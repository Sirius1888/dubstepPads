package com.example.myapplication

import android.content.Context
import android.graphics.Color
import android.media.AudioManager
import android.media.AudioManager.STREAM_MUSIC
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
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

    fun boomPlaySound(soundIdBoom: Int) {
        boom_play_sound_button.setOnClickListener {
            soundPool.play(soundIdBoom, 1F, 1F,0,0, 1F)
            mRunnable = Runnable {
                boom_play_sound_button.setBackgroundColor(randomHSVColor())
                mHandler.postDelayed(mRunnable, 100)
            }

//            val timer = Timer()
//            val monitor = object : TimerTask() {
//                override fun run() {
//                boom_play_sound_button.setBackgroundColor(resources.getColor(R.color.myColor))
//                }
//            }
//            timer.schedule(monitor, 100, 100)


        }
    }

    fun randomHSVColor(): Int {
        // Generate a random hue value between 0 to 360
        val hue = mRandom.nextInt(361)
        // We make the color depth full
        val saturation = 1.0f
        // We make a full bright color
        val value = 1.0f
        // We avoid color transparency
        val alpha = 255
        // Finally, generate the color
        // Return the color
        return Color.HSVToColor(alpha, floatArrayOf(hue.toFloat(), saturation, value))
    }


    private fun clapPlaySound(soundIdClap: Int) {
        clap_play_sound_button.setOnClickListener {
            soundPool.play(soundIdClap, 1F, 1F,0,0, 1F)
            boom_play_sound_button.setTextColor(randomHSVColor())

        }
    }

    private fun hihatPlaySound(soundIdHihat: Int) {
        hihat_play_sound_button.setOnClickListener {
            soundPool.play(soundIdHihat, 1F, 1F,0,0, 1F)
        }
    }

    private fun kickPlaySound(soundIdKick: Int) {
        kick_play_sound_button.setOnClickListener {
            soundPool.play(soundIdKick, 1F, 1F,0,0, 1F)
        }
    }

    private fun openhatPlaySound(soundIdOpenHat: Int) {
        openhat_play_sound_button.setOnClickListener {
            soundPool.play(soundIdOpenHat, 1F, 1F,0,0, 1F)
        }
    }

    private fun ridePlaySound(soundIdRide: Int) {
        ride_play_sound_button.setOnClickListener {
            soundPool.play(soundIdRide, 1F, 1F,0,0, 1F)
        }
    }

    private fun snarePlaySound(soundIdSnare: Int) {
        snare_play_sound_button.setOnClickListener {
            soundPool.play(soundIdSnare, 1F, 1F,0,0, 1F)
        }
    }

    private fun tinkPlaySound(soundIdTink: Int) {
        tink_play_sound_button.setOnClickListener {
            soundPool.play(soundIdTink, 1F, 1F,0,0, 1F)
        }
    }
}
