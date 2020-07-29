package com.bdn.collinsceleb.nigeriadevelopers.ui.overview

import androidx.recyclerview.widget.RecyclerView
import com.bdn.collinsceleb.nigeriadevelopers.data.model.GithubUser
import com.bdn.collinsceleb.nigeriadevelopers.databinding.DeveloperListItemBinding

class OverviewViewHolder(private var binding: DeveloperListItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(githubUser: GithubUser) {
        binding.developer = githubUser
        binding.executePendingBindings()
    }

}
