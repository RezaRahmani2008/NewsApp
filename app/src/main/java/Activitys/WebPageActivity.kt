package Activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsapp.R

class WebPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_page)

        var webView = findViewById<WebView>(R.id.webView)
        webView.loadUrl(intent.getStringExtra("url")!!)


    }
}