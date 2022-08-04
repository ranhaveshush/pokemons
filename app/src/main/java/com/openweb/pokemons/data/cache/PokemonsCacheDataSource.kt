package com.openweb.pokemons.data.cache

import com.openweb.pokemons.data.Pokemon
import javax.inject.Inject

class PokemonsCacheDataSource @Inject constructor() : CacheDataSource<Pokemon> {
    private val cache = mutableMapOf<Int, Pokemon>()

    override suspend fun addAll(items: List<Pokemon>) {
        cache.clear()
        for (item in items) {
            cache[item.id] = item
        }
    }

    override suspend fun getAll(): List<Pokemon> {
        return cache.values.toList()
    }

    override fun isEmpty() = cache.isEmpty()
}
