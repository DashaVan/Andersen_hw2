package spacekotlin.vaniukova.twoactivities

import android.os.Bundle
import android.util.Log
import android.view.View
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
        Log.d(LOG_TAG, "onCreate")
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState!=null){
            val isVisible = savedInstanceState.getBoolean("reply_visible")
            if (isVisible) {
                binding.textHeaderReply.visibility = View.VISIBLE
                binding.textMessageReply.text = savedInstanceState.getString("reply_text")
                binding.textMessageReply.visibility = View.VISIBLE
            }
        }

        binding.buttonMain.setOnClickListener {
            Log.d(LOG_TAG, "Button clicked!")

            message = binding.editTextMain.text.toString()
            activityLauncher.launch(message)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        if (binding.textHeaderReply.visibility == View.VISIBLE) {
            outState.putBoolean("reply_visible", true)
            outState.putString("reply_text", binding.textMessageReply.text.toString())
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "onPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG, "onRestart")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy")
    }
}