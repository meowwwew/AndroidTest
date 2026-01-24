package Alexandra.Chuvakina

import android.os.Bundle
import android.widget.Button
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
        val rollTextView: TextView=findViewById(R.id.textView2)
        rollTextView.text=diceRoll.toString()
    }
    class Dice(val numSides: Int){
        fun roll(): Int {
            return(1..numSides).random()
        }
    }
}


