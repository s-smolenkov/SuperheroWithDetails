package com.example.homework17

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.example.homework17.databinding.DetailsFragmentLayoutBinding

class HeroDetailsFragment : DialogFragment() {

    private var _binding: DetailsFragmentLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.CustomDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DetailsFragmentLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getParcelable<Hero>("hero")?.let { hero ->
            binding.heroName.text = hero.name
            Glide.with(this).load(hero.images.lg).into(binding.heroPhoto)
            "Full Name: ${hero.biography.fullName}".also { binding.fullName.text = it }
            "Place of Birth: ${hero.biography.placeOfBirth}".also { binding.placeOfBirth.text = it }
            "Aliases: ${hero.biography.aliases.joinToString(", ")}".also {
                binding.aliases.text = it
            }
            "Publisher: ${hero.biography.publisher}".also { binding.publisher.text = it }
            "Gender: ${hero.appearance.gender}".also { binding.gender.text = it }
            "Race: ${hero.appearance.race}".also { binding.race.text = it }
            "Height: ${hero.appearance.height.joinToString(", ")}".also { binding.height.text = it }
            "Weight: ${hero.appearance.weight.joinToString(", ")}".also { binding.weight.text = it }
            "Intelligence: ${hero.powerstats.intelligence}".also { binding.intelligence.text = it }
            "Strength: ${hero.powerstats.strength}".also { binding.strength.text = it }
            "Speed: ${hero.powerstats.speed}".also { binding.speed.text = it }
            "Durability: ${hero.powerstats.durability}".also { binding.durability.text = it }
            "Power: ${hero.powerstats.power}".also { binding.power.text = it }
            "Combat: ${hero.powerstats.combat}".also { binding.combat.text = it }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
    }
}