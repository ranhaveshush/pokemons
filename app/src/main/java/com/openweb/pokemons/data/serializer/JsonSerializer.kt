package com.openweb.pokemons.data.serializer

import java.io.InputStream

interface JsonSerializer {
    fun <T> decodeFromStream(stream: InputStream): T
}
