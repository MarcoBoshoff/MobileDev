package com.example.core1

import android.R
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var opResult = 10
 /*   override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Log.i("STATE","Landscape")
        }
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Log.i("STATE","Portrait")
        }
    }

  */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("HP",opResult)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        savedInstanceState?.let {opResult = savedInstanceState.getInt("HP")}
        findViewById<TextView>(R.id.health).text = opResult.toString()

        val sneeze = findViewById<Button>(R.id.health)
        val blownose = findViewById<Button>(R.id.blow_nose)
        val meds = findViewById<Button>(R.id.Meds)
        sneeze.setOnClickListener {
            if (opResult > 0) {
                opResult--
                onScore()
            }
        }
        blownose.setOnClickListener {

        }
        meds.setOnClickListener {
            if (opResult == 10) {

            }else if (opResult == 9) {
                opResult++
            }else {
                opResult += 2
            }
            onScore()
        }
    }
    fun onScore(){
        val hp = findViewById<TextView>(R.id.health)
        hp.text = opResult.toString()
        Log.i("SCORE", "onScore: " + opResult)
        if (opResult <= 5) {
            hp.setTextColor(Color.RED)
        } else if (opResult <= 7){
            hp.setTextColor(Color.BLUE)
        } else hp.setTextColor(Color.BLACK)
    }
}