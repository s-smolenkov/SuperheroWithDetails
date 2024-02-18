package com.example.homework17

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework17.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: HeroesViewModel
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(
            this,
            HeroesViewModelFactory(HeroesRepository(ApiClient.api))
        )[HeroesViewModel::class.java]

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.heroes.observe(this, Observer { heroes ->
            binding.recyclerView.adapter = HeroAdapter(heroes) { hero ->
                openHeroDetailFragment(hero)
            }
        })

        viewModel.error.observe(this, Observer { errorMessage ->
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
        })
    }

    private fun openHeroDetailFragment(hero: Hero) {
        Log.d("HeroAdapter", "Hero clicked: ${hero.name}")
        val fragment = HeroDetailsFragment().apply {
            arguments = Bundle().apply {
                putParcelable("hero", hero)
            }
        }
        fragment.show(supportFragmentManager, "heroDetails")
    }
}