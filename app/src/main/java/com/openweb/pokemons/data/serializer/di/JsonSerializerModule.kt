package com.openweb.pokemons.data.serializer.di

import com.openweb.pokemons.data.Pokemon
import com.openweb.pokemons.data.serializer.JsonSerializer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import java.io.InputStream
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class JsonSerializerModule {
    @Singleton
    @Provides
    fun provideJsonSerializer(): JsonSerializer {
        return object : JsonSerializer {
            override fun <T> decodeFromStream(stream: InputStream): T {
                return Json.decodeFromStream<List<Pokemon>>(stream) as T
            }
        }
    }
}
