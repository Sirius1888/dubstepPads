package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_statistics.*

class StatisticsActivity : AppCompatActivity() {

    var countBoom = 0
    var countClap = 0
    var countHihat = 0
    var countKick = 0
    var countOpenHat = 0
    var countRide = 0
    var countSnare = 0
    var countTink = 0

    var constant = Constants()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)


    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.statistics_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_clear_data -> {
            Toast.makeText(applicationContext, "Statistics is clear...", Toast.LENGTH_SHORT).show()
            clearStatistics()
            getCountPressButton()
            setTextInView()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }


    override fun onResume() {
        super.onResume()
        getCountPressButton()
        setTextInView()
    }

    private fun setTextInView() {
        count_boom_text_view.text = "Boom count is: " + countBoom
        count_clap_text_view.text = "Clap count is: " + countClap
        count_hihat_text_view.text = "Hihat count is: " + countHihat
        count_kick_text_view.text = "Kick count is: " + countKick
        count_openhat_text_view.text = "Openhat count is: " + countOpenHat
        count_ride_text_view.text = "Ride count is: " + countRide
        count_snare_text_view.text = "Snare count is: " + countSnare
        count_tink_text_view.text = "Tink count is: " + countTink
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

    private fun clearStatistics() {
        val sharedPreference =  getSharedPreferences("PREFERENCE_NAME",Context.MODE_PRIVATE)
        val editor = sharedPreference.edit()
        editor.clear()
        editor.apply()

    }
}
