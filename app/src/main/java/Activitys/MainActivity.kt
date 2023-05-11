package Activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsapp.R

class MainActivity : AppCompatActivity() {
    private val newsList = mutableListOf<News>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        lifecycleScope.launch {
            val progressBar = findViewById<ProgressBar>(R.id.progressBar)
            progressBar.isVisible=true
            val response =
                Retrofit.Builder().baseUrl("https://newsapi.org/v2/").addConverterFactory(
                    GsonConverterFactory.create()
                ).build().create(API::class.java).getNews("techcrunch","c872d20c8c6f4fcab00b5db061601033")
            if (response.isSuccessful && response.body() != null){
                newsList.addAll(response.body()!!.articles)
                initialRecView()


                progressBar.isVisible=false

            }else
                Log.e("e","nothing")

        }
    }
    private fun initialRecView() {
        val recView = findViewById<RecyclerView>(R.id.recView)
        val newsAdaptor = NewsAdaptor(newsList, this)
        recView.adapter = newsAdaptor
        recView.layoutManager = LinearLayoutManager(this)
        val dividerItemDecoration =
            DividerItemDecoration(this,DividerItemDecoration.VERTICAL)
        recView.addItemDecoration(dividerItemDecoration)
    }
}