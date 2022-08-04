package com.openweb.pokemons.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.openweb.pokemons.repository.PokemonsRepository
import com.openweb.pokemons.state.PokemonListUiState
import com.openweb.pokemons.state.Result
import com.openweb.pokemons.transformer.PokemonListTransformer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val repository: PokemonsRepository,
    private val transformer: PokemonListTransformer
) : ViewModel() {
    val pokemons = flow<Result<List<PokemonListUiState>>> {
        val pokemons = repository.getPokemons()
        val pokemonsList = transformer.transform(pokemons)
        emit(Result.success(pokemonsList))
    }.catch { e ->
        emit(Result.error(e))
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        Result.loading()
    )
}
