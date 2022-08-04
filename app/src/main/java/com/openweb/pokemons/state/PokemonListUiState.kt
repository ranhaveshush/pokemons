package com.openweb.pokemons.state

import androidx.annotation.DrawableRes

data class PokemonListUiState(
    val id: Int,
    val name: String,
    @DrawableRes val image: Int
)
