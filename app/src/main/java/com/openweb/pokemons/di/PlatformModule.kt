package com.openweb.pokemons.di

import android.content.Context
import android.content.res.AssetManager
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class PlatformModule {
    @Provides
    fun provideResource(
        @ApplicationContext context: Context
    ): Resources = context.resources

    @Provides
    fun provideAssetManager(
        @ApplicationContext context: Context
    ): AssetManager = context.assets
}
