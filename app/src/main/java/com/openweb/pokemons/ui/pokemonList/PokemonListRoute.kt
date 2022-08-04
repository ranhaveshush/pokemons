package com.openweb.pokemons.ui.pokemonList

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pokemons.R
import com.openweb.pokemons.state.*
import com.openweb.pokemons.ui.compose.common.EmptyText
import com.openweb.pokemons.ui.compose.common.ErrorText
import com.openweb.pokemons.ui.compose.common.ProgressIndicator
import com.openweb.pokemons.viewmodel.PokemonListViewModel

@Composable
fun PokemonListRoute(
    viewModel: PokemonListViewModel = hiltViewModel(),
    onPokemonClick: (Int) -> Unit
) {
    val result by viewModel.pokemons.collectAsState(Result.loading())

    when (result) {
        is LoadingResult -> ProgressIndicator()
        is EmptyResult -> EmptyText(message = "Oops, none pokemons were found.")
        is SuccessResult -> {
            val pokemons = (result as SuccessResult).data
            PokemonListScreen(
                title = stringResource(id = R.string.pokemons_list_title),
                subtitle = stringResource(id = R.string.pokemons_list_subtitle),
                pokemons = pokemons,
                onPokemonClick = onPokemonClick
            )
        }
        is ErrorResult -> {
            // TODO: convert to a user readable error message.
            val error = (result as ErrorResult)
            ErrorText(message = error.toString())
        }
    }
}
