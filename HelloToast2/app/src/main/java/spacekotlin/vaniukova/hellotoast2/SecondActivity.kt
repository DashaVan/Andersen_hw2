package spacekotlin.vaniukova.hellotoast2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import spacekotlin.vaniukova.hellotoast2.databinding.ActivityMainBinding
import spacekotlin.vaniukova.hellotoast2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        binding.textViewCount2.text = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
    }
}