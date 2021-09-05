package com.navi.assignment.app.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.navi.assignment.app.R
import com.navi.assignment.app.data.model.GithubDataModel

open class GithubListAdapter : RecyclerView.Adapter<ViewHolder>() {

    var list: MutableList<GithubDataModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val obj = list[position]
        holder.bind(obj)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("NotifyDataSetChanged")
    open fun updateList(li: List<GithubDataModel>) {
        this.list.clear()
        this.list = ArrayList(li)
        notifyDataSetChanged()
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title: AppCompatTextView = itemView.findViewById(R.id.title)
    val userName: AppCompatTextView = itemView.findViewById(R.id.userName)
    val createdDate: AppCompatTextView = itemView.findViewById(R.id.createdDate)
    val closedDate: AppCompatTextView = itemView.findViewById(R.id.closedDate)
    val avatarImage: AppCompatImageView = itemView.findViewById(R.id.avatarImage)

    fun bind(obj: GithubDataModel) {
        title.text = obj.title
        userName.text = obj.userName
        createdDate.text = obj.createdDate
        closedDate.text = obj.closedDate
    }
}