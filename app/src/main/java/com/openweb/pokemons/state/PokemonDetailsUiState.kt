package com.openweb.pokemons.state

import androidx.annotation.DrawableRes

data class PokemonDetailsUiState(
    val id: Int,
    val name: String,
    val description: String,
    @DrawableRes val image: Int
)
