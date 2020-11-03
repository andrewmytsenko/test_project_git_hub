package com.example.test_project_git_hub.ui.git_hub_project.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test_project_git_hub.databinding.ListItemProjectBinding
import com.example.test_project_git_hub.net.model.response.Project

class ProjectAdapter : RecyclerView.Adapter<ProjectAdapter.ViewHolder>() {
    var clickItem: ((idUser: Project) -> Unit)? = null

    private var items = mutableListOf<Project>()

    fun add(project: ArrayList<Project>) {
        items.addAll(project)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemProjectBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val menuItem = items[position]
        holder.bind(menuItem)
    }

    fun clear() {
        items.clear()
    }

    inner class ViewHolder(private val binding: ListItemProjectBinding) :
        RecyclerView.ViewHolder(binding.root), Handler {
        fun bind(model: Project) {
            binding.model = model
            binding.handler = this
            binding.executePendingBindings()
        }

        override fun onClick(userInfo: Project) {
            clickItem?.invoke(userInfo)

        }
    }

}