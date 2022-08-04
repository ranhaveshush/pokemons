package com.openweb.pokemons.transformer

import android.content.Context
import android.content.res.Resources
import com.openweb.pokemons.data.Pokemon
import com.openweb.pokemons.state.PokemonDetailsUiState
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PokemonDetailsTransformer @Inject constructor(
    @ApplicationContext private val context: Context,
    private val resources: Resources
) : DataTransformer<Pokemon, PokemonDetailsUiState> {
    override fun transform(data: Pokemon): PokemonDetailsUiState {
        val drawableName = data.imageFileName()
        val drawableRes = resources.getIdentifier(drawableName, "drawable", context.packageName)

        return PokemonDetailsUiState(
            id = data.id,
            name = data.name,
            description = data.description,
            image = drawableRes
        )
    }
}
