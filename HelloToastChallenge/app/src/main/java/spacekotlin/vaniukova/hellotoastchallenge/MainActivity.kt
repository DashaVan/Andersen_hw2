package spacekotlin.vaniukova.hellotoastchallenge

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import spacekotlin.vaniukova.hellotoastchallenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var mCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonToast.setOnClickListener {
            showToast()
        }

        binding.buttonCount.setOnClickListener {
            countUp()
        }
    }

    private fun showToast() {
        Toast.makeText(applicationContext, R.string.toast_message, Toast.LENGTH_SHORT).show()
    }

    private fun countUp() {
        mCount++
        binding.showCount.text = mCount.toString()
    }
}