package com.bdn.collinsceleb.nigeriadevelopers

import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bdn.collinsceleb.nigeriadevelopers.data.model.GithubUser
import com.bdn.collinsceleb.nigeriadevelopers.ui.overview.OverviewAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import de.hdodenhof.circleimageview.CircleImageView


@BindingAdapter("listUser")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<GithubUser>?) {
    val adapter = recyclerView.adapter as OverviewAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(circleImageView: CircleImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(circleImageView.context)
            .load(imgUri)
            .apply(RequestOptions().placeholder(R.drawable.ic_launcher_background))
            .into(circleImageView)
    }
}