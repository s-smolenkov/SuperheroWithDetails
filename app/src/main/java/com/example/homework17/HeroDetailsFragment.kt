package com.example.homework17

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class HeroDetailsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val name: TextView = view.findViewById(R.id.heroName)
        val image: ImageView = view.findViewById(R.id.heroPhoto)
        val fullName: TextView = view.findViewById(R.id.fullName)
        val placeOfBirth: TextView = view.findViewById(R.id.placeOfBirth)
        val aliases: TextView = view.findViewById(R.id.aliases)
        val publisher: TextView = view.findViewById(R.id.publisher)
        val gender: TextView = view.findViewById(R.id.gender)
        val race: TextView = view.findViewById(R.id.race)
        val height: TextView = view.findViewById(R.id.height)
        val weight: TextView = view.findViewById(R.id.weight)
        val intelligence: TextView = view.findViewById(R.id.intelligence)
        val strength: TextView = view.findViewById(R.id.strength)
        val speed: TextView = view.findViewById(R.id.speed)
        val durability: TextView = view.findViewById(R.id.durability)
        val power: TextView = view.findViewById(R.id.power)
        val combat: TextView = view.findViewById(R.id.combat)


        arguments?.getParcelable<Hero>("hero")?.let { hero ->
            name.text = hero.name
            Glide.with(this).load(hero.images.lg).into(image)
            fullName.text = "Full Name: ${hero.biography.fullName}"
            placeOfBirth.text = "Place of Birth: ${hero.biography.placeOfBirth}"
            aliases.text = "Aliases: ${hero.biography.aliases.joinToString(", ")}"
            publisher.text = "Publisher: ${hero.biography.publisher}"
            gender.text = "Gender: ${hero.appearance.gender}"
            race.text = "Race: ${hero.appearance.race}"
            height.text = "Height: ${hero.appearance.height.joinToString(", ")}"
            weight.text = "Weight: ${hero.appearance.weight.joinToString(", ")}"
            intelligence.text = "Intelligence: ${hero.powerstats.intelligence}"
            strength.text = "Strength: ${hero.powerstats.strength}"
            speed.text = "Speed: ${hero.powerstats.speed}"
            durability.text = "Durability: ${hero.powerstats.durability}"
            power.text = "Power: ${hero.powerstats.power}"
            combat.text = "Combat: ${hero.powerstats.combat}"

        }
    }
}