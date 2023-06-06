package com.example.courseproject.core

import android.media.MediaPlayer

object ManeValues{
    internal var bpm: Int = 120 // beats per minute
    internal var beatDuration: Long = 500 //60_000/120
    internal var step: Double = 0.5 //Rhythmic grid step = 1/2
    internal var stepDuration :Long = 250 //step * beatDuration

    internal val steps: MutableList<Boolean> = mutableListOf()

    internal lateinit var metronomePlayer: MediaPlayer
    internal lateinit var metronomeBeepDPlayer: MediaPlayer
    internal lateinit var metronomeBeepCPlayer: MediaPlayer
    internal lateinit var pad1Player: MediaPlayer
    internal lateinit var pad2Player: MediaPlayer
    internal lateinit var pad3Player: MediaPlayer
    internal lateinit var pad4Player: MediaPlayer
    internal lateinit var pad5Player: MediaPlayer
    internal lateinit var pad6Player: MediaPlayer
    internal lateinit var pad7Player: MediaPlayer
    internal lateinit var pad8Player: MediaPlayer
    internal lateinit var pad9Player: MediaPlayer
    internal lateinit var currentPlayer: MediaPlayer
}