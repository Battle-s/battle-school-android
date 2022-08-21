package com.umc.battles.ui.auth.tutorial.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.umc.battles.databinding.TutorialItemBinding

class RVTutorialAdapter(
    private val imgList: List<String>,
) :
    RecyclerView.Adapter<RVTutorialAdapter.ViewHolder>() {

    override fun getItemCount(): Int = imgList.size

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        TutorialItemBinding.inflate(
            LayoutInflater.from(viewGroup.context),
            viewGroup,
            false
        ), viewGroup.context
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(imgList[position])
    }


    inner class ViewHolder(val binding: TutorialItemBinding, val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(image: String) {
            Glide.with(context).load(image).into(binding.ivContent)
        }
    }
}