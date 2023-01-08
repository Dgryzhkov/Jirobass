package com.example.jirobass

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity


@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var timer: CountDownTimer


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val mp: Unit = MediaPlayer.create(this, R.raw.splash_audio).start()


        timer = object : CountDownTimer(2000, 2000) {

            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))

            }
        }.start()

    }

    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }
}