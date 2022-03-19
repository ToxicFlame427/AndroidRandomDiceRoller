package com.toxicflame427.randomdiceroller

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

lateinit var dice1 : ImageView
lateinit var dice2 : ImageView
lateinit var dice3 : ImageView
lateinit var dice4 : ImageView
lateinit var dice5 : ImageView
lateinit var dice6 : ImageView

lateinit var diceToRoll : EditText

lateinit var rollButton : Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectViews()

        rollButton.setOnClickListener{
            if(diceToRoll.text.toString().isEmpty()){
                Toast.makeText(this, "Please enter a number of dice to roll", Toast.LENGTH_SHORT).show()
            } else {
                if(Integer.parseInt(diceToRoll.text.toString()) < 0){
                    Toast.makeText(this, "Dice cannot be negative!", Toast.LENGTH_SHORT).show()
                } else if(Integer.parseInt(diceToRoll.text.toString()) > 6){
                    Toast.makeText(this, "Cannot roll more than 6 dice", Toast.LENGTH_SHORT).show()
                } else {
                    rollDice()
                }
            }
        }
    }

    fun connectViews(){
        dice1 = findViewById<ImageView>(R.id.dice_1)
        dice2 = findViewById<ImageView>(R.id.dice_2)
        dice3 = findViewById<ImageView>(R.id.dice_3)
        dice4 = findViewById<ImageView>(R.id.dice_4)
        dice5 = findViewById<ImageView>(R.id.dice_5)
        dice6 = findViewById<ImageView>(R.id.dice_6)

        diceToRoll = findViewById<EditText>(R.id.dice_roll_number)

        rollButton = findViewById<Button>(R.id.roll_button)
    }

    fun rollDice(){
        //Based on the numbers wanted to be rolled, the same amount of dice will be shown
        if(Integer.parseInt(diceToRoll.text.toString()) == 1){
            dice1.visibility = View.VISIBLE
            dice2.visibility = View.INVISIBLE
            dice3.visibility = View.INVISIBLE
            dice4.visibility = View.INVISIBLE
            dice5.visibility = View.INVISIBLE
            dice6.visibility = View.INVISIBLE
        } else if(Integer.parseInt(diceToRoll.text.toString()) == 2){
            dice1.visibility = View.VISIBLE
            dice2.visibility = View.VISIBLE
            dice3.visibility = View.INVISIBLE
            dice4.visibility = View.INVISIBLE
            dice5.visibility = View.INVISIBLE
            dice6.visibility = View.INVISIBLE
        } else if(Integer.parseInt(diceToRoll.text.toString()) == 3){
            dice1.visibility = View.VISIBLE
            dice2.visibility = View.VISIBLE
            dice3.visibility = View.VISIBLE
            dice4.visibility = View.INVISIBLE
            dice5.visibility = View.INVISIBLE
            dice6.visibility = View.INVISIBLE
        } else if(Integer.parseInt(diceToRoll.text.toString()) == 4){
            dice1.visibility = View.VISIBLE
            dice2.visibility = View.VISIBLE
            dice3.visibility = View.VISIBLE
            dice4.visibility = View.VISIBLE
            dice5.visibility = View.INVISIBLE
            dice6.visibility = View.INVISIBLE
        } else if(Integer.parseInt(diceToRoll.text.toString()) == 5){
            dice1.visibility = View.VISIBLE
            dice2.visibility = View.VISIBLE
            dice3.visibility = View.VISIBLE
            dice4.visibility = View.VISIBLE
            dice5.visibility = View.VISIBLE
            dice6.visibility = View.INVISIBLE
        } else if(Integer.parseInt(diceToRoll.text.toString()) == 6){
            dice1.visibility = View.VISIBLE
            dice2.visibility = View.VISIBLE
            dice3.visibility = View.VISIBLE
            dice4.visibility = View.VISIBLE
            dice5.visibility = View.VISIBLE
            dice6.visibility = View.VISIBLE
        } else if(Integer.parseInt(diceToRoll.text.toString()) == 0){
            //Nothing happens
        }

        if(Integer.parseInt(diceToRoll.text.toString()) != 0) {
            var diceArray = arrayOf(dice1, dice2, dice3, dice4, dice5, dice6)
            //Randomizes the dice
            for (item in diceArray) {
                var random = (1..6).random()
                when (random) {
                    1 -> item.setImageResource(R.drawable.dice_1)
                    2 -> item.setImageResource(R.drawable.dice_2)
                    3 -> item.setImageResource(R.drawable.dice_3)
                    4 -> item.setImageResource(R.drawable.dice_4)
                    5 -> item.setImageResource(R.drawable.dice_5)
                    6 -> item.setImageResource(R.drawable.dice_6)
                }
            }
        } else {
            Toast.makeText(this, "The value cannot be 0!", Toast.LENGTH_SHORT).show()
        }
    }
}