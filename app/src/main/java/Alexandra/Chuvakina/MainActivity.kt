package Alexandra.Chuvakina

import Alexandra.Chuvakina.R.id.DiceOne
import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val rollButton: Button=findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()

        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

    }
    private fun rollDice() {
        val dice= Dice(6)
        val diceRoll=dice.roll()
        val diceImage: ImageView = findViewById(DiceOne)
        if (diceRoll==1){
            diceImage.setImageResource(R.drawable.one)
        } else if (diceRoll==2){
            diceImage.setImageResource(R.drawable.two)
        } else if (diceRoll==3){
            diceImage.setImageResource(R.drawable.three)
        } else if (diceRoll==4){
            diceImage.setImageResource(R.drawable.four)
        } else if (diceRoll==5){
            diceImage.setImageResource(R.drawable.five)
        }else if (diceRoll==6){
            diceImage.setImageResource(R.drawable.six)
        }

    }
    class Dice(val numSides: Int){
        fun roll(): Int {
            return(1..numSides).random()
        }
    }
}


