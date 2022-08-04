package com.openweb.pokemons.ui

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ExperimentalMotionApi
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.openweb.pokemons.ui.compose.BaseApp
import com.openweb.pokemons.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMotionApi
@ExperimentalFoundationApi
@ExperimentalPagerApi
@ExperimentalComposeUiApi
@ExperimentalMaterialNavigationApi
@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaseApp()
        }
    }
}

@ExperimentalComposeUiApi
@ExperimentalMotionApi
@ExperimentalMaterialApi
@ExperimentalMaterialNavigationApi
@ExperimentalPagerApi
@ExperimentalFoundationApi
@Preview(name = "Light Theme", group = "Home App Item", showSystemUi = true, showBackground = true)
@Preview(
    name = "Dark Theme",
    group = "Home App Item",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showSystemUi = true,
    showBackground = true
)
@Composable
fun DefaultPreview() {
    AppTheme {
        BaseApp()
    }
}
