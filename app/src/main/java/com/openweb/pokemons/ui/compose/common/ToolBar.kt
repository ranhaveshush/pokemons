package com.openweb.pokemons.ui.compose.common

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.openweb.pokemons.ui.theme.AppTheme

@Composable
fun Toolbar(
    title: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(AppTheme.padding.large)
    ) {
        Text(
            text = title,
            color = AppTheme.colors.onPrimary,
            style = AppTheme.typography.h4
        )
    }
}

@Preview(name = "Light Theme", group = "Toolbar")
@Preview(name = "Dark Theme", group = "Toolbar", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewToolbar() {
    val title = "Pokemons"

    AppTheme {
        Toolbar(title = title)
    }
}
