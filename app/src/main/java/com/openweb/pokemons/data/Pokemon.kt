package com.openweb.pokemons.data

import kotlinx.serialization.Serializable

@Serializable
data class Pokemon(
    val id: Int,
    val name: String,
    val description: String
) {
    fun imageFileName(): String {
        return String.format("pokemon_%03d", id)
    }
}
