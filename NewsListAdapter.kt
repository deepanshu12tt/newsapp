package com.example.mynews




import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsListAdapter(private val listener:NewsitemClicked): RecyclerView.Adapter<NewsVieeHolder>() {
    private val items:ArrayList<News> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsVieeHolder{
        val view=LayoutInflater.from(parent.context).inflate(R.layout.itemnews,parent,false)
        val viewHolder=NewsVieeHolder(view)
        view.setOnClickListener{
            listener.onitemclicked(items[viewHolder.adapterPosition])
        }
        return viewHolder

    }

    override fun onBindViewHolder(holder: NewsVieeHolder, position: Int) {
        val curremtitem=items[position]
        holder.titleView.text=curremtitem.title
        holder.author.text=curremtitem.author
        Glide.with(holder.itemView.context).load(curremtitem.imagrUrl).into(holder.image)

    }

    override fun getItemCount(): Int {
        return items.size

    }
    fun undateNews(updtaedNews:ArrayList<News>){
        items.clear()
        items.addAll(updtaedNews)
        notifyDataSetChanged()
    }

}
class NewsVieeHolder(itemView: View):RecyclerView.ViewHolder(itemView)
{
    val titleView:TextView=itemView.findViewById(R.id.title)
    val image:ImageView=itemView.findViewById(R.id.imageview)
    val author:TextView=itemView.findViewById(R.id.author)
}
interface NewsitemClicked{
    fun onitemclicked(item:News)

}