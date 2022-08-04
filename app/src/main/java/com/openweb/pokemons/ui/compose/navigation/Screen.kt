package com.openweb.pokemons.ui.compose.navigation

sealed class Screen(val route: String) {
    object PokemonList : Screen("pokemon_list")
    object PokemonDetails : Screen("pokemon/{pokemonId}") {
        fun createRoute(pokemonId: Int) = "pokemon/$pokemonId"
    }
}
