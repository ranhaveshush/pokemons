package com.openweb.pokemons.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.openweb.pokemons.repository.PokemonsRepository
import com.openweb.pokemons.state.Result
import com.openweb.pokemons.transformer.PokemonDetailsTransformer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    private val repository: PokemonsRepository,
    private val transformer: PokemonDetailsTransformer
) : ViewModel() {
    fun getPokemonById(pokemonId: Int) = flow {
        val pokemon = repository.getPokemonById(pokemonId)
        val result = if (pokemon == null) {
            Result.empty()
        } else {
            val pokemonDetails = transformer.transform(pokemon)
            Result.success(pokemonDetails)
        }
        emit(result)
    }.catch { e ->
        emit(Result.error(e))
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        Result.loading()
    )
}
