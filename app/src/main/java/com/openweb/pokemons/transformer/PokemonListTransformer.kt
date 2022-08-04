package com.openweb.pokemons.transformer

import android.content.Context
import android.content.res.Resources
import com.openweb.pokemons.data.Pokemon
import com.openweb.pokemons.state.PokemonListUiState
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PokemonListTransformer @Inject constructor(
    @ApplicationContext private val context: Context,
    private val resources: Resources
) : DataTransformer<Pokemon, PokemonListUiState> {
    override fun transform(data: Pokemon): PokemonListUiState {
        val drawableName = data.imageFileName()
        val drawableRes = resources.getIdentifier(drawableName, "drawable", context.packageName)

        return PokemonListUiState(
            id = data.id,
            name = data.name,
            image = drawableRes
        )
    }
}
