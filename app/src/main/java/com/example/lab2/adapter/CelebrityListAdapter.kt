package com.example.lab2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.model.entity.Celebrity

class CelebrityListAdapter : ListAdapter<Celebrity, CelebrityListAdapter.ViewHolder>(CelebrityDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCelebrityBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemCelebrityBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(celebrity: Celebrity) {
            with(binding) {
                name.text = celebrity.name
                netWorth.text = celebrity.netWorth.toString()
                age.text = celebrity.age.toString()
            }
        }
    }
}