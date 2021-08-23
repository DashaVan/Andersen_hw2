package spacekotlin.vaniukova.hellotoast2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import spacekotlin.vaniukova.hellotoast2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var mCount = 0

    companion object{
        const val EXTRA_MESSAGE = "spacekotlin.vaniukova.twoactivities.extra.MESSAGE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonToast.setOnClickListener {
            showSecondActivity()
        }

        binding.buttonCount.setOnClickListener {
            countUp()
        }
    }

    private fun showSecondActivity() {
        val classActivity = SecondActivity::class.java
        val mainActivityIntent = Intent(this, classActivity)
        mainActivityIntent.putExtra(EXTRA_MESSAGE, mCount.toString())
        startActivity(mainActivityIntent)
    }

    private fun countUp() {
        mCount++
        binding.showCount.text = mCount.toString()
    }
}