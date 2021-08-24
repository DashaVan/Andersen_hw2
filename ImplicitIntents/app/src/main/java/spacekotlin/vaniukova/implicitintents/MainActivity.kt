package spacekotlin.vaniukova.implicitintents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import spacekotlin.vaniukova.implicitintents.databinding.ActivityMainBinding
import androidx.core.app.ShareCompat
import android.provider.MediaStore




class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.openLocationButton.setOnClickListener {
            val loc: String = binding.locationEditText.text.toString()
            val addressUri = Uri.parse("geo:0,0?q=$loc")
            val intent = Intent(Intent.ACTION_VIEW, addressUri)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Log.d("ImplicitIntents", "Can't handle this intent!")
            }
        }

        binding.openWebsiteButton.setOnClickListener {
            val url = binding.websiteEditText.text.toString()
            val webpage: Uri = Uri.parse(url)
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Log.d("ImplicitIntents", "Can't handle this!");
            }
        }

        binding.shareTextButton.setOnClickListener {
            val txt: String = binding.shareEditText.text.toString()
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(txt)
                .startChooser()
        }

        binding.buttonTakePicture.setOnClickListener {
            val intent = Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA)
            startActivity(intent)
        }
    }
}