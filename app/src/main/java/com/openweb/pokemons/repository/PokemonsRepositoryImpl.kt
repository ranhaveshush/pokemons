package com.openweb.pokemons.repository

import com.openweb.pokemons.data.Pokemon
import com.openweb.pokemons.data.cache.CacheDataSource
import com.openweb.pokemons.data.file.FileDataSource
import com.ranhaveshush.launcher.minimalistic.di.DefaultDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonsRepositoryImpl @Inject constructor(
    private val fileDataSource: FileDataSource<Pokemon>,
    private val cacheDataSource: CacheDataSource<Pokemon>,
    @DefaultDispatcher private val coroutineDispatcher: CoroutineDispatcher
) : PokemonsRepository {
    override suspend fun getPokemons(): List<Pokemon> = withContext(coroutineDispatcher) {
        if (!cacheDataSource.isEmpty()) {
            cacheDataSource.getAll()
        } else {
            val pokemons = fileDataSource.readFile()
            cacheDataSource.addAll(pokemons)
            pokemons
        }
    }

    override suspend fun getPokemonById(pokemonId: Int): Pokemon? =
        withContext(coroutineDispatcher) {
            val pokemons = getPokemons()
            val foundPokemon = pokemons.find { pokemon ->
                pokemon.id == pokemonId
            }
            foundPokemon
        }
}
