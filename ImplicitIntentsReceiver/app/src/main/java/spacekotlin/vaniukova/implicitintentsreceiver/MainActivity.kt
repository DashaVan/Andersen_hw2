package spacekotlin.vaniukova.implicitintentsreceiver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri
import spacekotlin.vaniukova.implicitintentsreceiver.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val uri: Uri? = intent.data
        if (uri != null) {
            binding.textUriMessage.text = (getString(R.string.uri_label) + uri.toString())
        }
    }
}