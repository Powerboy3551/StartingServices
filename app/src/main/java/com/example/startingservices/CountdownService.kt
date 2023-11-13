import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class CountdownService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val countDownValue = intent?.getIntExtra("countDownValue", 0) ?: 0

        CoroutineScope(Dispatchers.Default).launch {
            for (i in countDownValue downTo 0) {
                Log.d("CountdownService", "Countdown: $i")
                delay(1000) // 1 second delay
            }

            stopSelf() // Stop the service when countdown is complete
        }

        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
