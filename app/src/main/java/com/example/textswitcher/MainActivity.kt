package com.example.textswitcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextSwitcher
import android.widget.TextView
import android.widget.ViewSwitcher

class MainActivity : AppCompatActivity() {
    lateinit var textSwitcher: TextSwitcher
    lateinit var buttonNext:Button
    lateinit var buttonBack:Button
    val textArray = arrayOf("TextView 1","TextView 2","TextView 3","TextView 4","TextView 5","TextView 6","TextView 70")
    var pos :Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textSwitcher = findViewById(R.id.textSwitcher)
        buttonNext = findViewById(R.id.next)
        buttonBack = findViewById(R.id.back)

        textSwitcher.setFactory(object :ViewSwitcher.ViewFactory{

            override fun makeView(): View {
                val textView = TextView(this@MainActivity)
                textView.textSize = 20F
                textView.gravity = Gravity.CENTER
                return textView
            }
        })
        buttonBack.setOnClickListener {
            if ( pos>0)
            {
                pos -=1
                textSwitcher.setText(textArray[pos])
            }
        }
        buttonNext.setOnClickListener {
            if (pos < textArray.size)
            {
                pos += 1
                textSwitcher.setText(textArray[pos])
            }
        }
    }
}