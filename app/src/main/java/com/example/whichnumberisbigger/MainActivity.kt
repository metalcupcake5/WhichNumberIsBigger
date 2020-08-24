package com.example.whichnumberisbigger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // if you need instance variables, you can make them here
    private var score = 0
    private var number1 = 0
    private var number2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // do your initial setup here in the onCreate
        // generate two random numbers
        // assign those numbers to the buttons
        randomizeNumbers()
        // set an initial score to 0
        score = 0
        textView_main_score.setText("Streak: " + score.toString())
    }

    fun onLeftClick(view: View) {
        if(number1 < number2){
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
            score = 0
            randomizeNumbers()
        }else{
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            score++
            randomizeNumbers()
        }
    }

    fun onRightClick(view: View){
        if(number1 > number2){
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
            score = 0
            randomizeNumbers()
        }else{
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            score++
            randomizeNumbers()
        }
    }

    private fun randomizeNumbers(){
        number1 = (Math.random() * 6 + 1).toInt()
        number2 = (Math.random() * 6 + 1).toInt()
        while(number2 === number1){
            number2 = (Math.random() * 6 + 1).toInt()
        }
        // assign those numbers to the buttons
        textView_main_score.setText("Streak: " + score.toString())
        button_main_left.setText(number1.toString())
        button_main_right.setText(number2.toString())
    }
}