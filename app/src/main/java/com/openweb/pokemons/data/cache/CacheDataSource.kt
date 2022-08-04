package com.openweb.pokemons.data.cache

interface CacheDataSource<T> {
    suspend fun addAll(items: List<T>)
    suspend fun getAll(): List<T>
    fun isEmpty(): Boolean
}
