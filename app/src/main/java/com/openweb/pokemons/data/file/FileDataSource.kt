package com.openweb.pokemons.data.file

interface FileDataSource<T> {
    suspend fun readFile(): List<T>
}
