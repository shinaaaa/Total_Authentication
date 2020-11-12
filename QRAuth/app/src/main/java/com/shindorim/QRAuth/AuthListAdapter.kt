package com.shindorim.QRAuth

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class AuthListAdapter(val itemList: ArrayList<AuthList>) :
    RecyclerView.Adapter<AuthListAdapter.ViewHolder>() {
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val inflatedView =
            LayoutInflater.from(parent.context).inflate(R.layout.auth_item_list, parent, false)
        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.ic_item.setImageDrawable(item.icon)
        holder.txt_item.text = item.text

        holder.itemView.setOnClickListener {
            val intent = Intent.parseUri(item.link, Intent.URI_INTENT_SCHEME)

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ic_item = itemView.findViewById(R.id.ic_item) as ImageView
        var txt_item = itemView.findViewById(R.id.txt_item) as TextView
    }
}