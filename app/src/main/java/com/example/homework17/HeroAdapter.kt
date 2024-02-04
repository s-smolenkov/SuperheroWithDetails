package com.example.homework17

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class HeroAdapter(private val heroes: List<Hero>, private val onClick: (Hero) -> Unit) :
    RecyclerView.Adapter<HeroAdapter.HeroViewHolder>() {

    class HeroViewHolder(itemView: View, val onClick: (Hero) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.findViewById(R.id.heroNameToList)
        private val image: ImageView = itemView.findViewById(R.id.photoToList)
        private var currentHero: Hero? = null

        init {
            itemView.setOnClickListener {
                currentHero?.let(onClick)
            }
        }

        fun bind(hero: Hero) {
            name.text = hero.name
            Glide.with(itemView.context).load(hero.images.sm).into(image)
            itemView.setOnClickListener { onClick(hero) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_layout, parent, false)
        return HeroViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val hero = heroes[position]
        holder.bind(hero)
    }

    override fun getItemCount() = heroes.size
}
