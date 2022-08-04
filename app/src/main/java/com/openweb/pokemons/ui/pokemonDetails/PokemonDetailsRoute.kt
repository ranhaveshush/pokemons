package com.openweb.pokemons.ui.pokemonDetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pokemons.R
import com.openweb.pokemons.state.EmptyResult
import com.openweb.pokemons.state.ErrorResult
import com.openweb.pokemons.state.LoadingResult
import com.openweb.pokemons.state.SuccessResult
import com.openweb.pokemons.ui.compose.common.EmptyText
import com.openweb.pokemons.ui.compose.common.ErrorText
import com.openweb.pokemons.ui.compose.common.ProgressIndicator
import com.openweb.pokemons.viewmodel.PokemonDetailsViewModel

@Composable
fun PokemonDetailsRoute(
    pokemonId: Int,
    viewModel: PokemonDetailsViewModel = hiltViewModel()
) {
    val result by viewModel.getPokemonById(pokemonId = pokemonId).collectAsState()

    when (result) {
        is LoadingResult -> ProgressIndicator()
        is EmptyResult -> EmptyText(message = "Oops, pokemon was found.")
        is SuccessResult -> {
            val pokemon = (result as SuccessResult).data
            PokemonDetailsScreen(
                title = stringResource(id = R.string.pokemon_details_title),
                pokemon = pokemon
            )
        }
        is ErrorResult -> {
            // TODO: convert to a user readable error message.
            val error = (result as ErrorResult)
            ErrorText(message = error.toString())
        }
    }
}
