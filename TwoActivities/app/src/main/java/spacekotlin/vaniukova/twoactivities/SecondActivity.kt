package spacekotlin.vaniukova.twoactivities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import spacekotlin.vaniukova.twoactivities.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    companion object {
        const val EXTRA_REPLY = "spacekotlin.vaniukova.twoactivities.extra.REPLY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
        binding.textMessage.text = message

        binding.buttonSecond.setOnClickListener {
            sendReply()
        }
    }

    private fun sendReply() {
        val reply = binding.editTextSecond.text.toString()
        val classActivity = MainActivity::class.java
        val replyIntent = Intent(this, classActivity)
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(RESULT_OK, replyIntent)
        finish()
    }
}