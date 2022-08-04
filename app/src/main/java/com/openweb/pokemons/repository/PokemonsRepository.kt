package com.openweb.pokemons.repository

import com.openweb.pokemons.data.Pokemon

interface PokemonsRepository {
    suspend fun getPokemons(): List<Pokemon>
    suspend fun getPokemonById(pokemonId: Int): Pokemon?
}
