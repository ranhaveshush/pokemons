
package com.openweb.pokemons.ui.compose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.constraintlayout.compose.ExperimentalMotionApi
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.openweb.pokemons.ui.compose.navigation.AppNavGraph
import com.openweb.pokemons.ui.theme.AppTheme

@ExperimentalComposeUiApi
@ExperimentalMotionApi
@ExperimentalMaterialApi
@ExperimentalMaterialNavigationApi
@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun BaseApp() {
    AppTheme {
        AppNavGraph()
    }
}
