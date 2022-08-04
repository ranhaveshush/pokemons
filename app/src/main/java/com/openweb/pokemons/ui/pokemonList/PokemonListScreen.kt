package com.openweb.pokemons.ui.pokemonList

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pokemons.R
import com.openweb.pokemons.state.PokemonListUiState
import com.openweb.pokemons.ui.compose.common.Toolbar
import com.openweb.pokemons.ui.theme.AppTheme

@Composable
fun PokemonListScreen(
    title: String,
    subtitle: String,
    pokemons: List<PokemonListUiState>,
    onPokemonClick: (Int) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Toolbar(title = title)

        Spacer(modifier = Modifier.padding(50.dp))

        Text(
            text = subtitle,
            color = Color.Blue,
            style = AppTheme.typography.body1,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(
                    horizontal = 50.dp
                )
        )

        Spacer(modifier = Modifier.padding(50.dp))

        LazyRow(
            contentPadding = PaddingValues(AppTheme.padding.medium),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(pokemons) { pokemon ->
                PokemonItem(
                    pokemon = pokemon,
                    onPokemonClick = onPokemonClick
                )
            }
        }
    }
}

@Preview(name = "Light Theme", group = "Home screen")
@Preview(name = "Dark Theme", group = "Home screen", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewPokemonListScreen() {
    val pokemon = PokemonListUiState(
        id = 1,
        name = "Pikachu",
        image = R.drawable.pokemon_001
    )

    val pokemons = listOf(
        pokemon,
        pokemon,
        pokemon
    )

    AppTheme {
        PokemonListScreen(
            title = "Pokemons",
            subtitle = "Bla bla",
            pokemons = pokemons,
            onPokemonClick = {})
    }
}
