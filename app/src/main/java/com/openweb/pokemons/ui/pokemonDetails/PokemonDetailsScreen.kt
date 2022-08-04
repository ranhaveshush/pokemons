package com.openweb.pokemons.ui.pokemonDetails

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pokemons.R
import com.openweb.pokemons.state.PokemonDetailsUiState
import com.openweb.pokemons.ui.compose.common.Toolbar
import com.openweb.pokemons.ui.theme.AppTheme

@Composable
fun PokemonDetailsScreen(
    title: String,
    pokemon: PokemonDetailsUiState
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())

    ) {
        Toolbar(title = title)

        Spacer(modifier = Modifier.padding(50.dp))

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

        Spacer(modifier = Modifier.padding(50.dp))

        Text(
            text = pokemon.description,
            color = AppTheme.colors.onPrimary,
            style = AppTheme.typography.body1,
            modifier = Modifier.padding(AppTheme.padding.xLarge)
        )
    }
}

@Preview(name = "Light Theme", group = "Pokemon Details Screen")
@Preview(
    name = "Dark Theme",
    group = "Pokemon Details Screen",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PreviewPokemonDetailsScreen() {
    val pokemon = PokemonDetailsUiState(
        id = 1,
        name = "Pikachu",
        description = "This is a description",
        image = R.drawable.pokemon_001
    )

    AppTheme {
        PokemonDetailsScreen(
            title = "Pokemon",
            pokemon = pokemon
        )
    }
}
