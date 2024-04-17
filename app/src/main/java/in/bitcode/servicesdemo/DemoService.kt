package `in`.bitcode.servicesdemo

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class DemoService : Service() {

    override fun onCreate() {
        super.onCreate()
        mt("onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mt("onStartCommand - $startId")
        if (intent != null) {
            mt("Playing: ${intent.getStringExtra("path")}")
        }
        return START_REDELIVER_INTENT
    }

    override fun onDestroy() {
        mt("onDestroy")
        super.onDestroy()
    }

    private fun mt(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}