package com.naveed.practice_arch.welcome.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.naveed.practice_arch.databinding.RowWelcomeItemBinding
import com.naveed.practice_arch.welcome.WelcomeListItem

class WelcomeRecyclerAdapter(
    private val items: List<WelcomeListItem>,
    private val onItemClicked: (Int) -> Unit
): RecyclerView.Adapter<WelcomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WelcomeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RowWelcomeItemBinding.inflate(inflater, parent, false)
        return WelcomeViewHolder(binding, onItemClicked)
    }

    override fun onBindViewHolder(holder: WelcomeViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}