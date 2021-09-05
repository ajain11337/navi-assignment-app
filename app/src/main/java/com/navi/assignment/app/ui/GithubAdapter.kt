package com.navi.assignment.app.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.navi.assignment.app.R
import com.navi.assignment.app.data.model.GithubDataModel
import androidx.databinding.ViewDataBinding
import com.navi.assignment.app.BR

open class GithubListAdapter : RecyclerView.Adapter<GithubViewHolder>() {

    var list: MutableList<GithubDataModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, R.layout.github_closed_list_item, parent, false)
        return GithubViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GithubViewHolder, position: Int) {
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

class GithubViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(obj: GithubDataModel) {
        binding.setVariable(BR.model, obj)
    }
}