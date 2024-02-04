package com.example.homework17

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    @SerializedName("name") var name: String,
    @SerializedName("powerstats") var powerstats: Powerstats,
    @SerializedName("appearance") var appearance: Appearance,
    @SerializedName("biography") var biography: Biography,
    @SerializedName("images") var images: Images
) : Parcelable

@Parcelize
data class Powerstats(
    @SerializedName("intelligence") var intelligence: String,
    @SerializedName("strength") var strength: String,
    @SerializedName("speed") var speed: String,
    @SerializedName("durability") var durability: String,
    @SerializedName("power") var power: String,
    @SerializedName("combat") var combat: String
) : Parcelable

@Parcelize
data class Appearance(
    @SerializedName("gender") var gender: String,
    @SerializedName("race") var race: String,
    @SerializedName("height") var height: ArrayList<String>,
    @SerializedName("weight") var weight: ArrayList<String>,
) : Parcelable

@Parcelize
data class Biography(
    @SerializedName("fullName") var fullName: String,
    @SerializedName("aliases") var aliases: ArrayList<String>,
    @SerializedName("placeOfBirth") var placeOfBirth: String,
    @SerializedName("publisher") var publisher: String,
) : Parcelable

@Parcelize
data class Images(
    @SerializedName("sm") var sm: String,
    @SerializedName("lg") var lg: String
) : Parcelable
