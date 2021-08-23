package spacekotlin.vaniukova.helloconstraint

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import spacekotlin.vaniukova.helloconstraint.databinding.ActivityMainBinding

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

        binding.buttonZero.setOnClickListener {
            clickZero()
        }
    }

    private fun showToast() {
        Toast.makeText(applicationContext, R.string.toast_message, Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("ResourceAsColor")
    private fun countUp() {
        mCount++
        binding.showCount.text = mCount.toString()
        binding.buttonZero.setBackgroundColor(R.color.purple_200)
        if(mCount % 2 == 0){
            binding.buttonCount.setBackgroundColor(R.color.grey)
        }else{
            binding.buttonCount.setBackgroundColor(R.color.purple_200)
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun clickZero(){
        mCount = 0
        binding.showCount.text = mCount.toString()
        binding.buttonZero.setBackgroundColor(R.color.grey)
    }
}