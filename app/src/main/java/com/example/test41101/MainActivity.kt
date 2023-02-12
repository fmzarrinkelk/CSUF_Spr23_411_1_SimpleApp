package com.example.test41101

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Switch
import android.widget.Toast

const val LOG_TAG = "MainActivity"

@SuppressLint("UseSwitchCompatOrMaterialCode")
class MainActivity : AppCompatActivity() {
    private lateinit var doSomethingButton: Button
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var seekBar: SeekBar
    private lateinit var switch: Switch
    private lateinit var editableText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        doSomethingButton = findViewById(R.id.doSomething)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        seekBar = findViewById(R.id.seekBar)
        switch = findViewById(R.id.switch1)
        editableText = findViewById(R.id.someEditableText)
        doSomethingButton.setOnClickListener { view: View ->
            val btn = view as Button
            val txt = btn.text.toString()
            println("this message is printed in the \"Run\" tab")
            Log.i(LOG_TAG, "my button $txt was called")
            Log.d(LOG_TAG, "this is a debug message")
            Toast.makeText(this, R.string.button_clicked, Toast.LENGTH_SHORT).show()
        }
        button1.setOnClickListener(buttonClickListener)
        button1.setOnLongClickListener(buttonLongClickListener)
        button2.setOnClickListener(buttonClickListener)
        button2.setOnLongClickListener(buttonLongClickListener)
        editableText.setOnKeyListener { view, i, keyEvent -> Boolean
            val txt = view as EditText
            Log.i(LOG_TAG, txt.text.toString())
            Log.i(LOG_TAG, "Test key pressed $i $keyEvent")
            false
        }
        switch.setOnClickListener {
            val sw: Switch = it as Switch
            Log.i(LOG_TAG, "switch clicked " + sw.isChecked)
        }
        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(sb: SeekBar?, p1: Int, p2: Boolean) {
                Log.i(LOG_TAG, "SeekBar value has changed ${sb?.progress}")
            }
            override fun onStartTrackingTouch(p0: SeekBar?) { }
            override fun onStopTrackingTouch(p0: SeekBar?) { }
        })
    }
    private val buttonClickListener = View.OnClickListener {
        val btn: Button = (it as Button)
        val message = getString(R.string.button_clicked)
        Log.i(LOG_TAG, "$message: ${btn.text}")
    }
    private val buttonLongClickListener = View.OnLongClickListener {
        val btn: Button = (it as Button)
        Log.i(LOG_TAG, "button long clicked ${btn.text}")
        true
    }
}