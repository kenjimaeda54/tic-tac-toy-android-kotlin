package com.tictactoy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        buttonOne.setOnClickListener(this)
        buttonTwo.setOnClickListener(this)
        buttonThree.setOnClickListener(this)
        buttonFour.setOnClickListener(this)
        buttonFive.setOnClickListener(this)
        buttonSix.setOnClickListener(this)
        buttonSeven.setOnClickListener(this)
        buttonEight.setOnClickListener(this)
        buttonNine.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        var idClick = view.id;
        val numberClicked = when (idClick) {
            R.id.buttonOne -> 1
            R.id.buttonTwo -> 2
            R.id.buttonThree -> 3
            R.id.buttonFour -> 4
            R.id.buttonFive -> 5
            R.id.buttonSix -> 6
            R.id.buttonSeven -> 7
            R.id.buttonEight -> 8
            else -> 9
        }
        Log.d("clicked",numberClicked.toString())
    }
}