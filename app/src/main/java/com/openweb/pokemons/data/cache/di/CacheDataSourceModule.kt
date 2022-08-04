package com.openweb.pokemons.data.cache.di

import com.openweb.pokemons.data.cache.CacheDataSource
import com.openweb.pokemons.data.cache.PokemonsCacheDataSource
import com.openweb.pokemons.data.Pokemon
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class CacheDataSourceModule {
    @Singleton
    @Binds
    abstract fun bindCacheDataSource(datasource: PokemonsCacheDataSource): CacheDataSource<Pokemon>
}
