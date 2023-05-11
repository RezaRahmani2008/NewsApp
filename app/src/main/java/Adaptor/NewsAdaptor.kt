package Adaptor

class NewsAdaptor(var newsList: MutableList<News>, var context: Context):RecyclerView.Adapter<NewsAdaptor.viewHolder>() {
    inner class viewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView
        var description: TextView
        var dateAndWriter: TextView
        var image: ImageView

        init {
            view.apply {
                title = findViewById(R.id.titleTV)
                description = findViewById(R.id.descTV)
                dateAndWriter = findViewById(R.id.dateWriter)
                image = findViewById(R.id.imageView)
                title.setOnClickListener {
                    val intent = Intent(context, WebPageActivity::class.java)
                    intent.putExtra("url", newsList[adapterPosition].url)
                    context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_schma, parent, false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.apply {
            title.text = newsList[position].title
            description.text = newsList[position].description
            dateAndWriter.text = newsList[position].author + "\n" + newsList[position].publishedAt
            Glide.with(context).load(newsList[position].urlToImage).into(image)
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}