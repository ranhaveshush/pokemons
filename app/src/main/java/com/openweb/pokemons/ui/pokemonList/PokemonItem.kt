package com.openweb.pokemons.ui.pokemonList

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pokemons.R
import com.openweb.pokemons.ui.theme.AppTheme
import com.openweb.pokemons.state.PokemonListUiState

@Composable
fun PokemonItem(
    pokemon: PokemonListUiState,
    onPokemonClick: (Int) -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(AppTheme.shapes.medium)
            .clickable {
                onPokemonClick(pokemon.id)
            }
            .padding(AppTheme.padding.medium)

    ) {
        Image(
            painterResource(id = pokemon.image),
            contentDescription = "${pokemon.name} image",
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.height(AppTheme.padding.medium))
        Text(
            text = pokemon.name,
            color = AppTheme.colors.onPrimary,
            style = AppTheme.typography.body1
        )
    }
}

@Preview(name = "Light Theme", group = "Pokemon Item")
@Preview(name = "Dark Theme", group = "Pokemon Item", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewPokemonItem() {
    val pokemon = PokemonListUiState(
        id = 1,
        name = "Pikachu",
        image = R.drawable.pokemon_001
    )
    AppTheme {
        PokemonItem(
            pokemon = pokemon,
            onPokemonClick = {}
        )
    }
}
