// MainActivity.kt

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.startingservices.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText: EditText = findViewById(R.id.editText)
        val startButton: Button = findViewById(R.id.startButton)

        startButton.setOnClickListener {
            val countDownValue = editText.text.toString().toIntOrNull() ?: 0

            val intent = Intent(this, CountdownService::class.java)
            intent.putExtra("countDownValue", countDownValue)

            startService(intent)
        }
    }
}
