package com.naveed.practice_arch.welcome.list

import androidx.recyclerview.widget.RecyclerView
import com.naveed.practice_arch.databinding.RowWelcomeItemBinding
import com.naveed.practice_arch.welcome.WelcomeListItem

class WelcomeViewHolder(
    private val binding: RowWelcomeItemBinding,
    private val onItemClicked: (Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: WelcomeListItem) {
        with(item) {
            binding.tvLabel.text = label
        }
        binding.root.setOnClickListener {
            onItemClicked(adapterPosition)
        }
    }
}