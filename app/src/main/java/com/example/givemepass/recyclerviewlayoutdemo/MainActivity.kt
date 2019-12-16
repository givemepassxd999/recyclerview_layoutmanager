package com.example.givemepass.recyclerviewlayoutdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listItem = ArrayList<String>()
        for (i in 0..99) {
            listItem.add(i.toString() + "")
        }
        val myAdapter = MyAdapter(listItem)
        val mList = findViewById<View>(R.id.list_view) as RecyclerView
        val layoutManager = GridLayoutManager(this, 3)
        mList.layoutManager = layoutManager
        mList.adapter = myAdapter
    }
}

class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val mTextView: TextView = v.findViewById(R.id.info_text)

}

class MyAdapter(private val mData: List<String>) : RecyclerView.Adapter<ViewHolder>() {
    private val mRandom = Random()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mTextView.text = mData[position]
        holder.mTextView.layoutParams.height = getRandomIntInRange(750, 75)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    private fun getRandomIntInRange(max: Int, min: Int): Int {
        return mRandom.nextInt(max - min + min) + min
    }
}
