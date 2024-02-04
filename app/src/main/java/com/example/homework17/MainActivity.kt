package com.example.homework17

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentContainerView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val fragmentContainer: FragmentContainerView = findViewById(R.id.fragmentContainer)


        ApiClient.api.getSuperheroes().enqueue(object : Callback<List<Hero>> {
            override fun onResponse(call: Call<List<Hero>>, response: Response<List<Hero>>) {
                val heroes = response.body() ?: emptyList()
                recyclerView.adapter = HeroAdapter(heroes) {
                    openHeroDetailFragment(it)
                    fragmentContainer.visibility = View.VISIBLE
                }
            }

            override fun onFailure(call: Call<List<Hero>>, t: Throwable) {
                Log.e("MainActivity", "Error fetching heroes", t)

                Toast.makeText(
                    this@MainActivity,
                    "Failed to fetch heroes: ${t.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        })

        supportFragmentManager.addOnBackStackChangedListener {
            if (supportFragmentManager.backStackEntryCount == 0) {
                fragmentContainer.visibility = View.GONE
            }
        }

    }

    private fun openHeroDetailFragment(hero: Hero) {
        Log.d("HeroAdapter", "Hero clicked: ${hero.name}")
        val fragment = HeroDetailsFragment().apply {
            arguments = Bundle().apply {
                putParcelable("hero", hero)
            }
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack("details_fragment")
            .commit()
    }
}