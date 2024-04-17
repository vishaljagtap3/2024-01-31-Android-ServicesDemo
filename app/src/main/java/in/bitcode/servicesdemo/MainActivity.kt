package `in`.bitcode.servicesdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import `in`.bitcode.servicesdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            val intent = Intent(this, DemoService::class.java)
            intent.putExtra("path", binding.edtData.text.toString())
            startService(intent)
        }

        binding.btnStop.setOnClickListener {
            val intent = Intent(this, DemoService::class.java)
            stopService(intent)
        }

        binding.btnStartActivity.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        mt("onNewIntent")
    }

    private fun mt(text : String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}