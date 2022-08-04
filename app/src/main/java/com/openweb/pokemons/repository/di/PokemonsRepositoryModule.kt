package com.openweb.pokemons.repository.di

import com.openweb.pokemons.repository.PokemonsRepository
import com.openweb.pokemons.repository.PokemonsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class PokemonsRepositoryModule {
    @Singleton
    @Binds
    abstract fun bindPokemonsRepository(repository: PokemonsRepositoryImpl): PokemonsRepository
}
