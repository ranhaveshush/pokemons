package com.openweb.pokemons.ui.compose.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.plusAssign
import com.openweb.pokemons.ui.pokemonList.PokemonListRoute
import com.google.accompanist.navigation.material.BottomSheetNavigator
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.google.accompanist.pager.ExperimentalPagerApi
import com.openweb.pokemons.ui.pokemonDetails.PokemonDetailsRoute

@ExperimentalComposeUiApi
@ExperimentalMotionApi
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@ExperimentalMaterialNavigationApi
@ExperimentalPagerApi
@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController(),
    bottomSheetNavigator: BottomSheetNavigator = rememberBottomSheetNavigator(),
    startDestination: String = Screen.PokemonList.route
) {
    navController.navigatorProvider += bottomSheetNavigator

    ModalBottomSheetLayout(bottomSheetNavigator) {
        NavHost(navController, startDestination) {
            composable(route = Screen.PokemonList.route) {
                PokemonListRoute(
                    onPokemonClick = { pokemonId ->
                        navController.navigate(Screen.PokemonDetails.createRoute(pokemonId))
                    }
                )
            }
            composable(route = Screen.PokemonDetails.route) { backStackEntry ->
                val pokemonId = backStackEntry.arguments?.getString("pokemonId")
                // TODO: handle errors properly...
                requireNotNull(pokemonId) { "pokemonId shouldn't be null" }
                PokemonDetailsRoute(
                    pokemonId = pokemonId.toInt()
                )
            }
        }
    }
}
