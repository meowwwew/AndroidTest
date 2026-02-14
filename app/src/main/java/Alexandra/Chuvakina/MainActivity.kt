package Alexandra.Chuvakina

import Alexandra.Chuvakina.databinding.ActivityMainBinding
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
//private val ActivityMainBinding.rollButton: Any

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            rollDice()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage: ImageView = binding.DiceOne
        when (diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.one)
            2 -> diceImage.setImageResource(R.drawable.two)
            3 -> diceImage.setImageResource(R.drawable.three)
            4 -> diceImage.setImageResource(R.drawable.four)
            5 -> diceImage.setImageResource(R.drawable.five)
            6 -> diceImage.setImageResource(R.drawable.six)
        }
    }

    class Dice(val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}


