package spacekotlin.vaniukova.counterhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import spacekotlin.vaniukova.counterhomework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var count = 0

    companion object {
        private const val KEY_COUNTER = "count"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(KEY_COUNTER)
            binding.textView.text = count.toString()
        }

        binding.button.setOnClickListener {
            count++
            binding.textView.text = count.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNTER, binding.textView.text.toString().toInt())
    }
}