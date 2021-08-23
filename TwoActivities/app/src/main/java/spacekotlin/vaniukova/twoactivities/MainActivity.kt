package spacekotlin.vaniukova.twoactivities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import spacekotlin.vaniukova.twoactivities.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val LOG_TAG = "MainActivity"
    private var message: String = ""

    private val activityLauncher = registerForActivityResult(MySecondActivityContract()) { result ->
        binding.textHeaderReply.isVisible = true
        binding.textMessageReply.text = result
        binding.textMessageReply.isVisible = true
    }

    companion object {
        const val EXTRA_MESSAGE = "spacekotlin.vaniukova.twoactivities.extra.MESSAGE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonMain.setOnClickListener {
            Log.d(LOG_TAG, "Button clicked!")

            message = binding.editTextMain.text.toString()
            activityLauncher.launch(message)
        }
    }
}