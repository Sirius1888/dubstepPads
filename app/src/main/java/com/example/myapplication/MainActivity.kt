package com.example.myapplication

import android.animation.ValueAnimator
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.view.animation.Animation
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    val soundPool: SoundPool = SoundPool(5, AudioManager.STREAM_MUSIC, 0)
    val constant = Constants()
    var countBoom: Int = 0
    var countClap: Int = 0
    var countHihat: Int = 0
    var countKick: Int = 0
    var countOpenHat: Int = 0
    var countRide: Int = 0
    var countSnare: Int = 0
    var countTink: Int = 0

    private lateinit var mRandom:Random
    private lateinit var mHandler: Handler
    private lateinit var mRunnable:Runnable


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getCountPressButton()
        initializeSounds()


    }


    private fun initializeSounds() {

        boom_play_sound_button.setOnClickListener {
            val soundIdBoom: Int = soundPool.load(application, R.raw.boom1, 1)
            saveCountOfPressButton(boom_play_sound_button)
            soundPool.play(soundIdBoom, 1F, 1F,0,0, 1F)
            changColorAnim(boom_play_sound_button)
            resetColor()
        }

        clap_play_sound_button.setOnClickListener {
            val soundIdClap: Int = soundPool.load(applicationContext, R.raw.clap, 1)
            saveCountOfPressButton(clap_play_sound_button)
            soundPool.play(soundIdClap, 1F, 1F,0,0, 1F)
            changColorAnim(clap_play_sound_button)
            resetColor()
        }

        hihat_play_sound_button.setOnClickListener {
            val soundIdHihat: Int = soundPool.load(applicationContext, R.raw.hihat, 1)
            saveCountOfPressButton(hihat_play_sound_button)
            soundPool.play(soundIdHihat, 1F, 1F,0,0, 1F)
            changColorAnim(hihat_play_sound_button)
            resetColor()
        }

        kick_play_sound_button.setOnClickListener {
            val soundIdKick: Int = soundPool.load(applicationContext, R.raw.kick, 1)
            saveCountOfPressButton(kick_play_sound_button)
            soundPool.play(soundIdKick, 1F, 1F,0,0, 1F)
            changColorAnim(kick_play_sound_button)
            resetColor()
        }

        openhat_play_sound_button.setOnClickListener {
            val soundIdOpenHat: Int = soundPool.load(applicationContext, R.raw.openhat, 1)
            saveCountOfPressButton(openhat_play_sound_button)
            soundPool.play(soundIdOpenHat, 1F, 1F,0,0, 1F)
            changColorAnim(openhat_play_sound_button)
            resetColor()
        }

        ride_play_sound_button.setOnClickListener {
            val soundIdRide: Int = soundPool.load(applicationContext, R.raw.ride, 1)
            saveCountOfPressButton(ride_play_sound_button)
            soundPool.play(soundIdRide, 1F, 1F,0,0, 1F)
            changColorAnim(ride_play_sound_button)
            resetColor()
        }

        snare_play_sound_button.setOnClickListener {
            val soundIdSnare: Int = soundPool.load(applicationContext, R.raw.snare, 1)
            saveCountOfPressButton(snare_play_sound_button)
            soundPool.play(soundIdSnare, 1F, 1F,0,0, 1F)
            changColorAnim(snare_play_sound_button)
            resetColor()
        }

        tink_play_sound_button.setOnClickListener {
            val soundIdTink: Int = soundPool.load(applicationContext, R.raw.tink, 1)
            saveCountOfPressButton(tink_play_sound_button)
            soundPool.play(soundIdTink, 1F, 1F,0,0, 1F)
            changColorAnim(tink_play_sound_button)
            resetColor()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_next_statistic_activity -> {
            Toast.makeText(applicationContext, "It's a statistic's activity", Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext, StatisticsActivity::class.java)
            startActivity(intent)
            true
        }
        else -> super.onOptionsItemSelected(item)
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
        anim.setDuration(999)
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

    private fun saveCountOfPressButton(button: Button) {
        val sharedPreference =  getSharedPreferences("PREFERENCE_NAME",Context.MODE_PRIVATE)
        val editor = sharedPreference.edit()
        when(button) {
            boom_play_sound_button -> {
                editor.putInt(constant.COUNT_BOOM, ++countBoom)
            }
            clap_play_sound_button -> {
                editor.putInt(constant.COUNT_CLAP, ++countClap)
            }
            hihat_play_sound_button -> {
                editor.putInt(constant.COUNT_HIHAT, ++countHihat)
            }
            kick_play_sound_button -> {
                editor.putInt(constant.COUNT_KICK, ++countKick)
            }
            openhat_play_sound_button -> {
                editor.putInt(constant.COUNT_OPENHAT, ++countOpenHat)
            }
            ride_play_sound_button -> {
                editor.putInt(constant.COUNT_RIDE, ++countRide)
            }
            snare_play_sound_button -> {
                editor.putInt(constant.COUNT_SNARE, ++countSnare)
            }
            tink_play_sound_button -> {
                editor.putInt(constant.COUNT_TINK, ++countTink)
            }
        }
        editor.apply()

    }

    private fun getCountPressButton() {
        val sharedPreference =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        countBoom = sharedPreference.getInt(constant.COUNT_BOOM,0)
        countClap = sharedPreference.getInt(constant.COUNT_CLAP,0)
        countHihat = sharedPreference.getInt(constant.COUNT_HIHAT,0)
        countKick = sharedPreference.getInt(constant.COUNT_KICK,0)
        countOpenHat = sharedPreference.getInt(constant.COUNT_OPENHAT,0)
        countRide = sharedPreference.getInt(constant.COUNT_RIDE,0)
        countSnare = sharedPreference.getInt(constant.COUNT_SNARE,0)
        countTink = sharedPreference.getInt(constant.COUNT_TINK,0)
    }
}
