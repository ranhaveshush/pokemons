package com.openweb.pokemons.data.file.di

import com.openweb.pokemons.data.file.FileDataSource
import com.openweb.pokemons.data.file.PokemonsFileDataSource
import com.openweb.pokemons.data.Pokemon
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class FileDataSourceModule {
    @Singleton
    @Binds
    abstract fun bindFileDataSource(datasource: PokemonsFileDataSource): FileDataSource<Pokemon>
}
