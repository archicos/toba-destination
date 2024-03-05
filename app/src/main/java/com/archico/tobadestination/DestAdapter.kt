package com.archico.tobadestination

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class DestAdapter(
    private val context: Context,
    private val destination: List<Destination>,
    val listener:(Destination) -> Unit
) : RecyclerView.Adapter<DestAdapter.DestinationViewHolder>(){

    class DestinationViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imgDestination = view.findViewById<ImageView>(R.id.img_item_image)
        val nameDestination = view.findViewById<TextView>(R.id.tv_item_name)
        val descDestination = view.findViewById<TextView>(R.id.tv_item_desc)

        fun bindView(destination: Destination, listener: (Destination) -> Unit) {
            imgDestination.setImageResource(destination.imgDestination)
            nameDestination.text = destination.nameDestination
            descDestination.text = destination.descDestination
            itemView.setOnClickListener {
                listener(destination)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DestinationViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_destination, parent, false)
        return DestinationViewHolder(view)
    }

    override fun onBindViewHolder(holder: DestinationViewHolder, position: Int) {
        val currentDestination = destination[position]
        holder.bindView(currentDestination, listener)
    }

    override fun getItemCount(): Int {
        return destination.size
    }
}