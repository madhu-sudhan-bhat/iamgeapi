package com.example.apifetch

import android.R.attr
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import android.R.attr.data
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.apifetch.fragment.FragmentTest

interface Communicator {
    fun passData(pos: DataFileItem ,image: String)
}
public class Adapter(private val list: ArrayList<DataFileItem>, private val listener: Communicator) :
    RecyclerView.Adapter<Adapter.ViewHolder>(), Communicator2 {
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



        holder.image.setOnClickListener { i ->
            when (i.id) {
                R.id.imageMain -> {
//                    Toast.makeText(i.context, list[position].download_url, Toast.LENGTH_SHORT).show()
                    Toast.makeText(i.context, i.id.toString(), Toast.LENGTH_SHORT).show()
                    var  cklpos = list[position];
                    var clkimagearams=list[position].download_url;
                    val listner2 : Communicator2 =(data,0);
                    listener.passData(cklpos,clkimagearams);
                    listner2.passData1(cklpos,clkimagearams)

//                    val fragmentest= FragmentTest();
//                    activity.supportFragmentManager.beginTransaction().replace(R.id.mainrl,fragmentest).addToBackStack(null).commit();

                }
            }

    }

    }

    override fun passData1(pos: DataFileItem, image: String) {

    }

}