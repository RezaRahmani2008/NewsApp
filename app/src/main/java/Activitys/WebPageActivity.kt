package Activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.example.newsapp.R

class WebPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_page)

        var webView = findViewById<WebView>(R.id.webView)
        var progressBar2 = findViewById<ProgressBar>(R.id.progressBar2)
        progressBar2.isVisible = true
        webView.loadUrl(intent.getStringExtra("url")!!)
        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                progressBar2.isInvisible = true
                webView.isVisible = true
            }
        }
    }
}