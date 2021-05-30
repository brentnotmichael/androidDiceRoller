package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 * Allows user to roll a Dice and view the result
 */
class MainActivity : AppCompatActivity() {
    // Android apps do not have a main() function, instead they call onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // create the two dice
        val dice1 = Dice(6)
        val dice2 = Dice(6)

        // on startup roll the dice
        rollDice(dice1, dice2)
        // saves a reference to the button object in rollButton value
        // resource id format: R.<type>.<name>; R.string.TextView
        val rollButton: Button = findViewById(R.id.rollButton)
        rollButton.setOnClickListener { rollDice(dice1, dice2) }
    }

    /**
     * Roll the dice and update with result
     */
    private fun rollDice(dice1: Dice, dice2: Dice) {
        // roll the dice using the roll method of the Dice object
        val diceRoll1 = dice1.roll()
        // store a reference to the rollValueView object
        // val resultTextView1: TextView = findViewById(R.id.rollValueView1)
        // convert roll to a string and update text of resultTextView
        // resultTextView1.text = diceRoll1.toString()

        // store a reference to the rollResult1 object
        val rollResult1: ImageView = findViewById(R.id.rollResult1)

        val drawableResource1 = when(diceRoll1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        rollResult1.setImageResource(drawableResource1)
        rollResult1.contentDescription = diceRoll1.toString()


        // roll the dice using the roll method of the Dice object
        val diceRoll2 = dice2.roll()
        // store a reference to the rollValueView object
        // val resultTextView2: TextView = findViewById(R.id.rollValueView2)
        // convert roll to a string and update text of resultTextView
        // resultTextView2.text = diceRoll2.toString()
        val rollResult2: ImageView = findViewById(R.id.rollResult2)

        val drawableResource2 = when(diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        rollResult2.setImageResource(drawableResource2)
        rollResult2.contentDescription = diceRoll2.toString()



        // show toast with sum of both rolls
        var total = diceRoll1 + diceRoll2
        var message = "Total: $total"
        if (diceRoll1 == diceRoll2) {
            // doubles
            if (diceRoll1 == 1) {
                // snake eyes
                message = "Snake eyes!"
            } else {
                message = "Double $diceRoll1's!"
            }
        }
        val messageText: TextView = findViewById(R.id.messageText)
        messageText.text = message



    }
}

// visibility modifier goes in the parens, public is assumed
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}