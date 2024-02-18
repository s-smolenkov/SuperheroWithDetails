package com.example.homework17

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework17.databinding.ListItemLayoutBinding

class HeroAdapter(private var heroes: List<Hero>, private val onClick: (Hero) -> Unit) :
    RecyclerView.Adapter<HeroAdapter.HeroViewHolder>() {

    class HeroViewHolder(private val binding: ListItemLayoutBinding, val onClick: (Hero) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(hero: Hero) {
            with(binding) {
                heroNameToList.text = hero.name
                Glide.with(root.context).load(hero.images.sm).into(photoToList)
                root.setOnClickListener { onClick(hero) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val binding = ListItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HeroViewHolder(binding, onClick)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val hero = heroes[position]
        holder.bind(hero)
    }

    override fun getItemCount() = heroes.size
}