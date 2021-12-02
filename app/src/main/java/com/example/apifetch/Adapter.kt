package com.example.apifetch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

public class Adapter(private val list: ArrayList<DataFileItem>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    private var mList: ArrayList<DataFileItem>? = null

    init {
        mList = list
    }

    public class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val Name: TextView = itemView.findViewById(R.id.Name)
        val image: ImageView = itemView.findViewById(R.id.imageMain)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false);
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.Name.text = list[position].author;
        Picasso.get().load(list[position].download_url).resize(700, 700).centerCrop().into(holder.image);
    }
}