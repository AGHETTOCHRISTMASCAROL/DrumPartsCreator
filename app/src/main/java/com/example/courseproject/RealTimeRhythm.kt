package com.example.courseproject

import android.content.Intent
import android.media.MediaPlayer
import android.media.SoundPool
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MotionEvent
import android.view.View
import android.view.View.OnClickListener
import android.widget.*
import android.widget.CompoundButton.OnCheckedChangeListener
import androidx.appcompat.app.AppCompatActivity
import com.example.courseproject.core.ManeValues
import java.util.*
import kotlin.concurrent.timerTask

class RealTimeRhythm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)

        setContentView(R.layout.activity_real_time_rhythm)

        ManeValues.metronomeBeepDPlayer = MediaPlayer.create(this, R.raw.rim)
        ManeValues.metronomeBeepCPlayer = MediaPlayer.create(this, R.raw.rim)

        for(i in 0 until 9){
            val soundPool = SoundPool.Builder()
                .setMaxStreams(1)
                .setAudioAttributes(ManeValues.audioAttributes)
                .build()
            ManeValues.soundPools.add(i, soundPool)
        }

        ManeValues.pads[0] = ManeValues.soundPools[0].load(this, R.raw.kick, 0)
        ManeValues.pads[1] = ManeValues.soundPools[1].load(this, R.raw.hihat, 0)
        ManeValues.pads[2] = ManeValues.soundPools[2].load(this, R.raw.snare, 0)
        ManeValues.pads[3] = ManeValues.soundPools[3].load(this, R.raw.openhat, 0)
        ManeValues.pads[4] = ManeValues.soundPools[4].load(this, R.raw.rim, 0)
        ManeValues.pads[5] = ManeValues.soundPools[5].load(this, R.raw.clap, 0)
        ManeValues.pads[6] = ManeValues.soundPools[6].load(this, R.raw.cowbell, 0)
        ManeValues.pads[7] = ManeValues.soundPools[7].load(this, R.raw.vox, 0)
        ManeValues.pads[8] = ManeValues.soundPools[8].load(this, R.raw.bass_808, 0)


        val btnPad1: Button = findViewById(R.id.btnPad1)
        val btnPad2: Button = findViewById(R.id.btnPad2)
        val btnPad3: Button = findViewById(R.id.btnPad3)
        val btnPad4 :Button = findViewById(R.id.btnPad4)
        val btnPad5 :Button = findViewById(R.id.btnPad5)
        val btnPad6 :Button = findViewById(R.id.btnPad6)
        val btnPad7 :Button = findViewById(R.id.btnPad7)
        val btnPad8 :Button = findViewById(R.id.btnPad8)
        val btnPad9 :Button = findViewById(R.id.btnPad9)

        val btnEdit: Button = findViewById(R.id.btnEdit)
        btnEdit.setOnClickListener(menuManager)

        btnPad1.setOnTouchListener(drumTouchListener)
        btnPad2.setOnTouchListener(drumTouchListener)
        btnPad3.setOnTouchListener(drumTouchListener)
        btnPad4.setOnTouchListener(drumTouchListener)
        btnPad5.setOnTouchListener(drumTouchListener)
        btnPad6.setOnTouchListener(drumTouchListener)
        btnPad7.setOnTouchListener(drumTouchListener)
        btnPad8.setOnTouchListener(drumTouchListener)
        btnPad9.setOnTouchListener(drumTouchListener)
    }

    private val drumTouchListener = object : View.OnTouchListener {
        override fun onTouch(view: View?, event: MotionEvent?): Boolean {
            when(event?.actionMasked){
                MotionEvent.ACTION_DOWN, MotionEvent.ACTION_POINTER_DOWN ->{
                    when (view?.id) {
                        R.id.btnPad1 -> {
                            playDrumCutItself(ManeValues.pads[0], 0)
                        }

                        R.id.btnPad2 -> {
                            playDrumCutItself(ManeValues.pads[1], 1)
                        }

                        R.id.btnPad3 -> {
                            playDrumCutItself(ManeValues.pads[2], 2)
                        }

                        R.id.btnPad4 -> {
                            playDrumCutItself(ManeValues.pads[3], 3)
                        }

                        R.id.btnPad5 -> {
                            playDrumCutItself(ManeValues.pads[4], 4)
                        }

                        R.id.btnPad6 -> {
                            playDrumCutItself(ManeValues.pads[5], 5)
                        }

                        R.id.btnPad7 -> {
                            playDrumCutItself(ManeValues.pads[6], 6)
                        }

                        R.id.btnPad8 -> {
                            playDrumCutItself(ManeValues.pads[7], 7)
                        }

                        R.id.btnPad9 -> {
                            playDrumCutItself(ManeValues.pads[8], 8)
                        }
                    }
                }
            }
            view?.performClick()
            return false
        }
    }

    internal val menuManager = OnClickListener { view ->
        when(view.id){
            R.id.btnEdit -> {
                val intent = Intent(this, RhythmicGridActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivity(intent)
            }
        }
    }

    private fun playDrumCutItself(pad: Int, pool: Int){
        ManeValues.soundPools[pool].play(pad, 1.0f, 1.0f, 0, 0, 1.0f)
    }
}