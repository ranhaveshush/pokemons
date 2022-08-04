package com.openweb.pokemons.transformer

/**
 * Data transformer, transforms input data [T] to output data [R].
 */
interface DataTransformer<T, R> {
    fun transform(data: T): R

    fun transform(data: List<T>): List<R> {
        return data.map { item ->
            transform(item)
        }
    }
}
