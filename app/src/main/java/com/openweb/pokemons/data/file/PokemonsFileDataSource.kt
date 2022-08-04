package com.openweb.pokemons.data.file

import android.content.res.AssetManager
import com.openweb.pokemons.data.Pokemon
import com.openweb.pokemons.data.serializer.JsonSerializer
import com.ranhaveshush.launcher.minimalistic.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

private const val POKEMONS_FILE_NAME = "pokemons.json"

class PokemonsFileDataSource @Inject constructor(
    private val manager: AssetManager,
    private val serializer: JsonSerializer,
    @IoDispatcher private val coroutineDispatcher: CoroutineDispatcher
) : FileDataSource<Pokemon> {
    // This function is main safe,since it is invoked on Dispatchers.IO.
    @Suppress("BlockingMethodInNonBlockingContext")
    override suspend fun readFile(): List<Pokemon> = withContext(coroutineDispatcher) {
        val inputStream = manager.open(POKEMONS_FILE_NAME)
        serializer.decodeFromStream(inputStream)
    }
}
