package com.bdn.collinsceleb.nigeriadevelopers.ui.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bdn.collinsceleb.nigeriadevelopers.data.model.GithubUser
import com.bdn.collinsceleb.nigeriadevelopers.databinding.DeveloperListItemBinding

class OverviewAdapter : ListAdapter<GithubUser, OverviewViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OverviewViewHolder {
        return OverviewViewHolder(DeveloperListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: OverviewViewHolder, position: Int) {
        val githubUser = getItem(position)
        holder.bind(githubUser)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<GithubUser>() {
        override fun areItemsTheSame(oldItem: GithubUser, newItem: GithubUser): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: GithubUser, newItem: GithubUser): Boolean {
            return oldItem == newItem
        }

    }
}